package com.ix.ibrahim7.dagger2application.other

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.ix.ibrahim7.dagger2application.di.module.GlideModule
import com.ix.ibrahim7.dagger2application.di.module.GlideModule.fetchSvg
import com.ix.ibrahim7.dagger2application.di.module.GlideModule.provideGlide


fun View.setItemAnimation(itemView: View, i: Int,on_attach:Boolean =true) {
    var i = i
    if (!on_attach) {
        i = -1
    }
    val isNotFirstItem = i == -1
    i++
    itemView.alpha = 0f
    val animatorSet = AnimatorSet()
    val animator = ObjectAnimator.ofFloat(itemView, "alpha", 0f, 0.5f, 1.0f)
    ObjectAnimator.ofFloat(itemView, "alpha", 0f).start()
    animator.startDelay = if (isNotFirstItem) (DURATION / 2).toLong() else (i * DURATION / 3).toLong()
    animator.duration = 500
    animatorSet.play(animator)
    animator.start()
}

fun Context.getGlideImage(url:String,imageView: ImageView) {
    this.provideGlide()!!.load(url).listener(object :RequestListener<Drawable>{
        override fun onLoadFailed(
            e: GlideException?,
            model: Any?,
            target: Target<Drawable>?,
            isFirstResource: Boolean
        ): Boolean {
            Log.e("eee image failed",e!!.message.toString())
            return false
        }

        override fun onResourceReady(
            resource: Drawable?,
            model: Any?,
            target: Target<Drawable>?,
            dataSource: DataSource?,
            isFirstResource: Boolean
        ): Boolean {
            Log.e("eee image","done")
            return false
        }

    }).into(imageView)
}


fun Context.getSvgImage(url:String,imageView: ImageView) {
    this.fetchSvg(url,imageView)
}