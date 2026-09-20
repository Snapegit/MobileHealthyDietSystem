package com.design.appproject.ui

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.core.view.setMargins
import androidx.core.view.setPadding
import androidx.fragment.app.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.ColorUtils
import com.design.appproject.R
import com.design.appproject.base.BaseBindingFragment
import com.design.appproject.base.CommonArouteApi
import com.design.appproject.base.CommonBean
import com.design.appproject.bean.*
import com.design.appproject.bean.config.*
import com.design.appproject.databinding.FragmentIndexLayoutBinding
import com.design.appproject.ext.load
import com.design.appproject.logic.repository.HomeRepository
import com.design.appproject.logic.viewmodel.HomeViewModel
import com.design.appproject.utils.ArouterUtils
import com.design.appproject.utils.Utils
import com.design.appproject.widget.BottomSpinner
import com.youth.banner.indicator.CircleIndicator
import android.text.Html
import androidx.core.view.isVisible
import android.view.LayoutInflater
import com.design.appproject.widget.MyFlexBoxLayout
import com.qmuiteam.qmui.layout.QMUILinearLayout
import com.union.union_basic.ext.*
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.Banner
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import android.graphics.Color
import com.design.appproject.base.EventBus
import com.design.appproject.ext.observeEvent
import com.lxj.xpopup.XPopup
/**
 * 首页fragment
 * */
@Route(path = CommonArouteApi.PATH_FRAGMENT_INDEX)
class IndexFragment : BaseBindingFragment<FragmentIndexLayoutBinding>() {

    private val mHomeViewModel by viewModels<HomeViewModel>()

    override fun initEvent() {
        binding.apply {
            homeSrl.setOnRefreshListener {
                initHomeView()
                GlobalScope.launch {
                    delay(2000) /*延时2秒*/
                    homeSrl.isRefreshing =false
                }
            }
            initHomeView()
            observeEvent<Boolean>(EventBus.LOGIN_SUCCESS){
                initHomeView()
            }
        }
    }

    private fun FragmentIndexLayoutBinding.initHomeView(){/*初始化首页内容*/
        initBanner()
        initMenu()
        initRecommendView()
        initProductView()
    }

