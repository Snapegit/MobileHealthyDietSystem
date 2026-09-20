package com.design.appproject.ui.jiankangjihua

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
import com.design.appproject.bean.JiankangjihuaItemBean
import com.design.appproject.databinding.JiankangjihuaaddorupdateLayoutBinding
import com.design.appproject.ext.load
import android.text.InputType

/**
 * 健康计划新增或修改类
 */
@Route(path = CommonArouteApi.PATH_ACTIVITY_ADDORUPDATE_JIANKANGJIHUA)
class AddOrUpdateActivity:BaseBindingActivity<JiankangjihuaaddorupdateLayoutBinding>() {

    @JvmField
    @Autowired
    var mId: Long = 0L /*id*/

    @JvmField
    @Autowired
    var mRefid: Long = 0 /*refid数据*/

    /**上传数据*/
    var mJiankangjihuaItemBean = JiankangjihuaItemBean()

    override fun initEvent() {
        setBarTitle("健康计划")
        setBarColor("#FFFFFF","black")
        if (mRefid>0){/*如果上一级页面传递了refid，获取改refid数据信息*/
            if (mJiankangjihuaItemBean.javaClass.declaredFields.any{it.name == "refid"}){
                mJiankangjihuaItemBean.javaClass.getDeclaredField("refid").also { it.isAccessible=true }.let {
                    it.set(mJiankangjihuaItemBean,mRefid)
                }
            }
            if (mJiankangjihuaItemBean.javaClass.declaredFields.any{it.name == "nickname"}){
                mJiankangjihuaItemBean.javaClass.getDeclaredField("nickname").also { it.isAccessible=true }.let {
                    it.set(mJiankangjihuaItemBean,StorageUtil.decodeString(CommonBean.USERNAME_KEY)?:"")
                }
            }
        }
        if (Utils.isLogin() && mJiankangjihuaItemBean.javaClass.declaredFields.any{it.name == "userid"}){/*如果有登陆，获取登陆后保存的userid*/
            mJiankangjihuaItemBean.javaClass.getDeclaredField("userid").also { it.isAccessible=true }.let {
                it.set(mJiankangjihuaItemBean,Utils.getUserId())
            }
        }
        binding.initView()

    }

    fun JiankangjihuaaddorupdateLayoutBinding.initView(){
            val mriqiPicker = DatePicker(this@AddOrUpdateActivity).apply {
                wheelLayout.setDateFormatter(BirthdayFormatter())
                wheelLayout.setRange(DateEntity.target(1923, 1, 1),DateEntity.target(2050, 12, 31), DateEntity.today())
                setOnDatePickedListener { year, month, day ->
                    riqiTv.text = "$year-$month-$day"
                    mJiankangjihuaItemBean.riqi="$year-$month-$day"
                }
        }
            riqiTv.setOnClickListener {
            mriqiPicker.show()
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
                    if (mJiankangjihuaItemBean.yonghuzhanghao.isNullOrEmpty()){
                        mJiankangjihuaItemBean.yonghuzhanghao = it["yonghuzhanghao"].toString()
                    }
                    binding.yonghuzhanghaoEt.keyListener = null
                    if (mJiankangjihuaItemBean.yonghuxingming.isNullOrEmpty()){
                        mJiankangjihuaItemBean.yonghuxingming = it["yonghuxingming"].toString()
                    }
                    binding.yonghuxingmingEt.keyListener = null
                    binding.setData()
                }
            }
        }

        (mId>0).yes {/*更新操作*/
            HomeRepository.info<JiankangjihuaItemBean>("jiankangjihua",mId).observeKt {
                it.getOrNull()?.let {
                    mJiankangjihuaItemBean = it.data
                    mJiankangjihuaItemBean.id = mId
                    binding.setData()
                }
            }
        }
        binding.setData()
    }

    /**验证*/
    private fun JiankangjihuaaddorupdateLayoutBinding.submit() {
        mJiankangjihuaItemBean.jihuamingcheng = jihuamingchengEt.text.toString()
        mJiankangjihuaItemBean.jihuaneirong = jihuaneirongEt.text.toString()
        mJiankangjihuaItemBean.yonghuzhanghao = yonghuzhanghaoEt.text.toString()
        mJiankangjihuaItemBean.yonghuxingming = yonghuxingmingEt.text.toString()
        addOrUpdate()

}
    private fun addOrUpdate(){/*更新或添加*/
        if (mJiankangjihuaItemBean.id>0){
            UserRepository.update("jiankangjihua",mJiankangjihuaItemBean).observeKt{
            it.getOrNull()?.let {
                "提交成功".showToast()
                finish()
            }
        }
        }else{
            HomeRepository.add<JiankangjihuaItemBean>("jiankangjihua",mJiankangjihuaItemBean).observeKt{
            it.getOrNull()?.let {
                "提交成功".showToast()
                finish()
            }
        }
        }
    }


    private fun JiankangjihuaaddorupdateLayoutBinding.setData(){
        riqiTv.text = mJiankangjihuaItemBean.riqi
        if (mJiankangjihuaItemBean.jihuamingcheng.isNotNullOrEmpty()){
            jihuamingchengEt.setText(mJiankangjihuaItemBean.jihuamingcheng.toString())
        }
        if (mJiankangjihuaItemBean.yonghuzhanghao.isNotNullOrEmpty()){
            yonghuzhanghaoEt.setText(mJiankangjihuaItemBean.yonghuzhanghao.toString())
        }
        if (mJiankangjihuaItemBean.yonghuxingming.isNotNullOrEmpty()){
            yonghuxingmingEt.setText(mJiankangjihuaItemBean.yonghuxingming.toString())
        }
        if (mJiankangjihuaItemBean.jihuaneirong.isNotNullOrEmpty()){
            jihuaneirongEt.setText(mJiankangjihuaItemBean.jihuaneirong.toString())
        }
    }
}