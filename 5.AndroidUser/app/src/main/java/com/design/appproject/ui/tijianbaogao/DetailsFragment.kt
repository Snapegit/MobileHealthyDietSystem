package com.design.appproject.ui.tijianbaogao

import com.design.appproject.logic.repository.UserRepository
import com.qmuiteam.qmui.widget.QMUIRadiusImageView
import android.annotation.SuppressLint
import com.union.union_basic.utils.StorageUtil
import com.design.appproject.utils.ArouterUtils
import androidx.fragment.app.viewModels
import com.blankj.utilcode.util.ThreadUtils.runOnUiThread
import com.design.appproject.base.*
import com.design.appproject.ext.postEvent
import android.media.MediaPlayer
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import com.google.gson.Gson
import android.view.Gravity
import android.view.ViewGroup
import com.design.appproject.widget.DetailBannerAdapter
import android.widget.*
import androidx.constraintlayout.utils.widget.ImageFilterView
import com.blankj.utilcode.util.ColorUtils
import com.design.appproject.R
import com.qmuiteam.qmui.layout.QMUILinearLayout
import com.union.union_basic.ext.*
import androidx.core.view.setMargins
import com.alibaba.android.arouter.launcher.ARouter
import com.lxj.xpopup.XPopup
import kotlinx.coroutines.*
import com.union.union_basic.network.DownloadListener
import com.union.union_basic.network.DownloadUtil
import java.io.File
import androidx.core.view.setPadding
import com.design.appproject.logic.repository.HomeRepository
import com.design.appproject.utils.Utils
import java.util.*
import kotlin.concurrent.timerTask
import com.design.appproject.ext.load
import com.design.appproject.logic.viewmodel.tijianbaogao.DetailsViewModel
import androidx.activity.viewModels
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.design.appproject.databinding.TijianbaogaocommonDetailsLayoutBinding
import com.design.appproject.bean.*
import com.design.appproject.ui.CommentsAdatper
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.core.view.isVisible
import android.text.Html
import com.design.appproject.widget.MyTextView
import com.design.appproject.widget.MyFlexBoxLayout
import com.design.appproject.widget.MyImageView
import android.view.ContextThemeWrapper
import com.google.android.flexbox.FlexWrap
import com.union.union_basic.image.loader.GlideLoader.load
/**
 * 体检报告详情页
 */
@Route(path = CommonArouteApi.PATH_FRAGMENT_DETAILS_TIJIANBAOGAO)
class DetailsFragment : BaseBindingFragment<TijianbaogaocommonDetailsLayoutBinding>() {

    @JvmField
    @Autowired
    var mId: Long = 0 /*id*/

    @JvmField
    @Autowired
    var mIsBack: Boolean = false /*是否用户后台进入*/

    private val mDetailsViewModel by viewModels<DetailsViewModel>()

    private var mTijianbaogaoItemBean=TijianbaogaoItemBean()/*详情内容*/


