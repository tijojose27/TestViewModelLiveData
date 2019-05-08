package com.example.testviewmodellivedata.ViewModel;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import com.example.testviewmodellivedata.Utils.JSONToParcel;
import com.example.testviewmodellivedata.Model.ParcelModel;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class ParcelViewModel extends AndroidViewModel {

    private AsyncDataLoader asyncDataLoader;
    private ArrayList<ParcelModel> parcelList;

    private MutableLiveData<List<ParcelModel>> parcelLiveData = new MutableLiveData<>();


    public MutableLiveData<List<ParcelModel>> getParcelLiveData(){
        if(parcelLiveData == null){
            String JSON = loadJSONFromAsset();
            asyncDataLoader = new AsyncDataLoader(JSON);
            asyncDataLoader.execute();
        }
        return parcelLiveData;
    }

    public void deleteParcel(ParcelModel parcelModel){
        if(parcelLiveData.getValue().contains(parcelModel)) {
            parcelLiveData.getValue().remove(parcelModel);
            Log.e("Progress", "Removed Parcel");
            Log.e("Progress", "SIZE IS NOW : "+parcelLiveData.getValue().size());
            parcelLiveData.setValue(parcelLiveData.getValue());
        }
    }

    public void updateParcel(ParcelModel parcelModel){
       if(parcelLiveData.getValue().contains(parcelModel)){
           int index = parcelLiveData.getValue().indexOf(parcelModel);
           parcelLiveData.getValue().get(index).setIs_selected();
           parcelLiveData.setValue(parcelLiveData.getValue());
       }
    }

    public ParcelViewModel(@NonNull Application application) {
        super(application);
        String JSON = loadJSONFromAsset();
        asyncDataLoader = new AsyncDataLoader(JSON);
        asyncDataLoader.execute();
    }


    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getApplication().getAssets().open("4014.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }



    public class AsyncDataLoader extends AsyncTask<Void, Integer, Void> {

        String JSON;
        AsyncDataLoader(String JSON) {
            this.JSON = JSON;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Log.e("PROGRESS", "STARTED");
            parcelList = JSONToParcel.getParcelData(JSON);
//            getParcelDetails();
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.e("Progress "," Progress : "+values+" %");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //TODO : THIS IS WHERE ITS CALLED
            parcelLiveData.setValue(parcelList);

            Log.e("Progress", "DONE");
            Log.e("Progress", "SIZE IS "+ parcelList.size());

            //ORDERED LIST
//            JsonList jsonFragment = new JsonList();
//            jsonFragment.setArguments(bundle);
//            ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.orderedList, jsonFragment);
//            ft.commit();

            //MAP FRAGMENT
//            OfflineMaps offlineMapsFragment = new OfflineMaps();
//            offlineMapsFragment.setArguments(bundle);
//            ftMap = getSupportFragmentManager().beginTransaction();
//            ftMap.replace(R.id.online_maps, offlineMapsFragment);
//            ftMap.commit();
        }
    }

}


