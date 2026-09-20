package com.design.appproject.ui.jiankangzhishi

import android.Manifest
import com.union.union_basic.permission.PermissionUtil
import com.design.appproject.ext.UrlPrefix
import androidx.core.widget.addTextChangedListener
import android.widget.CheckBox
import android.widget.RadioButton
import androidx.core.view.isVisible
import androidx.core.view.children
import com.design.appproject.utils.Utils
import com.design.appproject.bean.BaiKeBean
import androidx.core.app.ActivityCompat.startActivityForResult
import com.blankj.utilcode.util.UriUtils
import android.content.Intent
import com.alibaba.android.arouter.launcher.ARouter
import com.google.gson.internal.LinkedTreeMap
import com.union.union_basic.ext.*
import com.blankj.utilcode.util.RegexUtils
import com.union.union_basic.utils.StorageUtil
import com.github.gzuliyujiang.wheelpicker.DatimePicker
import com.design.appproject.widget.BottomSpinner
import com.design.appproject.base.CommonBean
import com.blankj.utilcode.util.TimeUtils
import com.github.gzuliyujiang.wheelpicker.DatePicker
import com.github.gzuliyujiang.wheelpicker.entity.DateEntity
import com.github.gzuliyujiang.wheelpicker.entity.DatimeEntity
import com.github.gzuliyujiang.wheelpicker.impl.BirthdayFormatter
import com.github.gzuliyujiang.wheelpicker.impl.UnitTimeFormatter
import java.text.SimpleDateFormat
import com.design.appproject.logic.repository.HomeRepository
import com.design.appproject.logic.repository.UserRepository
import com.union.union_basic.image.selector.SmartPictureSelector
import java.io.File
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.design.appproject.base.BaseBindingActivity
import com.design.appproject.base.CommonArouteApi
import com.design.appproject.bean.JiankangzhishiItemBean
import com.design.appproject.databinding.JiankangzhishiaddorupdateLayoutBinding
import com.design.appproject.ext.load
import android.text.InputType

/**
 * 健康知识新增或修改类
 */
@Route(path = CommonArouteApi.PATH_ACTIVITY_ADDORUPDATE_JIANKANGZHISHI)
class AddOrUpdateActivity:BaseBindingActivity<JiankangzhishiaddorupdateLayoutBinding>() {

    @JvmField
    @Autowired
    var mId: Long = 0L /*id*/

    @JvmField
    @Autowired
    var mRefid: Long = 0 /*refid数据*/

    /**上传数据*/
    var mJiankangzhishiItemBean = JiankangzhishiItemBean()

    override fun initEvent() {
        setBarTitle("健康知识")
        setBarColor("#FFFFFF","black")
        if (mRefid>0){/*如果上一级页面传递了refid，获取改refid数据信息*/
            if (mJiankangzhishiItemBean.javaClass.declaredFields.any{it.name == "refid"}){
                mJiankangzhishiItemBean.javaClass.getDeclaredField("refid").also { it.isAccessible=true }.let {
                    it.set(mJiankangzhishiItemBean,mRefid)
                }
            }
            if (mJiankangzhishiItemBean.javaClass.declaredFields.any{it.name == "nickname"}){
                mJiankangzhishiItemBean.javaClass.getDeclaredField("nickname").also { it.isAccessible=true }.let {
                    it.set(mJiankangzhishiItemBean,StorageUtil.decodeString(CommonBean.USERNAME_KEY)?:"")
                }
            }
        }
        if (Utils.isLogin() && mJiankangzhishiItemBean.javaClass.declaredFields.any{it.name == "userid"}){/*如果有登陆，获取登陆后保存的userid*/
            mJiankangzhishiItemBean.javaClass.getDeclaredField("userid").also { it.isAccessible=true }.let {
                it.set(mJiankangzhishiItemBean,Utils.getUserId())
            }
        }
        binding.initView()

        binding.neirongRichLayout.apply{
            actionBold.setOnClickListener {
                richEt.setBold()
            }
            actionItalic.setOnClickListener {
                richEt.setItalic()
            }
            actionStrikethrough.setOnClickListener {
                richEt.setStrikeThrough()
            }
            actionUnderline.setOnClickListener {
                richEt.setUnderline()
            }
            actionHeading1.setOnClickListener {
                richEt.setHeading(1)
            }
            actionHeading2.setOnClickListener {
                richEt.setHeading(2)
            }
            actionHeading3.setOnClickListener {
                richEt.setHeading(3)
            }
            actionHeading4.setOnClickListener {
                richEt.setHeading(4)
            }
            actionHeading5.setOnClickListener {
                richEt.setHeading(5)
            }
            actionIndent.setOnClickListener {
                richEt.setIndent()
            }
            actionOutdent.setOnClickListener {
                richEt.setOutdent()
            }
            actionAlignCenter.setOnClickListener {
                richEt.setAlignCenter()
            }
            actionAlignLeft.setOnClickListener {
                richEt.setAlignLeft()
            }
            actionAlignRight.setOnClickListener {
                richEt.setAlignRight()
            }
            actionInsertBullets.setOnClickListener {
                richEt.setBullets()
            }
            actionInsertNumbers.setOnClickListener {
                richEt.setNumbers()
            }
            actionInsertImage.setOnClickListener {
                SmartPictureSelector.openPicture(this@AddOrUpdateActivity) {
                    val path = it[0]
                    UserRepository.upload(File(path),"").observeKt {
                        it.getOrNull()?.let {
                            richEt.insertImage(UrlPrefix.URL_PREFIX+"file/" + it.file, "dachshund", 320)
                        }
                    }
                }
            }
        }
    }