    private fun FragmentIndexLayoutBinding.initProductView() {
        jiankangshipuMoreTv.setOnClickListener {/*查看更多*/
            ArouterUtils.startFragment(CommonArouteApi.PATH_FRAGMENT_LIST_JIANKANGSHIPU)
        }
        HomeRepository.list<JiankangshipuItemBean>("jiankangshipu",
            mapOf(
                "page" to "1",
                "limit" to "6"
            )
        ).observeKt {
                it.getOrNull()?.let {
                    jiankangshipuListLl.removeAllViews()
                        jiankangshipuListLl.addView(LayoutInflater.from(context).inflate(R.layout.jiankangshipu_item_index_list_layout,jiankangshipuListLl,false).apply{
                            var produceList = it.data.list
                        if (produceList.size>0){
                            findViewById<ViewGroup>(R.id.list_top_fbl).isVisible =true
                            findViewById<ViewGroup>(R.id.list_top_fbl).setOnClickListener {
                                ArouterUtils.startFragment(CommonArouteApi.PATH_FRAGMENT_DETAILS_JIANKANGSHIPU,map = mapOf("mId" to produceList[0].id))
                            }
                            findViewById<TextView>(R.id.shipumingcheng_top_title_tv).text =  produceList[0].shipumingcheng.toString()
                            findViewById<ImageView>(R.id.fengmian_top_img_iv).load(context,produceList[0].fengmian.split(",")[0], needPrefix = !(produceList[0].fengmian.startsWith("http")))
                        }
                        if (produceList.size>1){
                            findViewById<ViewGroup>(R.id.list_center_left_top_fbl).isVisible =true
                            findViewById<ViewGroup>(R.id.list_center_left_top_fbl).setOnClickListener {
                                ArouterUtils.startFragment(CommonArouteApi.PATH_FRAGMENT_DETAILS_JIANKANGSHIPU,map = mapOf("mId" to produceList[1].id))
                            }
                            findViewById<TextView>(R.id.shipumingcheng_center_left_top_title_tv).text =  produceList[1].shipumingcheng.toString()
                            findViewById<ImageView>(R.id.fengmian_center_left_top_iv).load(context,produceList[1].fengmian.split(",")[0], needPrefix = !(produceList[1].fengmian.startsWith("http")))
                        }
                        if (produceList.size>2){
                            findViewById<ViewGroup>(R.id.list_center_left_bottom_fbl).isVisible =true
                            findViewById<ViewGroup>(R.id.list_center_left_bottom_fbl).setOnClickListener {
                                ArouterUtils.startFragment(CommonArouteApi.PATH_FRAGMENT_DETAILS_JIANKANGSHIPU,map = mapOf("mId" to produceList[2].id))
                            }
                            findViewById<TextView>(R.id.shipumingcheng_center_left_bottom_title_tv).text =  produceList[2].shipumingcheng.toString()
                            findViewById<ImageView>(R.id.fengmian_center_left_bottom_iv).load(context,produceList[2].fengmian.split(",")[0], needPrefix = !(produceList[2].fengmian.startsWith("http")))
                        }
                        if (produceList.size>3){
                            findViewById<ViewGroup>(R.id.list_center_right_top_fbl).isVisible =true
                            findViewById<ViewGroup>(R.id.list_center_right_top_fbl).setOnClickListener {
                                ArouterUtils.startFragment(CommonArouteApi.PATH_FRAGMENT_DETAILS_JIANKANGSHIPU,map = mapOf("mId" to produceList[3].id))
                            }
                            findViewById<TextView>(R.id.shipumingcheng_center_right_top_title_tv).text =  produceList[3].shipumingcheng.toString()
                            findViewById<ImageView>(R.id.fengmian_center_right_top_img_iv).load(context,produceList[3].fengmian.split(",")[0], needPrefix = !(produceList[3].fengmian.startsWith("http")))
                        }
                        if (produceList.size>4){
                            findViewById<ViewGroup>(R.id.list_center_right_bottom_fbl).isVisible =true
                            findViewById<ViewGroup>(R.id.list_center_right_bottom_fbl).setOnClickListener {
                                ArouterUtils.startFragment(CommonArouteApi.PATH_FRAGMENT_DETAILS_JIANKANGSHIPU,map = mapOf("mId" to produceList[4].id))
                            }
                            findViewById<TextView>(R.id.shipumingcheng_center_right_bottom_title_tv).text =  produceList[4].shipumingcheng.toString()
                            findViewById<ImageView>(R.id.fengmian_center_right_bottom_img_iv).load(context,produceList[4].fengmian.split(",")[0], needPrefix = !(produceList[4].fengmian.startsWith("http")))
                        }
                        if (produceList.size>5){
                            findViewById<ViewGroup>(R.id.list_center_bottom_fbl).isVisible =true
                            findViewById<ViewGroup>(R.id.list_center_bottom_fbl).setOnClickListener {
                                ArouterUtils.startFragment(CommonArouteApi.PATH_FRAGMENT_DETAILS_JIANKANGSHIPU,map = mapOf("mId" to produceList[5].id))
                            }
                            findViewById<TextView>(R.id.shipumingcheng_bottom_title_tv).text =  produceList[5].shipumingcheng.toString()
                            findViewById<ImageView>(R.id.fengmian_bottom_img_iv).load(context,produceList[5].fengmian.split(",")[0], needPrefix = !(produceList[5].fengmian.startsWith("http")))
                        }
                    })
            }
        }
        jiankangzhishiMoreTv.setOnClickListener {/*查看更多*/
            ArouterUtils.startFragment(CommonArouteApi.PATH_FRAGMENT_LIST_JIANKANGZHISHI)
        }
        HomeRepository.list<JiankangzhishiItemBean>("jiankangzhishi",
            mapOf(
                "page" to "1",
                "limit" to "6"
            )
        ).observeKt {
                it.getOrNull()?.let {
                    jiankangzhishiListLl.removeAllViews()
                        jiankangzhishiListLl.addView(LayoutInflater.from(context).inflate(R.layout.jiankangzhishi_item_index_list_layout,jiankangzhishiListLl,false).apply{
                            var produceList = it.data.list
                        if (produceList.size>0){
                            findViewById<ViewGroup>(R.id.list_top_fbl).isVisible =true
                            findViewById<ViewGroup>(R.id.list_top_fbl).setOnClickListener {
                                ArouterUtils.startFragment(CommonArouteApi.PATH_FRAGMENT_DETAILS_JIANKANGZHISHI,map = mapOf("mId" to produceList[0].id))
                            }
                            findViewById<TextView>(R.id.biaoti_top_title_tv).text = "标题:"+ produceList[0].biaoti.toString()
                            findViewById<ImageView>(R.id.tupian_top_img_iv).load(context,produceList[0].tupian.split(",")[0], needPrefix = !(produceList[0].tupian.startsWith("http")))
                            findViewById<TextView>(R.id.fabiaoriqi_top_title_tv).text =  produceList[0].fabiaoriqi.toString()
                        }
                        if (produceList.size>1){
                            findViewById<ViewGroup>(R.id.list_center_left_top_fbl).isVisible =true
                            findViewById<ViewGroup>(R.id.list_center_left_top_fbl).setOnClickListener {
                                ArouterUtils.startFragment(CommonArouteApi.PATH_FRAGMENT_DETAILS_JIANKANGZHISHI,map = mapOf("mId" to produceList[1].id))
                            }
                            findViewById<TextView>(R.id.biaoti_center_left_top_title_tv).text = "标题:"+ produceList[1].biaoti.toString()
                            findViewById<ImageView>(R.id.tupian_center_left_top_iv).load(context,produceList[1].tupian.split(",")[0], needPrefix = !(produceList[1].tupian.startsWith("http")))
                            findViewById<TextView>(R.id.fabiaoriqi_center_left_top_title_tv).text =  produceList[1].fabiaoriqi.toString()
                        }
                        if (produceList.size>2){
                            findViewById<ViewGroup>(R.id.list_center_left_bottom_fbl).isVisible =true
                            findViewById<ViewGroup>(R.id.list_center_left_bottom_fbl).setOnClickListener {
                                ArouterUtils.startFragment(CommonArouteApi.PATH_FRAGMENT_DETAILS_JIANKANGZHISHI,map = mapOf("mId" to produceList[2].id))
                            }
                            findViewById<TextView>(R.id.biaoti_center_left_bottom_title_tv).text = "标题:"+ produceList[2].biaoti.toString()
                            findViewById<ImageView>(R.id.tupian_center_left_bottom_iv).load(context,produceList[2].tupian.split(",")[0], needPrefix = !(produceList[2].tupian.startsWith("http")))
                            findViewById<TextView>(R.id.fabiaoriqi_center_left_bottom_title_tv).text =  produceList[2].fabiaoriqi.toString()
                        }
                        if (produceList.size>3){
                            findViewById<ViewGroup>(R.id.list_center_right_top_fbl).isVisible =true
                            findViewById<ViewGroup>(R.id.list_center_right_top_fbl).setOnClickListener {
                                ArouterUtils.startFragment(CommonArouteApi.PATH_FRAGMENT_DETAILS_JIANKANGZHISHI,map = mapOf("mId" to produceList[3].id))
                            }
                            findViewById<TextView>(R.id.biaoti_center_right_top_title_tv).text = "标题:"+ produceList[3].biaoti.toString()
                            findViewById<ImageView>(R.id.tupian_center_right_top_img_iv).load(context,produceList[3].tupian.split(",")[0], needPrefix = !(produceList[3].tupian.startsWith("http")))
                            findViewById<TextView>(R.id.fabiaoriqi_center_right_top_title_tv).text =  produceList[3].fabiaoriqi.toString()
                        }
                        if (produceList.size>4){
                            findViewById<ViewGroup>(R.id.list_center_right_bottom_fbl).isVisible =true
                            findViewById<ViewGroup>(R.id.list_center_right_bottom_fbl).setOnClickListener {
                                ArouterUtils.startFragment(CommonArouteApi.PATH_FRAGMENT_DETAILS_JIANKANGZHISHI,map = mapOf("mId" to produceList[4].id))
                            }
                            findViewById<TextView>(R.id.biaoti_center_right_bottom_title_tv).text = "标题:"+ produceList[4].biaoti.toString()
                            findViewById<ImageView>(R.id.tupian_center_right_bottom_img_iv).load(context,produceList[4].tupian.split(",")[0], needPrefix = !(produceList[4].tupian.startsWith("http")))
                            findViewById<TextView>(R.id.fabiaoriqi_center_right_bottom_title_tv).text =  produceList[4].fabiaoriqi.toString()
                        }
                        if (produceList.size>5){
                            findViewById<ViewGroup>(R.id.list_center_bottom_fbl).isVisible =true
                            findViewById<ViewGroup>(R.id.list_center_bottom_fbl).setOnClickListener {
                                ArouterUtils.startFragment(CommonArouteApi.PATH_FRAGMENT_DETAILS_JIANKANGZHISHI,map = mapOf("mId" to produceList[5].id))
                            }
                            findViewById<TextView>(R.id.biaoti_bottom_title_tv).text = "标题:"+ produceList[5].biaoti.toString()
                            findViewById<ImageView>(R.id.tupian_bottom_img_iv).load(context,produceList[5].tupian.split(",")[0], needPrefix = !(produceList[5].tupian.startsWith("http")))
                            findViewById<TextView>(R.id.fabiaoriqi_bottom_title_tv).text =  produceList[5].fabiaoriqi.toString()
                        }
                    })
            }
        }
    }

