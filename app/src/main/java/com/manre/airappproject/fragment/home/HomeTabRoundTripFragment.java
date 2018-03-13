package com.manre.airappproject.fragment.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manre.airappproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTabRoundTripFragment extends Fragment {


    public HomeTabRoundTripFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_tab_round_trip, container, false);
    }

}
