package com.example.shubham.Bitts_moviE;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetailsActivity extends AppCompatActivity {

    TextView title,overview,releasedate,voteaverage;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        title= (TextView) findViewById(R.id.textViewMovieTitle);
        overview= (TextView) findViewById(R.id.textViewMovieOverview);
        releasedate= (TextView) findViewById(R.id.textViewReleasedate);
        voteaverage= (TextView) findViewById(R.id.textViewVoteaverage);

        imageView= (ImageView) findViewById(R.id.poster);

        MovieDetails details = (MovieDetails) getIntent().getExtras().getSerializable("MOVIE DETAILS");

        if (details != null){
            Glide.with(this).load("https://image.tmdb.org/t/p/w500/"+ details.getPoster_path()).into(imageView);
            title.setText(details.getOriginal_title());
            overview.setText(details.getOverview());
            releasedate.setText(details.getRelease_date());
            voteaverage.setText(Double.toString(details.getVote_average()));


        }


    }
}
