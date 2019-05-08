package com.example.testviewmodellivedata.ParcelDetailsRecycler;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.testviewmodellivedata.Model.ParcelModel;
import com.example.testviewmodellivedata.R;
import com.example.testviewmodellivedata.RecyclerView.ParcelDetailsAdapter;
import com.example.testviewmodellivedata.ViewModel.ParcelViewModel;

import java.util.ArrayList;
import java.util.List;

public class ParcelDetailsFragment extends Fragment {

    private ParcelViewModel parcelViewModel;

    private RecyclerView listDetailsRecyclerView;
    private RecyclerView.LayoutManager layoutManager;


    public ParcelDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.parcel_list, container, false);
        listDetailsRecyclerView = view.findViewById(R.id.listRecyclerView);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        listDetailsRecyclerView.setLayoutManager(layoutManager);
        final ParcelDetailsAdapter adapter = new ParcelDetailsAdapter();
        listDetailsRecyclerView.setAdapter(adapter);
        listDetailsRecyclerView.setLayoutManager(layoutManager);

        runLayoutAnimation(listDetailsRecyclerView);
        parcelViewModel = ViewModelProviders.of(getActivity()).get(ParcelViewModel.class);
        parcelViewModel.getParcelLiveData().observe(getViewLifecycleOwner(), new Observer<List<ParcelModel>>() {
            @Override
            public void onChanged(List<ParcelModel> parcelModels) {
                adapter.setParcels(parcelModels);
                runLayoutAnimation(listDetailsRecyclerView);
                Log.e("FROM PARCEL DETAILS", "Updated");
            }
        });

//        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
//            @Override
//            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
//                return false;
//            }
//
//            @Override
//            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//
//                parcelViewModel.deleteParcel(adapter.getParcelAt(viewHolder.getAdapterPosition()));
//                runLayoutAnimation(listDetailsRecyclerView);
//            }
//        }).attachToRecyclerView(listDetailsRecyclerView);
    }

    private void runLayoutAnimation(RecyclerView recyclerView) {
        Context context = recyclerView.getContext();
        LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_drop_down);
        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }

}
