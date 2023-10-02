package com.codepath.articlesearch

import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import androidx.core.util.Pair


const val ARTICLE_EXTRA = "ARTICLE_EXTRA"
private const val TAG = "ArticleAdapter"

class ArticleAdapter(private val context: Context, private val movies: List<Movie>) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO: Get the individual article and bind to holder
        val article = movies[position]
        holder.bind(article)
    }

    override fun getItemCount() = movies.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val mediaImageView = itemView.findViewById<ImageView>(R.id.mediaImage) //TODO update for xml
        private val titleTextView = itemView.findViewById<TextView>(R.id.mediaTitle) //TODO update for xml
//        private val abstractTextView = itemView.findViewById<TextView>(R.id.mediaAbstract) //TODO update for xml

        init {
            itemView.setOnClickListener(this)
        }

        // TODO: Write a helper method to help set up the onBindViewHolder method
        fun bind(movie: Movie) {
            titleTextView.text = movie.title //TODO change to movie title
//            abstractTextView.text = movie.firstAirDate //TODO comment this out

            val radius = 10; // corner radius, higher value = more rounded
            val margin = 50; // crop margin, set to 0 for corners with no crop
            Glide.with(context)
                .load(movie.mediaImageUrl)
                .circleCrop() // scale image to fill the entire ImageView
                .transform(RoundedCorners(margin))
                .into(mediaImageView)
        }
        override fun onClick(v: View?) {
            val activity = context as MainActivity
            // TODO: Get selected article
            val article = movies[absoluteAdapterPosition]
            // TODO: Navigate to Details screen and pass selected article
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(ARTICLE_EXTRA, article)
            val p1 = Pair<View, String>(mediaImageView, "movie")
            val p2 = Pair<View, String>(titleTextView, "title")
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, p1, p2)
            context.startActivity(intent, options.toBundle())
        }
    }
}