    @SuppressLint("SuspiciousIndentation")
    override fun initEvent() {
        setBarTitle("体检报告详情页")
        setBarColor("#FFFFFF","black")
        binding.apply{
            srv.setOnRefreshListener {
                loadData()
            }
             jianchajieguoTv.setOnClickListener {/*下载*/
                DownloadUtil.download("${NetRetrofitClient.BASE_URL}file/download?fileName=${mTijianbaogaoItemBean.jianchajieguo.replace("file/","")}","${CommonBean.DOWNLOAD_PATH}/jianchajieguo",object : DownloadListener {
                    override fun onStart() {"开始下载".showToast()}

                    override fun onProgress(progress: Int) {}

                    override fun onFinish(path: String?) {
                        "下载完成".showToast()
                    }

                    override fun onFail(errorInfo: String?) {
                        File(CommonBean.DOWNLOAD_PATH, "jianchajieguo").delete()
                        runOnUiThread {
                            "下载失败,请重试".showToast()
                        }
                    }
                })
        }
             fujianTv.setOnClickListener {/*下载*/
                DownloadUtil.download("${NetRetrofitClient.BASE_URL}file/download?fileName=${mTijianbaogaoItemBean.fujian.replace("file/","")}","${CommonBean.DOWNLOAD_PATH}/fujian",object : DownloadListener {
                    override fun onStart() {"开始下载".showToast()}

                    override fun onProgress(progress: Int) {}

                    override fun onFinish(path: String?) {
                        "下载完成".showToast()
                    }

                    override fun onFail(errorInfo: String?) {
                        File(CommonBean.DOWNLOAD_PATH, "fujian").delete()
                        runOnUiThread {
                            "下载失败,请重试".showToast()
                        }
                    }
                })
        }
            mIsBack.yes {
                sfshBtn.isVisible = Utils.isAuthBack("tijianbaogao","审核")
            }.otherwise {
                sfshBtn.isVisible = Utils.isAuthFront("tijianbaogao","审核")
            }
            sfshBtn.setOnClickListener {
                XPopup.Builder(context).asInputConfirm("",""){
                    if (mTijianbaogaoItemBean.sfsh.isNullOrEmpty()){
                        "请选择审核状态".showToast()
                        return@asInputConfirm
                    }
                    when(it){
                        "通过"-> mTijianbaogaoItemBean.sfsh = "是"
                        "不通过"->mTijianbaogaoItemBean.sfsh = "否"
                        else->mTijianbaogaoItemBean.sfsh = it
                    }
                    if (mTijianbaogaoItemBean.sfsh.isNullOrEmpty()){
                        "请填写审核回复".showToast()
                    }else{
                        mDetailsViewModel.update("tijianbaogao",mTijianbaogaoItemBean,"shhf")
                    }
                }.show()
            }
            mIsBack.yes {
                crossOptButtonBtn0.isVisible = Utils.isAuthBack("tijianbaogao","饮食建议")
            }.otherwise {
                crossOptButtonBtn0.isVisible = Utils.isAuthFront("tijianbaogao","饮食建议")
            }
            crossOptButtonBtn0.setOnClickListener{/*跨表*/
            if (mTijianbaogaoItemBean.sfsh!="是"){
                "请审核通过后再操作".showToast()
                return@setOnClickListener
            }
            ARouter.getInstance().build(CommonArouteApi.PATH_ACTIVITY_ADDORUPDATE_YINSHIJIANYI)
                .withString("mCrossTable","tijianbaogao")
                .withObject("mCrossObj",mTijianbaogaoItemBean)
                .withString("mStatusColumnName","")
                .withString("mStatusColumnValue","")
                .withString("mTips","")
                .navigation()
        }
    }
    }

    override fun initData() {
        super.initData()
        showLoading()
        loadData()
        mDetailsViewModel.infoLiveData.observeKt(errorBlock = {binding.srv.isRefreshing =false}) {
            it.getOrNull()?.let { info->
                binding.srv.isRefreshing =false
                mTijianbaogaoItemBean = info.data
                 binding.setInfo()
            }
        }
        mDetailsViewModel.updateLiveData.observeKt {
            it.getOrNull()?.let {
                if (it.callBackData=="shhf"){
                    "审核成功".showToast()
                }
            }

        }
    }

    private fun loadData(){
        mDetailsViewModel.info("tijianbaogao",mId.toString())
    }


    private fun TijianbaogaocommonDetailsLayoutBinding.setInfo(){
        tijianriqiTv.text = "${mTijianbaogaoItemBean.tijianriqi}"
        zhuyaobingshiTv.text = "${mTijianbaogaoItemBean.zhuyaobingshi}"
        shengaoTv.text = "${mTijianbaogaoItemBean.shengao}"
        tizhongTv.text = "${mTijianbaogaoItemBean.tizhong}"
        jianchaxiangmuTv.text = "${mTijianbaogaoItemBean.jianchaxiangmu}"
        jianchajieguoTv.text = "${mTijianbaogaoItemBean.jianchajieguo}下载文件"
        jianchayijianTv.text = "${mTijianbaogaoItemBean.jianchayijian}"
        beizhuTv.text = "${mTijianbaogaoItemBean.beizhu}"
        fujianTv.text = "${mTijianbaogaoItemBean.fujian}下载文件"
        yonghuzhanghaoTv.text = "${mTijianbaogaoItemBean.yonghuzhanghao}"
        yonghuxingmingTv.text = "${mTijianbaogaoItemBean.yonghuxingming}"
        var sfshStatus = if(mTijianbaogaoItemBean.sfsh =="是"){
            "通过"
        }else if(mTijianbaogaoItemBean.sfsh =="否"){
            "不通过"
        }else{
            "待审核"
        }
        sfshTv.isVisible = mIsBack
        sfshFbl.isVisible = mIsBack
        sfshContentTv.isVisible = mIsBack
        sfshContentFbl.isVisible = mIsBack
        sfshTv.text = "${sfshStatus}"
        sfshContentTv.text =mTijianbaogaoItemBean.shhf
    }




    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode== AppCompatActivity.RESULT_OK && requestCode==101){
            loadData()
        }
    }

}