package com.design.appproject.ui.jiankangshipu
import com.union.union_basic.ext.otherwise
import com.union.union_basic.ext.yes
import android.widget.ImageView
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.design.appproject.R
import com.design.appproject.bean.JiankangshipuItemBean
import com.design.appproject.widget.LoadMoreAdapter
import com.design.appproject.ext.load
import com.design.appproject.utils.Utils

/**
 * 健康食谱适配器列表
 */
class ListAdapter : LoadMoreAdapter<JiankangshipuItemBean>(R.layout.jiankangshipu_list_item_layout) {

    var mIsBack = false/*是否后台进入*/
    override fun convert(holder: BaseViewHolder, item: JiankangshipuItemBean) {
        holder.setText(R.id.shipumingcheng_tv, item.shipumingcheng)
        val img = item.fengmian.split(",")[0]
        holder.getView<ImageView>(R.id.picture_iv).load(context,img, needPrefix = !img.startsWith("http"))
        mIsBack.yes {
            holder.setGone(R.id.edit_fl,!Utils.isAuthBack("jiankangshipu","修改"))
            holder.setGone(R.id.delete_fl,!Utils.isAuthBack("jiankangshipu","删除"))
        }.otherwise {
            holder.setGone(R.id.edit_fl,!Utils.isAuthFront("jiankangshipu","修改"))
            holder.setGone(R.id.delete_fl,!Utils.isAuthFront("jiankangshipu","删除"))
        }
    }
}