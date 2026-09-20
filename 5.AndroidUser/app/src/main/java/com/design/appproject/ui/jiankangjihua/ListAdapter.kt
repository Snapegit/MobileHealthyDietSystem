package com.design.appproject.ui.jiankangjihua
import com.union.union_basic.ext.otherwise
import com.union.union_basic.ext.yes
import android.widget.ImageView
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.design.appproject.R
import com.design.appproject.bean.JiankangjihuaItemBean
import com.design.appproject.widget.LoadMoreAdapter
import com.design.appproject.ext.load
import com.design.appproject.utils.Utils

/**
 * 健康计划适配器列表
 */
class ListAdapter : LoadMoreAdapter<JiankangjihuaItemBean>(R.layout.jiankangjihua_list_item_layout) {

    var mIsBack = false/*是否后台进入*/
    override fun convert(holder: BaseViewHolder, item: JiankangjihuaItemBean) {
        holder.setText(R.id.riqi_tv, item.riqi)
        holder.setText(R.id.yonghuzhanghao_tv, item.yonghuzhanghao)
        holder.setText(R.id.yonghuxingming_tv, item.yonghuxingming)
        mIsBack.yes {
            holder.setGone(R.id.edit_fl,!Utils.isAuthBack("jiankangjihua","修改"))
            holder.setGone(R.id.delete_fl,!Utils.isAuthBack("jiankangjihua","删除"))
        }.otherwise {
            holder.setGone(R.id.edit_fl,!Utils.isAuthFront("jiankangjihua","修改"))
            holder.setGone(R.id.delete_fl,!Utils.isAuthFront("jiankangjihua","删除"))
        }
    }
}