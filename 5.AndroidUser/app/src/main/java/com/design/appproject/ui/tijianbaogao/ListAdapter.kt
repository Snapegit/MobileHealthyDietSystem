package com.design.appproject.ui.tijianbaogao
import com.union.union_basic.ext.otherwise
import com.union.union_basic.ext.yes
import android.widget.ImageView
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.design.appproject.R
import com.design.appproject.bean.TijianbaogaoItemBean
import com.design.appproject.widget.LoadMoreAdapter
import com.design.appproject.ext.load
import com.design.appproject.utils.Utils

/**
 * 体检报告适配器列表
 */
class ListAdapter : LoadMoreAdapter<TijianbaogaoItemBean>(R.layout.tijianbaogao_list_item_layout) {

    var mIsBack = false/*是否后台进入*/
    override fun convert(holder: BaseViewHolder, item: TijianbaogaoItemBean) {
        holder.setText(R.id.tijianriqi_tv, item.tijianriqi)
        holder.setText(R.id.yonghuzhanghao_tv, item.yonghuzhanghao)
        holder.setText(R.id.yonghuxingming_tv, item.yonghuxingming)
        mIsBack.yes {
            holder.setGone(R.id.edit_fl,!Utils.isAuthBack("tijianbaogao","修改"))
            holder.setGone(R.id.delete_fl,!Utils.isAuthBack("tijianbaogao","删除"))
        }.otherwise {
            holder.setGone(R.id.edit_fl,!Utils.isAuthFront("tijianbaogao","修改"))
            holder.setGone(R.id.delete_fl,!Utils.isAuthFront("tijianbaogao","删除"))
        }
    }
}