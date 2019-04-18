package com.example.testviewmodellivedata.JSON_CONVERTER;

import android.util.Log;

import com.example.testviewmodellivedata.Model.ParcelModel;
import com.example.testviewmodellivedata.Model.RouteModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONToParcel {

    //CONVERT THE JSON TO POJO
    public static ArrayList<ParcelModel> getParcelData(String json){
        ArrayList<ParcelModel> parcelDataArrayList =new ArrayList<>();
        try {
            JSONArray obj= new JSONArray(json);
            for(int i=0; i<obj.length();i++){
                ParcelModel currParcelModel = null;
                JSONObject object = obj.getJSONObject(i);
                JSONObject object1 = object.getJSONObject("parcelData");
                if(object1!=null) {
                    String c_id = object1.getString("c_id");
                    String account = object1.getString("accountNum");
                    String district = object1.getString("district");
                    String billarea = object1.getString("billarea");
                    String type = object1.getString("type");
                    String house = object1.getString("house");
                    String street1 = object1.getString("street1");
                    String street2 = object1.getString("street2");
                    String city = object1.getString("city");
                    String state = object1.getString("state");
                    String zip = object1.getString("zip");
                    String lon = object1.getString("lon");
                    String lat = object1.getString("lat");


                    currParcelModel = new ParcelModel(i, c_id, account, district, billarea, type, house, street1, street2, city, zip, state, lat, lon, false);
                }

                JSONArray jsonArray = object.getJSONArray("routeData");
                if (jsonArray!=null) {
                    ArrayList<RouteModel> routeModelArrayList = new ArrayList<>();
                    for (int j = 0; j < jsonArray.length(); j++) {
                        JSONObject object2 = jsonArray.getJSONObject(j);
                        String c_id = object2.getString("c_id");
                        String account = object2.getString("accountNum");
                        String num = object2.getString("num");
                        String type = object2.getString("type");
                        String mon = object2.getString("mon");
                        String tue = object2.getString("tue");
                        String wed = object2.getString("wed");
                        String thu = object2.getString("thu");
                        String fri = object2.getString("fri");
                        String sat = object2.getString("sat");
                        String sun = object2.getString("sun");
                        String freq = object2.getString("freq");
                        String stopNextDate = object2.getString("stopNextDate");
                        routeModelArrayList.add(new RouteModel(c_id, account, num, type, mon, tue, wed, thu, fri, sat, sun, freq, stopNextDate));
                    }
                    currParcelModel.setRoutes(routeModelArrayList);
                }
                parcelDataArrayList.add(currParcelModel);
            }
        } catch (JSONException e) {
            Log.e("Wrong", e.toString());
        }
        return parcelDataArrayList;
    }
}
