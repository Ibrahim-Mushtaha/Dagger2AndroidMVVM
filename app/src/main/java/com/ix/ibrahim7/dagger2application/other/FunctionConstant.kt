package com.ix.ibrahim7.dagger2application.other

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.ix.ibrahim7.dagger2application.R
import com.ix.ibrahim7.dagger2application.di.module.GlideModule
import com.ix.ibrahim7.dagger2application.di.module.GlideModule.fetchSvg
import com.ix.ibrahim7.dagger2application.di.module.GlideModule.provideGlide
import com.ix.ibrahim7.dagger2application.di.module.RetrofitModule
import com.pixplicity.sharp.Sharp
import okhttp3.*
import java.io.IOException
import java.io.InputStream


fun View.setItemAnimation(itemView: View, i: Int,on_attach:Boolean =true) {
    var i = i
    if (!on_attach) {
        i = -1
    }
    val isNotFirstItem = i == -1
    i++
    itemView.alpha = 0f
    val animatorSet = AnimatorSet()
    val animator = ObjectAnimator.ofFloat(itemView, ALPHA, 0f, 0.5f, 1.0f)
    ObjectAnimator.ofFloat(itemView, ALPHA, 0f).start()
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
            Log.e("$TAG image failed",e!!.message.toString())
            return false
        }

        override fun onResourceReady(
            resource: Drawable?,
            model: Any?,
            target: Target<Drawable>?,
            dataSource: DataSource?,
            isFirstResource: Boolean
        ): Boolean {
            Log.e("$TAG image","done")
            return false
        }

    }).into(imageView)
}


fun Context.getSvgImage(url:String,imageView: ImageView) {
    this.fetchSvg(url,imageView)
}



@BindingAdapter("android:src")
fun loadImage(view: ImageView, url: String) {
    if (GlideModule.httpClient == null) {
        // Use cache for performance and basic offline capability
        GlideModule.httpClient =
            RetrofitModule.provideOkHttpClient(Cache(view.context.cacheDir, 5 * 1024 * 1014))
    }
    val request: Request = Request.Builder().url(url).build()
    GlideModule.httpClient!!.newCall(request).enqueue(object : Callback {

        override fun onFailure(call: Call, e: IOException) {
            view.setImageDrawable(ContextCompat.getDrawable(view.context, R.drawable.ic_launcher_background))
        }

        override fun onResponse(call: Call, response: Response) {
            val stream: InputStream = response.body!!.byteStream()
            try {
                Sharp.loadInputStream(stream).into(view)
                stream.close()
            }catch (e:Exception){}
        }
    })
}