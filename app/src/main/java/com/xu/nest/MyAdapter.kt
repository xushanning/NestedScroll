package com.xu.nest


import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


/**
 * @author 许 on 2024/6/29.
 */
class MyAdapter : RecyclerView.Adapter<MyAdapter.MyHolder>() {
    var list = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        val view = View.inflate(parent.context, R.layout.item, null)
        return MyHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.tv?.text = list[position]
    }

    fun setData(list: ArrayList<String>) {
        this.list = list
    }

    class MyHolder(iteView: View) : RecyclerView.ViewHolder(iteView) {
        var tv: TextView? = null

        init {
            tv = iteView.findViewById(R.id.tv_title)
        }

    }
}