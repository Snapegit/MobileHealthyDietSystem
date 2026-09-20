package com.design.appproject.ui.tijianbaogao

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
import com.design.appproject.bean.TijianbaogaoItemBean
import com.design.appproject.databinding.TijianbaogaoaddorupdateLayoutBinding
import com.design.appproject.ext.load
import android.text.InputType

/**
 * 体检报告新增或修改类
 */
@Route(path = CommonArouteApi.PATH_ACTIVITY_ADDORUPDATE_TIJIANBAOGAO)
class AddOrUpdateActivity:BaseBindingActivity<TijianbaogaoaddorupdateLayoutBinding>() {

    @JvmField
    @Autowired
    var mId: Long = 0L /*id*/

    @JvmField
    @Autowired
    var mRefid: Long = 0 /*refid数据*/

    /**上传数据*/
    var mTijianbaogaoItemBean = TijianbaogaoItemBean()

    override fun initEvent() {
        setBarTitle("体检报告")
        setBarColor("#FFFFFF","black")
        if (mRefid>0){/*如果上一级页面传递了refid，获取改refid数据信息*/
            if (mTijianbaogaoItemBean.javaClass.declaredFields.any{it.name == "refid"}){
                mTijianbaogaoItemBean.javaClass.getDeclaredField("refid").also { it.isAccessible=true }.let {
                    it.set(mTijianbaogaoItemBean,mRefid)
                }
            }
            if (mTijianbaogaoItemBean.javaClass.declaredFields.any{it.name == "nickname"}){
                mTijianbaogaoItemBean.javaClass.getDeclaredField("nickname").also { it.isAccessible=true }.let {
                    it.set(mTijianbaogaoItemBean,StorageUtil.decodeString(CommonBean.USERNAME_KEY)?:"")
                }
            }
        }
        if (Utils.isLogin() && mTijianbaogaoItemBean.javaClass.declaredFields.any{it.name == "userid"}){/*如果有登陆，获取登陆后保存的userid*/
            mTijianbaogaoItemBean.javaClass.getDeclaredField("userid").also { it.isAccessible=true }.let {
                it.set(mTijianbaogaoItemBean,Utils.getUserId())
            }
        }
        binding.initView()

    }

