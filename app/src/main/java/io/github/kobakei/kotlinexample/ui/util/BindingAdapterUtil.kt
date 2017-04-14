package io.github.kobakei.kotlinexample.ui.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * BindingAdapter
 * Javaではstaticメソッドで定義していたが、Kotlinでは拡張関数を使うのがスマートぽい
 *
 * Created by keisukekobayashi on 2017/04/14.
 */
@BindingAdapter(value = "imageUrl")
fun ImageView.setImageUrl(url: String?) {
    if (url != null) {
        Glide.with(this.context).load(url).into(this)
    }
}