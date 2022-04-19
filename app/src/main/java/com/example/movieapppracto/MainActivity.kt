package com.example.movieapppracto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity()
{
    private lateinit var newRecylerView: RecyclerView
    private lateinit var newArrayList: ArrayList<ItemView>
    lateinit var movieImage:Array<Int>
    lateinit var movieName:Array<String>
    lateinit var releaseDate:Array<String>
    lateinit var description:Array<String>


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        movieImage= arrayOf(
            R.drawable.wonderwoman,
            R.drawable.outsidethewire,
            R.drawable.soul,
            R.drawable.skylines,
            R.drawable.avengers,
            );

        movieName= arrayOf(
            "Wonder Woman 1984",
            "Outside the Wire",
            "Soul",
            "SkyLines",
            "Avengers Endgame"
        )

        releaseDate= arrayOf(
            "December 15, 2020",
            "January 15, 2021",
            "October 11, 2020",
            "November 11, 2010",
            "April 22, 2019"
        )

        description= arrayOf(
            "Wonder Woman 1984 (also known as WW84[1]) is a 2020 American superhero film based on the DC Comics character Wonder Woman. Produced by Warner Bros.",
            "Outside the Wire is a 2021 American science fiction action film directed by Mikael Håfström. It stars Anthony Mackie (who also produced) as an android officer who works with a drone pilot (Damson Idris) to stop a global catastrophe.",
            "Soul is a 2020 American computer-animated comedy-drama film produced by Pixar Animation Studios for Walt Disney Pictures, directed by Pete Docter, and written by Docter, Mike Jones, and Kemp Powers",
            "Skyline is a 2010 American science fiction disaster film directed by Greg and Colin Strause and co-produced and written by Liam O'Donnell.",
            "Avengers: Endgame is a 2019 American superhero film based on the Marvel Comics superhero team the Avengers. Produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures"
        )

        newRecylerView=findViewById(R.id.recyclerView);
        newRecylerView.layoutManager=LinearLayoutManager(this);
        newRecylerView.setHasFixedSize(true);

        newArrayList= arrayListOf<ItemView>();

        getMovieData();

    }
    private fun getMovieData()
    {
        for(i in movieImage.indices)
        {
            val movie=ItemView(movieImage[i],movieName[i],releaseDate[i],description[i]);
            newArrayList.add(movie);
        }
        var adapter=movieAdapater(newArrayList);
        newRecylerView.adapter=adapter

        adapter.setOnItemClickListener(object : movieAdapater.onItemClickListener{
            override fun onItemClick(position: Int)
            {
                 val intent= Intent(this@MainActivity,MovieActivity::class.java)
                 intent.putExtra("movieName",newArrayList[position].movieName);
                 intent.putExtra("movieImage",newArrayList[position].movieImage);
                 intent.putExtra("movieDetails",newArrayList[position].description);

                 startActivity(intent);

            }

        })
    }
}