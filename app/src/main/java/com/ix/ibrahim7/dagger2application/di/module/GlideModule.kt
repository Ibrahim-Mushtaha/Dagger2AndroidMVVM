package com.ix.ibrahim7.dagger2application.di.module

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.ix.ibrahim7.dagger2application.di.module.GlideModule.fetchSvg
import com.ix.ibrahim7.dagger2application.R
import com.pixplicity.sharp.Sharp
import dagger.Module
import dagger.Provides
import okhttp3.*
import java.io.IOException
import java.io.InputStream
import javax.inject.Singleton


@Module
object GlideModule {



    private var httpClient: OkHttpClient? = null

    @Provides
    fun Context.provideGlide(): RequestManager? {
        return Glide.with(this)
    }

    @Singleton
    @Provides
    fun Context.fetchSvg(url: String?, target: ImageView):Boolean {
        if (httpClient == null) {
            // Use cache for performance and basic offline capability
             httpClient =RetrofitModule.provideOkHttpClient(Cache(this.cacheDir, 5 * 1024 * 1014))
        }
        val request: Request = Request.Builder().url(url!!).build()
        httpClient!!.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {
                target.setImageDrawable(ContextCompat.getDrawable(this@fetchSvg,R.drawable.ic_launcher_background))
            }

            override fun onResponse(call: Call, response: Response) {
                val stream: InputStream = response.body!!.byteStream()
                try {
                    Sharp.loadInputStream(stream).into(target)
                    stream.close()
                }catch (e:Exception){}
            }
        })
        return true
    }


}