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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.rakesh.allnetworktestprojectimagedownloand.R;
import com.example.rakesh.allnetworktestprojectimagedownloand.adapter.VolleyImageAdapter;
import com.example.rakesh.allnetworktestprojectimagedownloand.dto.volley.dto.ResponseTypeIsArrayList;
import com.example.rakesh.allnetworktestprojectimagedownloand.dto.volley.dto.VolleyImageResponse;
import com.example.rakesh.allnetworktestprojectimagedownloand.volleymanager.DownloadManager;
import com.example.rakesh.allnetworktestprojectimagedownloand.utils.Utils;

import java.util.ArrayList;


public class VolleyGsaonImageDownloadFragment extends Fragment {

    private ProgressDialog mProgressDialog;
    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;
    private ArrayList<VolleyImageResponse> mList;


    private static final String LIST_KEY = "list";

    public VolleyGsaonImageDownloadFragment() {
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
        mProgressBar = (ProgressBar) view.findViewById(R.id.progressbar);
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


            VolleyImageAdapter imageRecyclerViewAdapter = new VolleyImageAdapter(getActivity(), mList);
            mRecyclerView.setAdapter(imageRecyclerViewAdapter);
            imageRecyclerViewAdapter.notifyDataSetChanged();
        }
    }


    private void downloadImage() {
        mList = new ArrayList<>();

        mProgressBar.setVisibility(View.VISIBLE);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);


        DownloadManager.downloadData(getActivity().getApplication(),
                getResources().getString(R.string.image_download_api),
                new Response.Listener<ResponseTypeIsArrayList>() {
                    @Override
                    public void onResponse(ResponseTypeIsArrayList response) {
                        //  mProgressBar.setVisibility(View.GONE);
                        if (getActivity() == null)
                            return;

                        getImageResponse(response);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.e("raka", "Volley error response equal    " + error);
                    }
                });

    }

    private void getImageResponse(ResponseTypeIsArrayList response) {

        response.addAll(response);
        response.addAll(response);
        response.addAll(response);
        response.addAll(response);
        response.addAll(response);
        response.addAll(response);

        Log.d("raka", "response list size  ok      " + response.size());

        mList.addAll(response);

        // we can use below given anyone  volleyImageAdapter instance ( mlist   or   response)

      /*  VolleyImageAdapter volleyImageAdapter = new VolleyImageAdapter(getActivity(), response);

                                        or

        VolleyImageAdapter volleyImageAdapter = new VolleyImageAdapter(getActivity(), mList);*/


        VolleyImageAdapter volleyImageAdapter = new VolleyImageAdapter(getActivity(), mList);


        mRecyclerView.setAdapter(volleyImageAdapter);
        volleyImageAdapter.notifyDataSetChanged();
    }


}

