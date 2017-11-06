package edu.greenriver.it.visualdata.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ebenn on 11/2/2017.
 */

public class Car {
    //Data Fields
    public String make;
    public String model;
    public int year;
    public String carColor;
    public Owner currentOwner;
    public List<Owner> ownerHistory;


    //Constructor that takes in a json object
    public Car(JSONObject jsonObject) {
        try {
            make = jsonObject.getString("make");
            model = jsonObject.getString("model");
            year = jsonObject.getInt("year");
            carColor = jsonObject.getString("color");
            currentOwner = new Owner((jsonObject.getJSONObject("current_owner")));
            ownerHistory = new LinkedList<>();
            JSONArray ownerJsonArray = jsonObject.getJSONArray("owner_history");

            for(int i = 0; i < ownerJsonArray.length(); i++) {
                ownerHistory.add(new Owner(ownerJsonArray.getJSONObject(i)));
            }

        } catch (Exception e) {
            Log.e("Model", "Could not make a car: " + e.getMessage());
        }
    }
}
