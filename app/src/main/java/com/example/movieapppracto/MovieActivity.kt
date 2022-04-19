package com.example.movieapppracto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        val movieName: TextView =findViewById(R.id.name);
        val movieImage: ImageView=findViewById(R.id.movieimage);
        val movieDetails: TextView=findViewById(R.id.details);


        val bundle: Bundle?= intent.extras
        val heading=bundle!!.getString("movieName")
        val imageId=bundle.getInt("movieImage")
        val details=bundle.getString("movieDetails")


        movieName.text=heading
        movieImage.setImageResource(imageId);
        movieDetails.text=details

    }
}