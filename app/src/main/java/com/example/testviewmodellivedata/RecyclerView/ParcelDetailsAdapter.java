package com.example.testviewmodellivedata.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.testviewmodellivedata.Model.ParcelModel;
import com.example.testviewmodellivedata.Model.RouteModel;
import com.example.testviewmodellivedata.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ParcelDetailsAdapter extends RecyclerView.Adapter<ParcelDetailsAdapter.ParcelDetailsViewHolder> {

    private List<ParcelModel> parcelDataList = new ArrayList<>();

    public Context context;

    @NonNull
    @Override
    public ParcelDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        //TODO: TRY DIFFERENT LAYOUTS
//        View view = inflater.inflate(R.layout.detail_list_item, parent, false);
//        View view = inflater.inflate(R.layout.detail_list_item1, parent, false);
        View view = inflater.inflate(R.layout.final_test_layout, parent, false);
        return new ParcelDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ParcelDetailsViewHolder holder, int position) {
        ParcelModel parcelData = parcelDataList.get(position);

            String address = parcelData.getHouseNumber() + " " + parcelData.getStreet1() + "\n"+parcelData.getStreet2()+"\n" + parcelData.getCity() +
                    ",\n " + parcelData.getState() + " " + parcelData.getZip();

            holder.accountAddressTV.setText(address);

            String accountInfo = parcelData.getAccount()+"\t\t"+parcelData.getType()+"\t\tACTIVE";

            holder.accountInfoTV.setText(accountInfo);

//            holder.routeInfoLL.removeAllViews();

            ArrayList<RouteModel> routeModels = parcelData.getRoutes();
            for(RouteModel routeModel : routeModels){
                String route = "NUM : \t"+routeModel.getNum()+"\t   FREQ : \t"+routeModel.getFreq()+"\tNEXT DATE :\t"+routeModel.getStopNextDate()+"\n";
                TextView routeTV = new TextView(context);
                routeTV.setText(route);
                routeTV.setTextSize(20);
                routeTV.setTypeface(null, Typeface.BOLD);
//                holder.routeInfoLL.addView(routeTV);
            }
//            holder.expandedLayout.setVisibility(View.GONE);


//        final AnimatorSet animatorSet = new AnimatorSet();
//
//        ObjectAnimator fadeout = ObjectAnimator.ofFloat(holder.photoButton, View.ALPHA, 0.9f, 0.1f );
//        fadeout.setDuration(750);
//
//        ObjectAnimator fadein = ObjectAnimator.ofFloat(holder.photoButton, View.ALPHA, 0.9f, 0.1f );
//        fadein.setDuration(750);
//
//        animatorSet.play(fadein).after(fadeout);
//        animatorSet.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                super.onAnimationEnd(animation);
//                animatorSet.start();
//            }
//        });
//
//        animatorSet.start();
//
//        holder.expandButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(holder.expandedLayout.getVisibility()==View.VISIBLE){
//                    holder.expandedLayout.setVisibility(View.GONE);
//                }else {
//                    holder.expandedLayout.setVisibility(View.VISIBLE);
//                }
//
//            }
//        });

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
//
        TextView accountAddressTV, accountInfoTV, miscNotesTV, accountNotesTV;
//        LinearLayout routeInfoLL, expandedLayout;
//        MaterialButton photoButton, expandButton;


        ParcelDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            accountAddressTV = itemView.findViewById(R.id.detail_list_recipient_details);
            accountInfoTV = itemView.findViewById(R.id.account_info_container);
//            routeInfoLL = itemView.findViewById(R.id.detail_list_route);
//            miscNotesTV = itemView.findViewById(R.id.misc_notes);
//            accountNotesTV = itemView.findViewById(R.id.account_notes);
//            photoButton = itemView.findViewById(R.id.photo_button);
//            expandButton = itemView.findViewById(R.id.expand_actions);
//            expandedLayout = itemView.findViewById(R.id.expanded_actions_layout);
        }
    }
}
