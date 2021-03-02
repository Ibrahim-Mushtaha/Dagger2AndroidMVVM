package com.ix.ibrahim7.dagger2application.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ix.ibrahim7.dagger2application.R
import com.ix.ibrahim7.dagger2application.databinding.ItemCountryBinding
import com.ix.ibrahim7.dagger2application.model.country.CountryItem
import com.ix.ibrahim7.dagger2application.other.getImage
import com.ix.ibrahim7.dagger2application.other.setItemAnimation
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(var data: ArrayList<CountryItem>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    private var on_attach = true

    class CountryViewHolder(val item: ItemCountryBinding) : RecyclerView.ViewHolder(item.root) {

        fun bind(n: CountryItem) {
            item.country = n
            item.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val itemView_layout: ItemCountryBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_country, parent, false)
        return CountryViewHolder(itemView_layout)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        val currentitem = data[position]
        holder.item.root.apply {
           setItemAnimation(this, position,on_attach)
            getImage(currentitem.flag!!,tvImage)
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