    fun TijianbaogaoaddorupdateLayoutBinding.initView(){
            val mtijianriqiPicker = DatePicker(this@AddOrUpdateActivity).apply {
                wheelLayout.setDateFormatter(BirthdayFormatter())
                wheelLayout.setRange(DateEntity.target(1923, 1, 1),DateEntity.target(2050, 12, 31), DateEntity.today())
                setOnDatePickedListener { year, month, day ->
                    tijianriqiTv.text = "$year-$month-$day"
                    mTijianbaogaoItemBean.tijianriqi="$year-$month-$day"
                }
        }
            tijianriqiTv.setOnClickListener {
            mtijianriqiPicker.show()
        }
            jianchajieguoTv.setOnClickListener {
                startActivityForResult(Intent.createChooser(Intent(Intent.ACTION_GET_CONTENT).apply {
                   addCategory(Intent.CATEGORY_OPENABLE)
                   type =  "*/*" }, "请选择文件"), 1005 )
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
                    if (mTijianbaogaoItemBean.yonghuzhanghao.isNullOrEmpty()){
                        mTijianbaogaoItemBean.yonghuzhanghao = it["yonghuzhanghao"].toString()
                    }
                    binding.yonghuzhanghaoEt.keyListener = null
                    if (mTijianbaogaoItemBean.yonghuxingming.isNullOrEmpty()){
                        mTijianbaogaoItemBean.yonghuxingming = it["yonghuxingming"].toString()
                    }
                    binding.yonghuxingmingEt.keyListener = null
                    binding.setData()
                }
            }
        }

        (mId>0).yes {/*更新操作*/
            HomeRepository.info<TijianbaogaoItemBean>("tijianbaogao",mId).observeKt {
                it.getOrNull()?.let {
                    mTijianbaogaoItemBean = it.data
                    mTijianbaogaoItemBean.id = mId
                    binding.setData()
                }
            }
        }
        mTijianbaogaoItemBean.sfsh = "待审核"
        binding.setData()
    }

    /**验证*/
    private fun TijianbaogaoaddorupdateLayoutBinding.submit() {
        mTijianbaogaoItemBean.zhuyaobingshi = zhuyaobingshiEt.text.toString()
        mTijianbaogaoItemBean.shengao = shengaoEt.text.toString()
        mTijianbaogaoItemBean.tizhong = tizhongEt.text.toString()
        mTijianbaogaoItemBean.jianchaxiangmu = jianchaxiangmuEt.text.toString()
        mTijianbaogaoItemBean.jianchayijian = jianchayijianEt.text.toString()
        mTijianbaogaoItemBean.beizhu = beizhuEt.text.toString()
        mTijianbaogaoItemBean.yonghuzhanghao = yonghuzhanghaoEt.text.toString()
        mTijianbaogaoItemBean.yonghuxingming = yonghuxingmingEt.text.toString()
        addOrUpdate()

}
    private fun addOrUpdate(){/*更新或添加*/
        if (mTijianbaogaoItemBean.id>0){
            UserRepository.update("tijianbaogao",mTijianbaogaoItemBean).observeKt{
            it.getOrNull()?.let {
                "提交成功".showToast()
                finish()
            }
        }
        }else{
            HomeRepository.add<TijianbaogaoItemBean>("tijianbaogao",mTijianbaogaoItemBean).observeKt{
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
                UserRepository.upload(UriUtils.uri2File(data.data), "jianchajieguo").observeKt{
                    it.getOrNull()?.let {
                        binding.jianchajieguoTv.text = "file/"+ it.file
                        mTijianbaogaoItemBean.jianchajieguo = "file/" + it.file
                    }
                }
                return
            }
            if (requestCode==1005){
                showLoading()
                UserRepository.upload(UriUtils.uri2File(data.data), "fujian").observeKt{
                    it.getOrNull()?.let {
                        binding.fujianTv.text = "file/"+ it.file
                        mTijianbaogaoItemBean.fujian = "file/" + it.file
                    }
                }
                return
            }
        }
    }

    private fun TijianbaogaoaddorupdateLayoutBinding.setData(){
        tijianriqiTv.text = mTijianbaogaoItemBean.tijianriqi
        if (mTijianbaogaoItemBean.zhuyaobingshi.isNotNullOrEmpty()){
            zhuyaobingshiEt.setText(mTijianbaogaoItemBean.zhuyaobingshi.toString())
        }
        if (mTijianbaogaoItemBean.shengao.isNotNullOrEmpty()){
            shengaoEt.setText(mTijianbaogaoItemBean.shengao.toString())
        }
        if (mTijianbaogaoItemBean.tizhong.isNotNullOrEmpty()){
            tizhongEt.setText(mTijianbaogaoItemBean.tizhong.toString())
        }
        if (mTijianbaogaoItemBean.jianchaxiangmu.isNotNullOrEmpty()){
            jianchaxiangmuEt.setText(mTijianbaogaoItemBean.jianchaxiangmu.toString())
        }
        if (mTijianbaogaoItemBean.jianchajieguo.isNotNullOrEmpty()){
            jianchajieguoTv.text =mTijianbaogaoItemBean.jianchajieguo
        }
        if (mTijianbaogaoItemBean.jianchayijian.isNotNullOrEmpty()){
            jianchayijianEt.setText(mTijianbaogaoItemBean.jianchayijian.toString())
        }
        if (mTijianbaogaoItemBean.beizhu.isNotNullOrEmpty()){
            beizhuEt.setText(mTijianbaogaoItemBean.beizhu.toString())
        }
        if (mTijianbaogaoItemBean.fujian.isNotNullOrEmpty()){
            fujianTv.text =mTijianbaogaoItemBean.fujian
        }
        if (mTijianbaogaoItemBean.yonghuzhanghao.isNotNullOrEmpty()){
            yonghuzhanghaoEt.setText(mTijianbaogaoItemBean.yonghuzhanghao.toString())
        }
        if (mTijianbaogaoItemBean.yonghuxingming.isNotNullOrEmpty()){
            yonghuxingmingEt.setText(mTijianbaogaoItemBean.yonghuxingming.toString())
        }
    }
}