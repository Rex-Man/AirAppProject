package com.manre.airappproject.fragment.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manre.airappproject.R;
import com.manre.airappproject.fragment.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTabOneWayFragment extends BaseFragment {


    public HomeTabOneWayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_tab_one_way, container, false);
    }

}
