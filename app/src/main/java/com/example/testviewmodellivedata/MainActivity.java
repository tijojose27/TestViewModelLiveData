package com.example.testviewmodellivedata;

import android.os.Bundle;

import com.example.testviewmodellivedata.Model.ParcelModel;
import com.example.testviewmodellivedata.ParcelDetailsRecycler.ParcelDetailsFragment;
import com.example.testviewmodellivedata.ParcelListRecycler.ParcelListFragment;
import com.example.testviewmodellivedata.ViewModel.ParcelViewModel;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    public ParcelViewModel parcelViewModel;
    public ArrayList<ParcelModel> currParcelModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        ParcelListFragment parcelListFragment = new ParcelListFragment();
        fragmentTransaction.replace(R.id.list_fragment, parcelListFragment);

        ParcelDetailsFragment parcelDetailsFragment = new ParcelDetailsFragment();
        fragmentTransaction.replace(R.id.detail_fragment, parcelDetailsFragment);

        fragmentTransaction.commit();




//        parcelViewModel = ViewModelProviders.of(this).get(ParcelViewModel.class);
//
//        parcelViewModel.getParcelLiveData().observe(this, new Observer<List<ParcelModel>>() {
//            @Override
//            public void onChanged(List<ParcelModel> parcelModels) {
//                currParcelModels = new ArrayList(parcelModels);
//                for(ParcelModel parcelModel : currParcelModels){
//                }
//            }
//        });


    }
}
