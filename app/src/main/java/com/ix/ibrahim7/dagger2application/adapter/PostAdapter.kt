package com.ix.ibrahim7.dagger2application.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ix.ibrahim7.dagger2application.R
import com.ix.ibrahim7.dagger2application.databinding.ItemPostBinding
import com.ix.ibrahim7.dagger2application.model.PostItem
import com.ix.ibrahim7.dagger2application.other.setItemAnimation

class PostAdapter(var data: ArrayList<PostItem>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private var on_attach = true

    class PostViewHolder(val item: ItemPostBinding) : RecyclerView.ViewHolder(item.root) {

        fun bind(n: PostItem) {
            item.post = n
            item.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView_layout: ItemPostBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_post, parent, false)
        return PostViewHolder(itemView_layout)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        val currentitem = data[position]
        holder.item.root.apply {
           setItemAnimation(this, position,on_attach)
        }
        holder.bind(currentitem)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                Log.d("eee", "onScrollStateChanged: Called $newState")
                on_attach = false
                super.onScrollStateChanged(recyclerView, newState)
            }
        })
        super.onAttachedToRecyclerView(recyclerView)
    }

}