package com.example.testviewmodellivedata.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testviewmodellivedata.Model.ParcelModel;
import com.example.testviewmodellivedata.Model.RouteModel;
import com.example.testviewmodellivedata.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ParcelDetailsAdapter extends RecyclerView.Adapter<ParcelDetailsAdapter.ParcelDetailsViewHolder> {

    private List<ParcelModel> parcelDataList = new ArrayList<>();

    @NonNull
    @Override
    public ParcelDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.detail_list_item, parent, false);
        return new ParcelDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ParcelDetailsViewHolder holder, int position) {
        ParcelModel parcelData = parcelDataList.get(position);

            String address = parcelData.getHouseNumber() + " " + parcelData.getStreet1() + "\n"+parcelData.getStreet2()+"\n" + parcelData.getCity() +
                    ", " + parcelData.getState() + " " + parcelData.getZip();

//            String accountInfo  = "Account No. : \n"+parcelData.getAccount()+"\nAccount Type : \n"+parcelData.getType()+"\nStatus : \nACTIVE";
            String accountInfo = parcelData.getAccount()+"\n\n"+parcelData.getType()+"\n\nACTIVE";

            StringBuilder routeData = new StringBuilder();
            ArrayList<RouteModel> routeModels = parcelData.getRoutes();
            for(RouteModel routeModel : routeModels){
                routeData.append("NUM : \n"+routeModel.getNum()+"\nFREQ : \n"+routeModel.getFreq()+"\nNEXT DATE :\n"+routeModel.getStopNextDate());
                routeData.append(" \n\n");
            }


            holder.routeInfoTV.setText(routeData.toString());
            holder.accountAddressTV.setText(address);
            holder.accountInfoTV.setText(accountInfo);
    }

    @Override
    public int getItemCount() {
        return parcelDataList ==null ? 0 : parcelDataList.size();
    }

    public void setParcels(List<ParcelModel> parcelModelList){
        this.parcelDataList = parcelModelList;
        formatParcelList();
        notifyDataSetChanged();
    }

    public void formatParcelList(){
        ArrayList<ParcelModel> parcelModels = new ArrayList<>();
        for(ParcelModel parcelModel: parcelDataList){
            if(parcelModel.getIs_selected()){
                parcelModels.add(parcelModel);
            }
        }
        this.parcelDataList = parcelModels;
    }

    public ParcelModel getParcelAt(int position){
        return parcelDataList.get(position);
    }

    class ParcelDetailsViewHolder extends RecyclerView.ViewHolder {

        TextView accountAddressTV;
        TextView accountInfoTV;
        TextView routeInfoTV;


        ParcelDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            accountAddressTV = itemView.findViewById(R.id.detail_list_recipient_details);
            accountInfoTV = itemView.findViewById(R.id.account_info_container);
            routeInfoTV = itemView.findViewById(R.id.detail_list_route_info);
        }
    }
}
