package com.example.rakesh.allnetworktestprojectimagedownloand.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rakesh.allnetworktestprojectimagedownloand.R;
import com.example.rakesh.allnetworktestprojectimagedownloand.dto.volley.dto.VolleyImageResponse;



import java.util.List;


public class RetrofitImageAdapter extends RecyclerView.Adapter<RetrofitImageAdapter.MyViewHolder> {

    private List<VolleyImageResponse> mResponse;
    private Context mContext;

    public RetrofitImageAdapter(Context context,List<VolleyImageResponse> volleyImageResponses) {
        mResponse = volleyImageResponses;
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
       // View view = inflater.inflate(R.layout.json_row_image_adapter, parent, false);
        View view = inflater.inflate(R.layout.test_second_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.mFilmName.setText(mResponse.get(position).name);
        holder.mDate.setText(mResponse.get(position).getTimestamp());


        Glide.with(mContext)
                .load(mResponse.get(position).getUrl().getLarge())
                .centerCrop()
                .into(holder.mImageView);

        holder.mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return mResponse.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mFilmName;
        private TextView mDate;
        private TextView mChannelName;
        private ImageView mImageView;
        private ProgressBar mProgressBar;

        public MyViewHolder(View view) {
            super(view);
            mFilmName = (TextView) view.findViewById(R.id.film_name);
            mDate = (TextView) view.findViewById(R.id.date);
            mChannelName = (TextView) view.findViewById(R.id.channnel_name);
            mImageView = (ImageView) view.findViewById(R.id.image_view);
            mProgressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        }
    }
}
