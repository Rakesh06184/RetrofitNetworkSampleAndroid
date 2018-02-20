package com.example.rakesh.allnetworktestprojectimagedownloand.volleymanager;

/**
 * Created by rakesh on 15/12/15.
 */

import android.app.Application;

import com.android.volley.Response;
import com.example.rakesh.allnetworktestprojectimagedownloand.dto.volley.dto.ResponseTypeIsArrayList;
import com.example.rakesh.allnetworktestprojectimagedownloand.Volleynetwork.GsonRequest;
import com.example.rakesh.allnetworktestprojectimagedownloand.Volleynetwork.VolleyHelper;

public class DownloadManager {

    public static void downloadData(Application application, String url, Response.Listener<ResponseTypeIsArrayList> listener, Response.ErrorListener errorListener) {
        GsonRequest<ResponseTypeIsArrayList> request = new GsonRequest<>(url, ResponseTypeIsArrayList.class, listener, errorListener);
        VolleyHelper.getInstance(application).addToRequestQueue(request);
    }
}
