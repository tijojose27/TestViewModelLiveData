package com.example.testviewmodellivedata.ParcelListRecycler;


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
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.testviewmodellivedata.Model.ParcelModel;
import com.example.testviewmodellivedata.R;
import com.example.testviewmodellivedata.RecyclerView.ParcelListAdapter;
import com.example.testviewmodellivedata.ViewModel.ParcelViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class ParcelListFragment extends Fragment {

    public ParcelViewModel parcelViewModel;

    private RecyclerView listRecyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private LinearLayout buttonLayout;

    private ArrayList<ParcelModel> parcelList;

    public ParcelListFragment() {
        // Required empty public constructor
        parcelList = new ArrayList<>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.parcel_list, container, false);

        listRecyclerView = view.findViewById(R.id.listRecyclerView);
        buttonLayout = view.findViewById(R.id.buttonPanel);
        buttonLayout.setVisibility(View.VISIBLE);

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        listRecyclerView.setLayoutManager(layoutManager);
        final ParcelListAdapter adapter = new ParcelListAdapter();
        listRecyclerView.setAdapter(adapter);
        listRecyclerView.setLayoutManager(layoutManager);

//        runLayoutAnimation(listRecyclerView);
        parcelViewModel = ViewModelProviders.of(getActivity()).get(ParcelViewModel.class);
        parcelViewModel.getParcelLiveData().observe(getViewLifecycleOwner(), new Observer<List<ParcelModel>>() {
            @Override
            public void onChanged(List<ParcelModel> parcelModels) {
                adapter.setParcels(parcelModels);
//                runLayoutAnimation(listRecyclerView);
            }
        });

//        FrameLayout.LayoutParams frameLayout = new FrameLayout.LayoutParams(
//                FrameLayout.LayoutParams.MATCH_PARENT,
//                FrameLayout.LayoutParams.MATCH_PARENT
//        );
//        frameLayout.setMargins(4,0,4,0);
//
//        FloatingActionButton fab = new FloatingActionButton(getContext());
//        fab.setImageResource(R.drawable.ic_add_black_24dp);
//        fab.setLayoutParams(frameLayout);
//
//
//        FloatingActionButton fab1 = new FloatingActionButton(getContext());
//        fab1.setImageResource(R.drawable.ic_add_black_24dp);
//        fab1.setLayoutParams(frameLayout);
//
//
//        FloatingActionButton fab2 = new FloatingActionButton(getContext());
//        fab2.setImageResource(R.drawable.ic_add_black_24dp);
//        fab2.setLayoutParams(frameLayout);
//
//        FloatingActionButton fab3 = new FloatingActionButton(getContext());
//        fab3.setImageResource(R.drawable.ic_add_black_24dp);
//        fab3.setLayoutParams(frameLayout);
//
//        FloatingActionButton fab4 = new FloatingActionButton(getContext());
//        fab4.setImageResource(R.drawable.ic_add_black_24dp);
//        fab4.setLayoutParams(frameLayout);


//        buttonLayout.addView(fab);
//        buttonLayout.addView(fab1);
//        buttonLayout.addView(fab3);
//        buttonLayout.addView(fab4);
//        buttonLayout.addView(fab4);
//        buttonLayout.addView(fab1);



        //IF YOU WANT SWIPE GESTURES HERE

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                if(direction==ItemTouchHelper.LEFT) {
                    parcelViewModel.deleteParcel(adapter.getParcelAt(viewHolder.getAdapterPosition()));
                    Toast.makeText(getActivity(), "DELETED", Toast.LENGTH_LONG).show();
                    Log.e("FROM PARCEL list", "REMOVED PARCEL LIST");
                }else{
                    parcelViewModel.updateParcel(adapter.getParcelAt(viewHolder.getAdapterPosition()));
                    Toast.makeText(getActivity(), "UPDATED", Toast.LENGTH_LONG).show();
                }
//                runLayoutAnimation(listRecyclerView);
            }


        }).attachToRecyclerView(listRecyclerView);

    }

//    private void runLayoutAnimation(RecyclerView recyclerView) {
//        Context context = recyclerView.getContext();
//        LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_drop_down);
//        recyclerView.setLayoutAnimation(controller);
//        recyclerView.getAdapter().notifyDataSetChanged();
//        recyclerView.scheduleLayoutAnimation();
//    }

}
