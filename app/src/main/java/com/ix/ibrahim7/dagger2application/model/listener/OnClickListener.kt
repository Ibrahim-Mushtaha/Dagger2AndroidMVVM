package com.ix.ibrahim7.dagger2application.model.listener

import com.ix.ibrahim7.dagger2application.adapter.GenericAdapter

abstract class OnClickListener {
    var adapterPosition: Int = -1
    var onListItemViewClickListener: GenericAdapter.OnListItemViewClickListener? = null
}