package com.ix.ibrahim7.dagger2application.other

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View



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