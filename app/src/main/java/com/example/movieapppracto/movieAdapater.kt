package com.example.movieapppracto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class movieAdapater(private val movieList:ArrayList<ItemView>)
    : RecyclerView.Adapter<movieAdapater.MyViewHolder>()
{

    private lateinit var onlistener : onItemClickListener

    interface onItemClickListener
    {
        fun onItemClick(position: Int)

    }
    fun setOnItemClickListener(listener: onItemClickListener)
    {
        onlistener=listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): movieAdapater.MyViewHolder
    {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false);

        return MyViewHolder(itemView,onlistener);

    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int)
    {

        val curItem=movieList[position];
        holder.movieImage.setImageResource(curItem.movieImage);
        holder.movieName.text=curItem.movieName;
        holder.releaseDate.text=curItem.releaseDate;
        holder.description.text=curItem.description;

    }

    override fun getItemCount(): Int
    {
        return movieList.size;

    }

    class MyViewHolder(itemView: View,listener: onItemClickListener) :RecyclerView.ViewHolder(itemView)
    {
        val movieImage :ImageView=itemView.findViewById(R.id.movie_Image);
        val movieName :TextView=itemView.findViewById(R.id.movieName);
        val releaseDate:TextView=itemView.findViewById(R.id.releasedate);
        val description:TextView=itemView.findViewById(R.id.description);

        init
        {
            itemView.setOnClickListener {

                listener.onItemClick(adapterPosition);
            }

        }

    }

}