package com.example.user.retrofitting.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.retrofitting.ui.activities.DetailsActivity;
import com.example.user.retrofitting.R;
import com.example.user.retrofitting.mvp.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by User on 2/13/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private Context mContext;
    private List<Movie> movies;
    private int rowLayout;
    public static final String TAG=MovieAdapter.class.getSimpleName();

    public MovieAdapter(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        mContext = context;
        this.rowLayout = rowLayout;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.mTitleField.setText(movies.get(position).getTitle());
        Picasso.with(holder.mPosterImage.getContext()).load("https://image.tmdb.org/t/p/w300"+movies.get(position).getPosterPath()).into(holder.mPosterImage);
        holder.mSumamryField.setText(movies.get(position).getOverView());
        holder.mDateField.setText(movies.get(position).getReleaseDate());

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView mTitleField;
        TextView mSumamryField;
        TextView mDateField;
        ImageView mPosterImage;

        public MovieViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleField= (TextView) itemView.findViewById(R.id.titleField);
            mSumamryField=(TextView)itemView.findViewById(R.id.summaryField);
            mDateField=(TextView)itemView.findViewById(R.id.dateField);
            mPosterImage=(ImageView)itemView.findViewById(R.id.image_poster);

        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            Toast.makeText(mContext, "You clicked on the item", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(mContext,DetailsActivity.class);
           int id= movies.get(position).getId();
            Log.e(TAG,id+"");
            intent.putExtra("movie_id",id);
            mContext.startActivity(intent);
        }
    }
}