    private fun FragmentIndexLayoutBinding.initRecommendView() { /*商品推荐初始化*/
        val map = mapOf("page" to "1", "limit" to "6")
        HomeRepository.autoSort<JiankangshipuItemBean>("jiankangshipu", map).observeKt {
            it.getOrNull()?.let {
                jiankangshipuGl.removeAllViews()
                jiankangshipuGl.addView(LayoutInflater.from(context).inflate(R.layout.jiankangshipu_item_recommend_layout,jiankangshipuGl,false).apply{
                var recommendList = it.data.list
                if (recommendList.size>0){
                    findViewById<TextView>(R.id.shipumingcheng_top_left_title_tv).text =  recommendList[0].shipumingcheng.toString()
                    findViewById<ImageView>(R.id.fengmian_top_left_img_iv).load(context,recommendList[0].fengmian.split(",")[0], needPrefix = !(recommendList[0].fengmian.startsWith("http")))
                    findViewById<ViewGroup>(R.id.rec_top_left_fbl).isVisible =true
                    findViewById<ViewGroup>(R.id.rec_top_left_fbl).setOnClickListener {
                        ArouterUtils.startFragment(CommonArouteApi.PATH_FRAGMENT_DETAILS_JIANKANGSHIPU,map = mapOf("mId" to recommendList[0].id))
                    }
                }
                if (recommendList.size>1){
                    findViewById<TextView>(R.id.shipumingcheng_top_right_top_title_tv).text =  recommendList[1].shipumingcheng.toString()
                    findViewById<ImageView>(R.id.fengmian_top_right_top_img_iv).load(context,recommendList[1].fengmian.split(",")[0], needPrefix = !(recommendList[1].fengmian.startsWith("http")))
                    findViewById<ViewGroup>(R.id.rec_top_right_top_fbl).isVisible =true
                    findViewById<ViewGroup>(R.id.rec_top_right_top_fbl).setOnClickListener {
                        ArouterUtils.startFragment(CommonArouteApi.PATH_FRAGMENT_DETAILS_JIANKANGSHIPU,map = mapOf("mId" to recommendList[1].id))
                    }
                }
                if (recommendList.size>2){
                    findViewById<TextView>(R.id.shipumingcheng_top_right_bottom_title_tv).text =  recommendList[2].shipumingcheng.toString()
                    findViewById<ImageView>(R.id.fengmian_top_right_bottom_img_iv).load(context,recommendList[2].fengmian.split(",")[0], needPrefix = !(recommendList[2].fengmian.startsWith("http")))
                    findViewById<ViewGroup>(R.id.rec_top_right_bottom_fbl).isVisible =true
                    findViewById<ViewGroup>(R.id.rec_top_right_bottom_fbl).setOnClickListener {
                        ArouterUtils.startFragment(CommonArouteApi.PATH_FRAGMENT_DETAILS_JIANKANGSHIPU,map = mapOf("mId" to recommendList[2].id))
                    }
                }
                if (recommendList.size>3){
                    findViewById<TextView>(R.id.shipumingcheng_bottom_left_top_title_tv).text =  recommendList[3].shipumingcheng.toString()
                    findViewById<ImageView>(R.id.fengmian_bottom_left_top_img_iv).load(context,recommendList[3].fengmian.split(",")[0], needPrefix = !(recommendList[3].fengmian.startsWith("http")))
                    findViewById<ViewGroup>(R.id.rec_bottom_left_top_fbl).isVisible =true
                    findViewById<ViewGroup>(R.id.rec_bottom_left_top_fbl).setOnClickListener {
                        ArouterUtils.startFragment(CommonArouteApi.PATH_FRAGMENT_DETAILS_JIANKANGSHIPU,map = mapOf("mId" to recommendList[3].id))
                    }
                }
                if (recommendList.size>4){
                    findViewById<TextView>(R.id.shipumingcheng_bottom_left_bottom_title_tv).text =  recommendList[4].shipumingcheng.toString()
                    findViewById<ImageView>(R.id.fengmian_bottom_left_bottom_img_iv).load(context,recommendList[4].fengmian.split(",")[0], needPrefix = !(recommendList[4].fengmian.startsWith("http")))
                    findViewById<ViewGroup>(R.id.rec_bottom_left_bottom_fbl).isVisible =true
                    findViewById<ViewGroup>(R.id.rec_bottom_left_bottom_fbl).setOnClickListener {
                        ArouterUtils.startFragment(CommonArouteApi.PATH_FRAGMENT_DETAILS_JIANKANGSHIPU,map = mapOf("mId" to recommendList[4].id))
                    }
                }
                if (recommendList.size>5){
                    findViewById<TextView>(R.id.shipumingcheng_bottom_right_title_tv).text =  recommendList[5].shipumingcheng.toString()
                    findViewById<ImageView>(R.id.fengmian_bottom_right_img_iv).load(context,recommendList[5].fengmian.split(",")[0], needPrefix = !(recommendList[5].fengmian.startsWith("http")))
                    findViewById<ViewGroup>(R.id.rec_bottom_right_fbl).isVisible =true
                    findViewById<ViewGroup>(R.id.rec_bottom_right_fbl).setOnClickListener {
                        ArouterUtils.startFragment(CommonArouteApi.PATH_FRAGMENT_DETAILS_JIANKANGSHIPU,map = mapOf("mId" to recommendList[5].id))
                    }
                }
            })
            }
        }
}

