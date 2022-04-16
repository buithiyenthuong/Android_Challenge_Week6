package com.Android_w6.nhom14.challenge_w6.Activity.Movie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.Android_w6.nhom14.challenge_w6.OnItemClickListener
import com.Android_w6.nhom14.challenge_w6.Model.Movie
import com.Android_w6.nhom14.challenge_w6.R


class MovieRcvAdapter(ItemViewLayout: Int, ctx: Context, listener: OnItemClickListener) :
    RecyclerView.Adapter<MovieRcvAdapter.ViewHolder>() {
    private var listener : OnItemClickListener = listener
    private var itemViewAdapt: Int = ItemViewLayout
    private var context: Context = ctx
    var data = mutableListOf<Movie>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var layoutInflater = LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(itemViewAdapt, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var item = data[position]
        holder.tvName.text = item.originalTitle
        holder.tvAddress.text = "Rate: "+item.voteAverage.toString()
        var strtemp="https://image.tmdb.org/t/p/w500"+item.backdropPath
        Glide.with(context).load(strtemp).centerCrop().placeholder(R.drawable.loading_icon).into(holder.imageAvatar)
        holder.itemV.setOnClickListener{
            listener.onItemClick(item)
        }
    }

    override fun getItemCount(): Int {

        return data.size
    }

    //Create ViewHolder
    class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvAddress = itemView.findViewById<TextView>(R.id.tvAddress)
        val imageAvatar = itemView.findViewById<ImageView>(R.id.imageView9)
        val itemV=itemView
    }

}