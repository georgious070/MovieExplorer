package com.movie.moviewexplorer.ui

import android.graphics.Typeface
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*

val dateFormat = SimpleDateFormat("yyyy-MM-dd")

fun getYear(year: String) =
        Calendar.getInstance()
                .apply { time = dateFormat.parse(year) }
                .get(Calendar.YEAR)

@BindingAdapter("coloredYear")
fun TextView.setColoredYear(movieYear: String) {
    if (Calendar.getInstance().get(Calendar.YEAR) == getYear(movieYear)) {
        typeface = Typeface.DEFAULT_BOLD
        setTextColor(ContextCompat.getColor(context, android.R.color.holo_red_light))
    }
}

@BindingAdapter("imageUrl")
fun ImageView.setImageUri(url: String?) {
    when (url) {
        null -> setImageDrawable(null)
        else -> Picasso.get()
                .load("http://image.tmdb.org/t/p/w185/$url")
                .into(this)
    }
}