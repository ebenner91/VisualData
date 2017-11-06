package edu.greenriver.it.visualdata.model;

import android.util.Log;

import org.json.JSONObject;

/**
 * Created by ebenn on 11/2/2017.
 */

public class Owner {
    public String name;

    public Owner(JSONObject jsonObject) {
        //Try/catch
        //Get the name from the json object and store it in the field
        //Catch any errors and log them

        try {
            name= jsonObject.getString("name");

        }catch (Exception e) {
            Log.e("Model", "This went wrong: " + e.getMessage());
        }
    }
}
