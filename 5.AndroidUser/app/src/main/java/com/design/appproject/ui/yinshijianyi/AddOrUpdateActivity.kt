package com.design.appproject.ui.yinshijianyi

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
import com.design.appproject.bean.YinshijianyiItemBean
import com.design.appproject.ext.afterTextChanged
import com.design.appproject.bean.TijianbaogaoItemBean
import com.design.appproject.databinding.YinshijianyiaddorupdateLayoutBinding
import com.design.appproject.ext.load
import android.text.InputType

/**
 * 饮食建议新增或修改类
 */
@Route(path = CommonArouteApi.PATH_ACTIVITY_ADDORUPDATE_YINSHIJIANYI)
class AddOrUpdateActivity:BaseBindingActivity<YinshijianyiaddorupdateLayoutBinding>() {

    @JvmField
    @Autowired
    var mId: Long = 0L /*id*/

    @JvmField
    @Autowired
    var mCrossTable: String = "" /*跨表表名*/

    @JvmField
    @Autowired
    var mCrossObj: TijianbaogaoItemBean = TijianbaogaoItemBean() /*跨表表内容*/

    @JvmField
    @Autowired
    var mStatusColumnName: String = "" /*列名*/

    @JvmField
    @Autowired
    var mStatusColumnValue: String = "" /*列值*/

    @JvmField
    @Autowired
    var mTips: String = "" /*提示*/
    @JvmField
    @Autowired
    var mRefid: Long = 0 /*refid数据*/

    /**上传数据*/
    var mYinshijianyiItemBean = YinshijianyiItemBean()

