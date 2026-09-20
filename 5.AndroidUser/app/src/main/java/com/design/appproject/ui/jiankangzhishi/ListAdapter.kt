package com.design.appproject.ui.jiankangzhishi
import com.union.union_basic.ext.otherwise
import com.union.union_basic.ext.yes
import android.widget.ImageView
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.design.appproject.R
import com.design.appproject.bean.JiankangzhishiItemBean
import com.design.appproject.widget.LoadMoreAdapter
import com.design.appproject.ext.load
import com.design.appproject.utils.Utils

/**
 * 健康知识适配器列表
 */
class ListAdapter : LoadMoreAdapter<JiankangzhishiItemBean>(R.layout.jiankangzhishi_list_item_layout) {

    var mIsBack = false/*是否后台进入*/
    override fun convert(holder: BaseViewHolder, item: JiankangzhishiItemBean) {
        holder.setText(R.id.biaoti_tv,"标题:"+ item.biaoti)
        val img = item.tupian.split(",")[0]
        holder.getView<ImageView>(R.id.picture_iv).load(context,img, needPrefix = !img.startsWith("http"))
        holder.setText(R.id.fabiaoriqi_tv, item.fabiaoriqi)
        mIsBack.yes {
            holder.setGone(R.id.edit_fl,!Utils.isAuthBack("jiankangzhishi","修改"))
            holder.setGone(R.id.delete_fl,!Utils.isAuthBack("jiankangzhishi","删除"))
        }.otherwise {
            holder.setGone(R.id.edit_fl,!Utils.isAuthFront("jiankangzhishi","修改"))
            holder.setGone(R.id.delete_fl,!Utils.isAuthFront("jiankangzhishi","删除"))
        }
    }
}