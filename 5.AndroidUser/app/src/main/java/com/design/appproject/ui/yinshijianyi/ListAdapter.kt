package com.design.appproject.ui.yinshijianyi
import com.union.union_basic.ext.otherwise
import com.union.union_basic.ext.yes
import android.widget.ImageView
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.design.appproject.R
import com.design.appproject.bean.YinshijianyiItemBean
import com.design.appproject.widget.LoadMoreAdapter
import com.design.appproject.ext.load
import com.design.appproject.utils.Utils

/**
 * 饮食建议适配器列表
 */
class ListAdapter : LoadMoreAdapter<YinshijianyiItemBean>(R.layout.yinshijianyi_list_item_layout) {

    var mIsBack = false/*是否后台进入*/
    override fun convert(holder: BaseViewHolder, item: YinshijianyiItemBean) {
        mIsBack.yes {
            holder.setGone(R.id.edit_fl,!Utils.isAuthBack("yinshijianyi","修改"))
            holder.setGone(R.id.delete_fl,!Utils.isAuthBack("yinshijianyi","删除"))
        }.otherwise {
            holder.setGone(R.id.edit_fl,!Utils.isAuthFront("yinshijianyi","修改"))
            holder.setGone(R.id.delete_fl,!Utils.isAuthFront("yinshijianyi","删除"))
        }
    }
}