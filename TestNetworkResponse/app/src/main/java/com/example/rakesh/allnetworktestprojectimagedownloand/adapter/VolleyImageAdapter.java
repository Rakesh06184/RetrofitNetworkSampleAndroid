package com.example.rakesh.allnetworktestprojectimagedownloand.adapter;


/**
 * Created by rakesh on 15/9/16.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.example.rakesh.allnetworktestprojectimagedownloand.R;
import com.example.rakesh.allnetworktestprojectimagedownloand.dto.volley.dto.VolleyImageResponse;
import com.example.rakesh.allnetworktestprojectimagedownloand.Volleynetwork.VolleyHelper;

import java.util.List;

public class VolleyImageAdapter extends RecyclerView.Adapter<VolleyImageAdapter.TestViewHolder> {

    private List<VolleyImageResponse> mResponse;
    private Context mContext;

    public VolleyImageAdapter(Context context,List<VolleyImageResponse> response) {
        mResponse = response;
        mContext = context;
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.json_row_image_adapter, parent, false);
        TestViewHolder testViewHolder = new TestViewHolder(view);
        return testViewHolder;
    }

    @Override
    public void onBindViewHolder(final TestViewHolder holder, int position) {
        holder.mFilmName.setText(mResponse.get(position).name);
        holder.mDate.setText(mResponse.get(position).getTimestamp());

        ImageRequest imageRequest = new ImageRequest(mResponse.get(position).getUrl().getLarge(), new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {

                holder.mImageView.setImageBitmap(bitmap);
            }
        }, 0 , 0 , null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               String errorMessage = error.getMessage();
                Log.d("raka","volley error response adaper  "+errorMessage);

            }
        });

        VolleyHelper.getInstance(mContext).addToRequestQueue(imageRequest);
    }

    @Override
    public int getItemCount() {
        return mResponse.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class TestViewHolder extends RecyclerView.ViewHolder {
        private TextView mFilmName;
        private TextView mDate;
        private ImageView mImageView;

        public TestViewHolder(View view) {
            super(view);
            mFilmName = (TextView) view.findViewById(R.id.film_name);
            mDate = (TextView) view.findViewById(R.id.date);
            mImageView = (ImageView) view.findViewById(R.id.image_view);
        }
    }
}
