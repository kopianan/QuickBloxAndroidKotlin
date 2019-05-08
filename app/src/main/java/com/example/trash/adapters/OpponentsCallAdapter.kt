package com.example.trash.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.example.trash.R
import com.quickblox.users.model.QBUser
import kotlinx.android.synthetic.main.list_item_opponent_from_call.view.*

class OpponentsCallAdapter(context: Context, val opponents: ArrayList<QBUser>, var itemWidth: Int, var itemHeight: Int) : androidx.recyclerview.widget.RecyclerView.Adapter<OpponentsCallAdapter.ViewHolder>() {
    private val TAG = OpponentsCallAdapter::class.java.simpleName
    private var inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.list_item_opponent_from_call)
        val vh = ViewHolder(view)
        initCellHeight(vh)
        return vh
    }

    private fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return inflater.inflate(layoutRes, this, attachToRoot)
    }

    fun initCellHeight(holder: ViewHolder, height: Int = itemHeight) {
        val params = holder.itemView.item_layout.layoutParams
        params.height = height
        holder.itemView.item_layout.layoutParams = params
    }

    override fun getItemCount(): Int {
        return opponents.size
    }

    fun add(item: QBUser) {
        opponents.add(item)
        notifyItemRangeChanged(opponents.size - 1, opponents.size)
    }

    fun removeItem(index: Int) {
        opponents.removeAt(index)
        notifyItemRemoved(index)
        notifyItemRangeChanged(index, opponents.size)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = opponents[position]
        val userID = user.id
      //  holder.itemView.opponent_name.id = user.id
        holder.userId = userID
       // holder.itemView.opponent_name.text = user.fullName ?: user.login
    }

    class ViewHolder(override val containerView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(containerView), LayoutContainer {
        var userId: Int = 0
    }

}

interface LayoutContainer {
val containerView: View?
}
