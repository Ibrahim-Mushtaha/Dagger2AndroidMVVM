package com.ix.ibrahim7.dagger2application.model

import javax.inject.Inject

class Coffee @Inject constructor(private var farm: Farm, private var river: River) {

}