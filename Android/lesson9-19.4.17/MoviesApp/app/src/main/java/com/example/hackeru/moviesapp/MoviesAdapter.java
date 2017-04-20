package com.example.hackeru.moviesapp;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by hackeru on 4/19/2017.
 */

public class MoviesAdapter extends ArrayAdapter<Movie> {

    private Context context;
    private ArrayList<Movie> movies;
    private Handler handler;

    public MoviesAdapter(Context context, ArrayList<Movie> movies){
        super(context, R.layout.list_item, movies);
        this.context = context;
        this.movies = movies;
        handler = new Handler();
    }

    private class ViewHolder {
        TextView titleTV, yearTV;
        ImageView posterIV;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            viewHolder.posterIV = (ImageView) convertView.findViewById(R.id.list_item_image_view);
            viewHolder.titleTV = (TextView) convertView.findViewById(R.id.list_item_title_text_view);
            viewHolder.yearTV = (TextView) convertView.findViewById(R.id.list_item_year_text_view);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Movie movie = movies.get(position);

        viewHolder.titleTV.setText(movie.getTitle());
        viewHolder.yearTV.setText(movie.getYear() + "");

        //new DownloadImageThread(viewHolder.posterIV, movie.getPoster(), handler).start();
        new Thread(new GetDataRunnable(viewHolder.posterIV, movie.getPoster(), handler)).start();
        viewHolder.posterIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ImageActivity.class);
                intent.putExtra("IMAGE", movie.getPoster());
                context.startActivity(intent);
            }
        });
        //Picasso.with(context).load(movie.getPoster()).into(viewHolder.posterIV);

        return convertView;

    }
}
