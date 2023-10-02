package com.codepath.articlesearch

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {
    private lateinit var mediaImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var bylineTextView: TextView
    private lateinit var abstractTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // TODO: Find the views for the screen
        mediaImageView = findViewById(R.id.mediaImage)
        titleTextView = findViewById(R.id.mediaTitle)
        bylineTextView = findViewById(R.id.mediaByline)
        abstractTextView = findViewById(R.id.mediaAbstract)

        // TODO: Get the extra from the Intent
        val movie = intent.getSerializableExtra(ARTICLE_EXTRA) as Movie

        // TODO: Set the title, title, and firstAirDate information from the article
        titleTextView.text = movie.originalTitle //(format is like "take "main" out of "title"[])
        bylineTextView.text = "First Air Date: " + movie.firstAirDate
        abstractTextView.text = movie.overview

        // TODO: Load the media image
        Glide.with(this)
            .load(movie.movieImageUrl)
            .into(mediaImageView)
    }
}