    fun JiankangzhishiaddorupdateLayoutBinding.initView(){
             tupianLl.setOnClickListener {
            SmartPictureSelector.openPicture(this@AddOrUpdateActivity) {
                val path = it[0]
                showLoading("上传中...")
                UserRepository.upload(File(path), "tupian").observeKt{
                    it.getOrNull()?.let {
                        tupianIfv.load(this@AddOrUpdateActivity, "file/"+it.file)
                        mJiankangzhishiItemBean.tupian = "file/" + it.file
                    }
                }
            }
        }
            val mfabiaoriqiPicker = DatePicker(this@AddOrUpdateActivity).apply {
                wheelLayout.setDateFormatter(BirthdayFormatter())
                wheelLayout.setRange(DateEntity.target(1923, 1, 1),DateEntity.target(2050, 12, 31), DateEntity.today())
                setOnDatePickedListener { year, month, day ->
                    fabiaoriqiTv.text = "$year-$month-$day"
                    mJiankangzhishiItemBean.fabiaoriqi="$year-$month-$day"
                }
        }
            fabiaoriqiTv.setOnClickListener {
            mfabiaoriqiPicker.show()
        }
            submitBtn.setOnClickListener{/*提交*/
                submit()
            }
            setData()
    }

    lateinit var mUserBean:LinkedTreeMap<String, Any>/*当前用户数据*/

    override fun initData() {
        super.initData()
        UserRepository.session<Any>().observeKt {
            it.getOrNull()?.let {
                it.data.toConversion<LinkedTreeMap<String, Any>>()?.let {
                    mUserBean = it
                    it["touxiang"]?.let { it1 -> StorageUtil.encode(CommonBean.HEAD_URL_KEY, it1) }
                    /**ss读取*/
                    binding.setData()
                }
            }
        }

        (mId>0).yes {/*更新操作*/
            HomeRepository.info<JiankangzhishiItemBean>("jiankangzhishi",mId).observeKt {
                it.getOrNull()?.let {
                    mJiankangzhishiItemBean = it.data
                    mJiankangzhishiItemBean.id = mId
                    binding.setData()
                }
            }
        }
        binding.setData()
    }

    /**验证*/
    private fun JiankangzhishiaddorupdateLayoutBinding.submit() {
        mJiankangzhishiItemBean.biaoti = biaotiEt.text.toString()
        mJiankangzhishiItemBean.jianjie = jianjieEt.text.toString()
        mJiankangzhishiItemBean.neirong = neirongRichLayout.richEt.html
        if(mJiankangzhishiItemBean.biaoti.toString().isNullOrEmpty()){
            "标题不能为空".showToast()
            return
        }
        if(mJiankangzhishiItemBean.fabiaoriqi.toString().isNullOrEmpty()){
            "发表日期不能为空".showToast()
            return
        }
        addOrUpdate()

}
    private fun addOrUpdate(){/*更新或添加*/
        if (mJiankangzhishiItemBean.id>0){
            UserRepository.update("jiankangzhishi",mJiankangzhishiItemBean).observeKt{
            it.getOrNull()?.let {
                "提交成功".showToast()
                finish()
            }
        }
        }else{
            HomeRepository.add<JiankangzhishiItemBean>("jiankangzhishi",mJiankangzhishiItemBean).observeKt{
            it.getOrNull()?.let {
                "提交成功".showToast()
                finish()
            }
        }
        }
    }


    private fun JiankangzhishiaddorupdateLayoutBinding.setData(){
        if (mJiankangzhishiItemBean.biaoti.isNotNullOrEmpty()){
            biaotiEt.setText(mJiankangzhishiItemBean.biaoti.toString())
        }
        if (mJiankangzhishiItemBean.tupian.isNotNullOrEmpty()){
            tupianIfv.load(this@AddOrUpdateActivity, mJiankangzhishiItemBean.tupian)
        }
        fabiaoriqiTv.text = mJiankangzhishiItemBean.fabiaoriqi
        if (mJiankangzhishiItemBean.jianjie.isNotNullOrEmpty()){
            jianjieEt.setText(mJiankangzhishiItemBean.jianjie.toString())
        }
        neirongRichLayout.richEt.setHtml(mJiankangzhishiItemBean.neirong)
    }
}