    /**轮播图*/
    private fun FragmentIndexLayoutBinding.initBanner() {
        HomeRepository.list<ConfigItemBean>("config", mapOf("page" to "1", "limit" to "3")).observeKt{
            it.getOrNull()?.let {
                banner.setAdapter(object :
                    BannerImageAdapter<ConfigItemBean>(it.data.list.filter { it.name.contains("swiper") }) {
                    override fun onBindView(
                        holder: BannerImageHolder,
                        data: ConfigItemBean,
                        position: Int,
                        size: Int
                    ) {
                        activity?.let { holder.imageView.load(it, data.value.split(",")[0], radius = 5.dp) }
                    }
                }).setOnBannerListener { data, position ->
                    data.toConversion<ConfigItemBean>()?.let {
                        it.name.showToast()
                    }
                }
            }
        }
    }
    /**菜单*/
    private fun FragmentIndexLayoutBinding.initMenu() {
        val menuList = mutableListOf<MenuBean>()
        menuGl.removeAllViews()
            roleMenusList.filter { it.tableName == CommonBean.tableName }.forEach {/*筛选可查看的菜单*/
                it.frontMenu.forEach {
                    val menuBean = MenuBean(
                        child = it.child.filter {child->child.buttons.contains("查看")},
                        menu = it.menu?:"", fontClass = it.fontClass?:"", unicode = it.unicode?:"")
                    menuList.add(menuBean)
                }
            }
        menuList.forEachIndexed { index, menu ->
            if (menu.child.size>0 && !listOf("yifahuodingdan","yituikuandingdan","yiquxiaodingdan","weizhifudingdan","yizhifudingdan","yiwanchengdingdan").contains(menu.child[0].tableName)){
                val itemView = creatMenuItemView(menu)
                menuGl.addView(itemView)
            }
        }
    }

    private fun creatMenuItemView(menu: MenuBean) = LayoutInflater.from(context).inflate(R.layout.item_index_menu_layout,binding.menuGl,false).apply{
        findViewById<TextView>(R.id.menu_title_tv).text = menu.menu.split("列表")[0]
        findViewById<TextView>(R.id.menu_icon_tv).text = Html.fromHtml(menu.unicode?:"")
        setOnClickListener {
            if (menu.child.size>1){//二级菜单
                XPopup.Builder(requireActivity()).asBottomList("",
                    menu.child.map {it.menu}.toTypedArray()
                ) { position, text ->
                    ArouterUtils.startFragment("/ui/fragment/${menu.child[position].tableName}/list")
                }.show()
            }else{// 一级菜单
                ArouterUtils.startFragment("/ui/fragment/${menu.child[0].tableName}/list")
            }
        }
    }

}