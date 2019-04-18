package com.example.testviewmodellivedata.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testviewmodellivedata.Model.ParcelModel;
import com.example.testviewmodellivedata.R;
import com.example.testviewmodellivedata.Utils.ParcelDiffUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ParcelListAdapter extends RecyclerView.Adapter<ParcelListAdapter.ParcelViewHolder>  {


//    ArrayList<ParcelModel> parcelDataList;
    private List<ParcelModel> parcelDataList= new ArrayList<>();


    @NonNull
    @Override
    public ParcelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.list_item, parent,false);

        return new ParcelViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ParcelViewHolder holder, int position) {

        ParcelModel parcelData = parcelDataList.get(position);

        String address = parcelData.getHouseNumber()+" "+parcelData.getStreet1()+"\n"+parcelData.getCity()+
                ", "+parcelData.getState()+" "+parcelData.getZip();

        holder.facilityTV.setText(address);

    }

    @Override
    public int getItemCount() {
        return parcelDataList ==null ? 0 : parcelDataList.size();
    }

    public void setParcels(List<ParcelModel> parcelModelList){
        this.parcelDataList = parcelModelList;
        notifyDataSetChanged();
    }

    public ParcelModel getParcelAt(int position){
        return parcelDataList.get(position);
    }


    class ParcelViewHolder extends RecyclerView.ViewHolder {

        TextView facilityTV;

        ParcelViewHolder(View itemView) {
            super(itemView);
            facilityTV = itemView.findViewById(R.id.recipient_name);
        }
    }
}
