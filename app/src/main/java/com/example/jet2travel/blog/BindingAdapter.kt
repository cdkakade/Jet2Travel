package com.example.jet2travel.blog

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.jet2travel.TAG
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.ln
import kotlin.math.pow
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime
import kotlin.time.milliseconds

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}

@BindingAdapter("likesFromConverter")
fun likesFromConverter(view: TextView, count: Long) {
    view.text = convert(count) + " Likes"
}

@BindingAdapter("commentsFromConverter")
fun commentsFromConverter(view: TextView, count: Long) {
    view.text = convert(count) + " Comments"
}

fun convert(count: Long): String {
    if (count < 1000)
        return "$count"
    val exp: Int = (ln(count.toDouble()) / ln(1000.0)).toInt()
    val format = DecimalFormat("0.#")
    val value = format.format(count / 1000.0.pow(exp))
    return String.format("%s%c", value, "KMBT"[exp - 1])
}

@ExperimentalTime
@BindingAdapter("elapsedTime")
fun getElapsedTime(view: TextView, datetime: String) {
    try {
        val blogDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US).parse(datetime)
        val currentDate = Calendar.getInstance()
        val difference = currentDate.timeInMillis - blogDate!!.time
        val days = difference.milliseconds.toInt(DurationUnit.DAYS)
        val hours = difference.milliseconds.toInt(DurationUnit.HOURS)
        val minutes = difference.milliseconds.toInt(DurationUnit.MINUTES)
        val seconds = difference.milliseconds.toInt(DurationUnit.SECONDS)
        if (days > 0) {
            view.text = String.format("%s%s", days, " day")
        } else if (hours > 0) {
            view.text = String.format("%s%s", days, " hr")
        } else if (minutes > 0) {
            view.text = String.format("%s%s", days, " min")
        } else if (seconds > 0) {
            view.text = String.format("%s%s", days, " sec")
        }

    } catch (e: Exception) {
        Log.e(TAG, "Exception in getElapsedTime", e)
    }

}