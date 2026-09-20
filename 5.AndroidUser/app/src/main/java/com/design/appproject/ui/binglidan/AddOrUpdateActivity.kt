package com.design.appproject.ui.binglidan

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
import com.design.appproject.bean.BinglidanItemBean
import com.design.appproject.databinding.BinglidanaddorupdateLayoutBinding
import com.design.appproject.ext.load
import android.text.InputType

/**
 * 病例单新增或修改类
 */
@Route(path = CommonArouteApi.PATH_ACTIVITY_ADDORUPDATE_BINGLIDAN)
class AddOrUpdateActivity:BaseBindingActivity<BinglidanaddorupdateLayoutBinding>() {

    @JvmField
    @Autowired
    var mId: Long = 0L /*id*/

    @JvmField
    @Autowired
    var mRefid: Long = 0 /*refid数据*/

    /**上传数据*/
    var mBinglidanItemBean = BinglidanItemBean()

    override fun initEvent() {
        setBarTitle("病例单")
        setBarColor("#FFFFFF","black")
        if (mRefid>0){/*如果上一级页面传递了refid，获取改refid数据信息*/
            if (mBinglidanItemBean.javaClass.declaredFields.any{it.name == "refid"}){
                mBinglidanItemBean.javaClass.getDeclaredField("refid").also { it.isAccessible=true }.let {
                    it.set(mBinglidanItemBean,mRefid)
                }
            }
            if (mBinglidanItemBean.javaClass.declaredFields.any{it.name == "nickname"}){
                mBinglidanItemBean.javaClass.getDeclaredField("nickname").also { it.isAccessible=true }.let {
                    it.set(mBinglidanItemBean,StorageUtil.decodeString(CommonBean.USERNAME_KEY)?:"")
                }
            }
        }
        if (Utils.isLogin() && mBinglidanItemBean.javaClass.declaredFields.any{it.name == "userid"}){/*如果有登陆，获取登陆后保存的userid*/
            mBinglidanItemBean.javaClass.getDeclaredField("userid").also { it.isAccessible=true }.let {
                it.set(mBinglidanItemBean,Utils.getUserId())
            }
        }
        binding.initView()

    }

    fun BinglidanaddorupdateLayoutBinding.initView(){
            val mjiuzhenshijianPicker = DatePicker(this@AddOrUpdateActivity).apply {
                wheelLayout.setDateFormatter(BirthdayFormatter())
                wheelLayout.setRange(DateEntity.target(1923, 1, 1),DateEntity.target(2050, 12, 31), DateEntity.today())
                setOnDatePickedListener { year, month, day ->
                    jiuzhenshijianTv.text = "$year-$month-$day"
                    mBinglidanItemBean.jiuzhenshijian="$year-$month-$day"
                }
        }
            jiuzhenshijianTv.setOnClickListener {
            mjiuzhenshijianPicker.show()
        }
            fujianTv.setOnClickListener {
                startActivityForResult(Intent.createChooser(Intent(Intent.ACTION_GET_CONTENT).apply {
                   addCategory(Intent.CATEGORY_OPENABLE)
                   type =  "*/*" }, "请选择文件"), 1005 )
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
                    if (mBinglidanItemBean.yonghuzhanghao.isNullOrEmpty()){
                        mBinglidanItemBean.yonghuzhanghao = it["yonghuzhanghao"].toString()
                    }
                    binding.yonghuzhanghaoEt.keyListener = null
                    if (mBinglidanItemBean.yonghuxingming.isNullOrEmpty()){
                        mBinglidanItemBean.yonghuxingming = it["yonghuxingming"].toString()
                    }
                    binding.yonghuxingmingEt.keyListener = null
                    binding.setData()
                }
            }
        }

        (mId>0).yes {/*更新操作*/
            HomeRepository.info<BinglidanItemBean>("binglidan",mId).observeKt {
                it.getOrNull()?.let {
                    mBinglidanItemBean = it.data
                    mBinglidanItemBean.id = mId
                    binding.setData()
                }
            }
        }
        binding.setData()
    }

    /**验证*/
    private fun BinglidanaddorupdateLayoutBinding.submit() {
        mBinglidanItemBean.zhusu = zhusuEt.text.toString()
        mBinglidanItemBean.bingshi = bingshiEt.text.toString()
        mBinglidanItemBean.zhenduan = zhenduanEt.text.toString()
        mBinglidanItemBean.yonghuzhanghao = yonghuzhanghaoEt.text.toString()
        mBinglidanItemBean.yonghuxingming = yonghuxingmingEt.text.toString()
        addOrUpdate()

}
    private fun addOrUpdate(){/*更新或添加*/
        if (mBinglidanItemBean.id>0){
            UserRepository.update("binglidan",mBinglidanItemBean).observeKt{
            it.getOrNull()?.let {
                "提交成功".showToast()
                finish()
            }
        }
        }else{
            HomeRepository.add<BinglidanItemBean>("binglidan",mBinglidanItemBean).observeKt{
            it.getOrNull()?.let {
                "提交成功".showToast()
                finish()
            }
        }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode== RESULT_OK && data!=null){
            if (requestCode==1005){
                showLoading()
                UserRepository.upload(UriUtils.uri2File(data.data), "fujian").observeKt{
                    it.getOrNull()?.let {
                        binding.fujianTv.text = "file/"+ it.file
                        mBinglidanItemBean.fujian = "file/" + it.file
                    }
                }
                return
            }
        }
    }

    private fun BinglidanaddorupdateLayoutBinding.setData(){
        jiuzhenshijianTv.text = mBinglidanItemBean.jiuzhenshijian
        if (mBinglidanItemBean.zhusu.isNotNullOrEmpty()){
            zhusuEt.setText(mBinglidanItemBean.zhusu.toString())
        }
        if (mBinglidanItemBean.bingshi.isNotNullOrEmpty()){
            bingshiEt.setText(mBinglidanItemBean.bingshi.toString())
        }
        if (mBinglidanItemBean.zhenduan.isNotNullOrEmpty()){
            zhenduanEt.setText(mBinglidanItemBean.zhenduan.toString())
        }
        if (mBinglidanItemBean.fujian.isNotNullOrEmpty()){
            fujianTv.text =mBinglidanItemBean.fujian
        }
        if (mBinglidanItemBean.yonghuzhanghao.isNotNullOrEmpty()){
            yonghuzhanghaoEt.setText(mBinglidanItemBean.yonghuzhanghao.toString())
        }
        if (mBinglidanItemBean.yonghuxingming.isNotNullOrEmpty()){
            yonghuxingmingEt.setText(mBinglidanItemBean.yonghuxingming.toString())
        }
    }
}