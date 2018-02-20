package com.example.rakesh.allnetworktestprojectimagedownloand.UI;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rakesh.allnetworktestprojectimagedownloand.R;
import com.example.rakesh.allnetworktestprojectimagedownloand.adapter.RetrofitImageAdapter;
import com.example.rakesh.allnetworktestprojectimagedownloand.dto.volley.dto.VolleyImageResponse;
import com.example.rakesh.allnetworktestprojectimagedownloand.retrofit.RetrofitTestInterface;
import com.example.rakesh.allnetworktestprojectimagedownloand.retrofit.ServiceGenerator;
import com.example.rakesh.allnetworktestprojectimagedownloand.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class RetrofitImageDownloadFragment extends Fragment {

    private ProgressDialog mProgressDialog;
    private RecyclerView mRecyclerView;
    private ArrayList<VolleyImageResponse> mList;
    private static final String LIST_KEY = "list";

    public RetrofitImageDownloadFragment() {
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(LIST_KEY, mList);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_volley_gsaon_image_download, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState == null) {

            if (Utils.isNetworkAvailable(getContext())) {
                downloadImage();
            } else {
                Toast.makeText(getActivity(), getString(R.string.network_message), Toast.LENGTH_SHORT).show();
            }

        } else {
            mList = savedInstanceState.getParcelableArrayList(LIST_KEY);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(layoutManager);

            RetrofitImageAdapter retrofitImageAdapter = new RetrofitImageAdapter(getActivity(), mList);
            mRecyclerView.setAdapter(retrofitImageAdapter);
            retrofitImageAdapter.notifyDataSetChanged();
        }
    }


    private void downloadImage() {
        mList = new ArrayList<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        ServiceGenerator serviceGenerator = new ServiceGenerator();
        serviceGenerator.apiClientBaseUrl(getResources().getString(R.string.image_url_without_end_point));

        RetrofitTestInterface retrofitTestInterface = serviceGenerator.createService(RetrofitTestInterface.class);

        Call<List<VolleyImageResponse>> imageResponseCall = retrofitTestInterface.getImageResponse();

        imageResponseCall.enqueue(new Callback<List<VolleyImageResponse>>() {

            @Override
            public void onResponse(retrofit2.Response<List<VolleyImageResponse>> response) {

                if (getActivity() == null)
                    return;
                getImageResponse(response.body());
            }

            @Override
            public void onFailure(Throwable t) {

                Log.e("raka", "Retrofit error response     " + t.getMessage());
            }
        });
    }

    private void getImageResponse(List<VolleyImageResponse> response) {

        response.addAll(response);
        response.addAll(response);
        response.addAll(response);
        response.addAll(response);
        response.addAll(response);
        response.addAll(response);
        mList.addAll(response);

        RetrofitImageAdapter retrofitImageAdapter = new RetrofitImageAdapter(getActivity(), mList);
        mRecyclerView.setAdapter(retrofitImageAdapter);
        retrofitImageAdapter.notifyDataSetChanged();
    }
}

