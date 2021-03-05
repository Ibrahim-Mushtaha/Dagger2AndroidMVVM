package com.ix.ibrahim7.dagger2application.model

import com.ix.ibrahim7.dagger2application.adapter.GenericAdapter

abstract class ListItemViewModel {
    var adapterPosition: Int = -1
    var onListItemViewClickListener: GenericAdapter.OnListItemViewClickListener? = null
}