package com.example.testviewmodellivedata.Utils;

import com.example.testviewmodellivedata.Model.ParcelModel;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.DiffUtil;

public class ParcelDiffUtil extends DiffUtil.Callback {

    List<ParcelModel> newList;
    List<ParcelModel> oldList;

    public ParcelDiffUtil(List<ParcelModel> newList, List<ParcelModel> oldList) {
        this.newList = newList;
        this.oldList = oldList;
    }

    @Override
    public int getOldListSize() {
        return oldList!=null ? oldList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return newList != null ? newList.size() :0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return newList.get(newItemPosition).getC_id().equals(oldList.get(oldItemPosition).getCity());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        int result = newList.get(newItemPosition).compareTo(oldList.get(oldItemPosition));
        return result ==0;
    }
}
