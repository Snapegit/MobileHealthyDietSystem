package com.design.appproject.ui.binglidan
import com.union.union_basic.ext.otherwise
import com.union.union_basic.ext.yes
import android.widget.ImageView
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.design.appproject.R
import com.design.appproject.bean.BinglidanItemBean
import com.design.appproject.widget.LoadMoreAdapter
import com.design.appproject.ext.load
import com.design.appproject.utils.Utils

/**
 * 病例单适配器列表
 */
class ListAdapter : LoadMoreAdapter<BinglidanItemBean>(R.layout.binglidan_list_item_layout) {

    var mIsBack = false/*是否后台进入*/
    override fun convert(holder: BaseViewHolder, item: BinglidanItemBean) {
        holder.setText(R.id.jiuzhenshijian_tv, item.jiuzhenshijian)
        holder.setText(R.id.yonghuzhanghao_tv, item.yonghuzhanghao)
        holder.setText(R.id.yonghuxingming_tv, item.yonghuxingming)
        mIsBack.yes {
            holder.setGone(R.id.edit_fl,!Utils.isAuthBack("binglidan","修改"))
            holder.setGone(R.id.delete_fl,!Utils.isAuthBack("binglidan","删除"))
        }.otherwise {
            holder.setGone(R.id.edit_fl,!Utils.isAuthFront("binglidan","修改"))
            holder.setGone(R.id.delete_fl,!Utils.isAuthFront("binglidan","删除"))
        }
    }
}