package com.example.rakesh.allnetworktestprojectimagedownloand.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.rakesh.allnetworktestprojectimagedownloand.UI.RetrofitImageDownloadFragment;
import com.example.rakesh.allnetworktestprojectimagedownloand.UI.VolleyGsaonImageDownloadFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private int mNumOfTabs;

    public ViewPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:

                VolleyGsaonImageDownloadFragment volleyGsaonImageDownloadFragment = new VolleyGsaonImageDownloadFragment();
                return volleyGsaonImageDownloadFragment;

            case 1:
                RetrofitImageDownloadFragment retrofitImageDownloadFragment = new RetrofitImageDownloadFragment();
                return retrofitImageDownloadFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}