    override fun initEvent() {
        setBarTitle("饮食建议")
        setBarColor("#FFFFFF","black")
        if (mRefid>0){/*如果上一级页面传递了refid，获取改refid数据信息*/
            if (mYinshijianyiItemBean.javaClass.declaredFields.any{it.name == "refid"}){
                mYinshijianyiItemBean.javaClass.getDeclaredField("refid").also { it.isAccessible=true }.let {
                    it.set(mYinshijianyiItemBean,mRefid)
                }
            }
            if (mYinshijianyiItemBean.javaClass.declaredFields.any{it.name == "nickname"}){
                mYinshijianyiItemBean.javaClass.getDeclaredField("nickname").also { it.isAccessible=true }.let {
                    it.set(mYinshijianyiItemBean,StorageUtil.decodeString(CommonBean.USERNAME_KEY)?:"")
                }
            }
        }
        if (Utils.isLogin() && mYinshijianyiItemBean.javaClass.declaredFields.any{it.name == "userid"}){/*如果有登陆，获取登陆后保存的userid*/
            mYinshijianyiItemBean.javaClass.getDeclaredField("userid").also { it.isAccessible=true }.let {
                it.set(mYinshijianyiItemBean,Utils.getUserId())
            }
        }
        binding.initView()

        binding.yinshijianyiRichLayout.apply{
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

    fun YinshijianyiaddorupdateLayoutBinding.initView(){
            val mriqiPicker = DatimePicker(this@AddOrUpdateActivity).apply {
            wheelLayout.setDateFormatter(BirthdayFormatter())
            wheelLayout.setTimeFormatter(UnitTimeFormatter())
            wheelLayout.setRange(DatimeEntity.yearOnFuture(-100), DatimeEntity.yearOnFuture(50), DatimeEntity.now())
            setOnDatimePickedListener { year, month, day, hour, minute, second ->
                riqiTv.text = "$year-$month-$day $hour:$minute:$second"
                mYinshijianyiItemBean.riqi="$year-$month-$day $hour:$minute:$second"
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
                    binding.setData()
                }
            }
        }

        (mId>0).yes {/*更新操作*/
            HomeRepository.info<YinshijianyiItemBean>("yinshijianyi",mId).observeKt {
                it.getOrNull()?.let {
                    mYinshijianyiItemBean = it.data
                    mYinshijianyiItemBean.id = mId
                    binding.setData()
                }
            }
        }
        if (mCrossTable.isNotNullOrEmpty()){/*跨表*/
            mCrossObj.javaClass.declaredFields.any{it.name == "yonghuzhanghao"}.yes {
                mYinshijianyiItemBean.yonghuzhanghao = mCrossObj.javaClass.getDeclaredField("yonghuzhanghao").also { it.isAccessible=true }.get(mCrossObj) as  String
            }
            mCrossObj.javaClass.declaredFields.any{it.name == "yonghuxingming"}.yes {
                mYinshijianyiItemBean.yonghuxingming = mCrossObj.javaClass.getDeclaredField("yonghuxingming").also { it.isAccessible=true }.get(mCrossObj) as  String
            }
            mCrossObj.javaClass.declaredFields.any{it.name == "riqi"}.yes {
                mYinshijianyiItemBean.riqi = mCrossObj.javaClass.getDeclaredField("riqi").also { it.isAccessible=true }.get(mCrossObj) as  String
            }
            mCrossObj.javaClass.declaredFields.any{it.name == "yinshijianyi"}.yes {
                mYinshijianyiItemBean.yinshijianyi = mCrossObj.javaClass.getDeclaredField("yinshijianyi").also { it.isAccessible=true }.get(mCrossObj) as  String
            }
        }
        binding.setData()
    }

    /**验证*/
    private fun YinshijianyiaddorupdateLayoutBinding.submit() {
        mYinshijianyiItemBean.yonghuzhanghao = yonghuzhanghaoEt.text.toString()
        mYinshijianyiItemBean.yonghuxingming = yonghuxingmingEt.text.toString()
        mYinshijianyiItemBean.yinshijianyi = yinshijianyiRichLayout.richEt.html
        var crossuserid:Long = 0
        var crossrefid:Long = 0
        var crossoptnum:Int = 0
        if (mStatusColumnName.isNotNullOrEmpty()){
            if (!mStatusColumnName.startsWith("[")){
                mCrossObj.javaClass.declaredFields.any{it.name == mStatusColumnName}.yes {
                    mCrossObj.javaClass.getDeclaredField(mStatusColumnName).also { it.isAccessible=true }.set(mCrossObj,mStatusColumnValue)
                    UserRepository.update(mCrossTable,mCrossObj).observeForever {  }
                }
            }else{
                crossuserid = Utils.getUserId()
                mCrossObj.javaClass.declaredFields.any{it.name == "id"}.yes {
                    crossrefid =mCrossObj.javaClass.getDeclaredField("id").also { it.isAccessible=true }.get(mCrossObj).toString().toLong()
                }
                crossoptnum = mStatusColumnName.replace("[","").replace("]","").toIntOrNull()?:0
            }
        }

        if (crossuserid>0 && crossrefid>0){
            mYinshijianyiItemBean.javaClass.declaredFields.any{it.name == "crossuserid"}.yes {
                mYinshijianyiItemBean.javaClass.getDeclaredField("crossuserid").also { it.isAccessible=true }.set(mYinshijianyiItemBean,crossuserid)
            }
            mYinshijianyiItemBean.javaClass.declaredFields.any{it.name == "crossrefid"}.yes {
                mYinshijianyiItemBean.javaClass.getDeclaredField("crossrefid").also { it.isAccessible=true }.set(mYinshijianyiItemBean,crossrefid)
            }
            HomeRepository.list<YinshijianyiItemBean>("yinshijianyi", mapOf("page" to "1","limit" to "10","crossuserid" to crossuserid.toString(),"crossrefid" to crossrefid.toString())).observeKt{
                it.getOrNull()?.let {
                    if (it.data.list.size>=crossoptnum){
                        mTips.showToast()
                    }else{
                        crossCal()
                    }
                }
            }
        }else{
            crossCal()
        }

}
    private fun crossCal(){/*更新跨表数据*/
        addOrUpdate()
    }
    private fun addOrUpdate(){/*更新或添加*/
        if (mYinshijianyiItemBean.id>0){
            UserRepository.update("yinshijianyi",mYinshijianyiItemBean).observeKt{
            it.getOrNull()?.let {
                "提交成功".showToast()
                finish()
            }
        }
        }else{
            HomeRepository.add<YinshijianyiItemBean>("yinshijianyi",mYinshijianyiItemBean).observeKt{
            it.getOrNull()?.let {
                "提交成功".showToast()
                finish()
            }
        }
        }
    }


    private fun YinshijianyiaddorupdateLayoutBinding.setData(){
        if (mYinshijianyiItemBean.yonghuzhanghao.isNotNullOrEmpty()){
            yonghuzhanghaoEt.setText(mYinshijianyiItemBean.yonghuzhanghao.toString())
        }
        if (mYinshijianyiItemBean.yonghuxingming.isNotNullOrEmpty()){
            yonghuxingmingEt.setText(mYinshijianyiItemBean.yonghuxingming.toString())
        }
        riqiTv.text = mYinshijianyiItemBean.riqi
        yinshijianyiRichLayout.richEt.setHtml(mYinshijianyiItemBean.yinshijianyi)
    }
}