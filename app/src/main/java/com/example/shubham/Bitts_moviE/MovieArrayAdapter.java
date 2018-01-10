package com.example.shubham.Bitts_moviE;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by shubham on 7/1/2017.
 */

public class MovieArrayAdapter extends ArrayAdapter {

    private Context context;
    private int resource;
    private List<MovieDetails> movieDetailsList;


    public MovieArrayAdapter( Context context,  int resource,  List<MovieDetails> movieDetail) {
        super(context, resource,movieDetail );

        this.context = context;
        this.resource = resource;
        this.movieDetailsList=movieDetail;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        MovieDetails details = movieDetailsList.get(position);

       View view = LayoutInflater.from(context).inflate(resource,parent,false);

        TextView movieName= (TextView) view.findViewById(R.id.textView2);
        ImageView movieImage = (ImageView) view.findViewById(R.id.imageView);

        movieName.setText(details.getOriginal_title());


        Glide.with(context).load("https://image.tmdb.org/t/p/w500/"+ details.getPoster_path()).into(movieImage);


        return view;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return movieDetailsList.get(position);
    }
}
