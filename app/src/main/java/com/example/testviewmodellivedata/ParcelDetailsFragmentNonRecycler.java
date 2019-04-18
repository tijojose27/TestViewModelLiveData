package com.example.testviewmodellivedata;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ParcelDetailsFragmentNonRecycler extends Fragment {

    TextView accountAddressTV;
    TextView accountInfoTV;
    TextView routeInfoTV;


    public ParcelDetailsFragmentNonRecycler() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.parcel_list, container, false);

        accountAddressTV = view.findViewById(R.id.detail_list_recipient_details);


        return view;
    }

}
