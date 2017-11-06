package edu.greenriver.it.visualdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.greenriver.it.visualdata.model.Car;
import edu.greenriver.it.visualdata.view_model.CarViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            String testData = "{ \"results\": [{\"make\": \"Honda\",\"model\" : \"Accord\",\"year\" : 1999,\"color\" : \"#3E4D5F\",\"current_owner\" : { \"name\" : \"Corey\"},\"owner_history\" : [{\"name\" : \"Corey\"},{\"name\" : \"Jeff\"}]},{\"make\": \"Subaru\",\"model\" : \"Forester\",\"year\" : 2013,\"color\" : \"#010080\",\"current_owner\" : { \"name\" : \"Soni\"},\"owner_history\" : [{\"name\" : \"Soni\"}]},{\"make\": \"Toyota\",\"model\" : \"Corrola\",\"year\" : 1984,\"color\" : \"#CECECE\",\"current_owner\" : {\"name\" : \"Nate\"},\"owner_history\" : [{\"name\" : \"Nate\"},{\"name\" : \"Nathan\"}]}]}";
            String starWarsData = "{\"name\": \"Luke Skywalker\",\"height\": \"172\",\"mass\": \"77\",\"hair_color\": \"blond\",+\"skin_color\": \"fair\",\"eye_color\": \"blue\",\"birth_year\": \"19BBY\",\"gender\": \"male\",\"homeworld\": \"https://swapi.co/api/planets/1/\",\"films\": [\"https://swapi.co/api/films/2/\",\"https://swapi.co/api/films/6/\",\"https://swapi.co/api/films/3/\",\"https://swapi.co/api/films/1/\",\"https://swapi.co/api/films/7/\"],\"species\": [\"https://swapi.co/api/species/1/\"],\"vehicles\": [\"https://swapi.co/api/vehicles/14/\",\"https://swapi.co/api/vehicles/30/\"],\"starships\": [\"https://swapi.co/api/starships/12/\",\"https://swapi.co/api/starships/22/\"],\"created\": \"2014-12-09T13:50:51.644000Z\",\"edited\": \"2014-12-20T21:17:56.891000Z\",\"url\": \"https://swapi.co/api/people/1/\"} {\"name\": \"Greedo\",\"height\": \"173\",\"mass\": \"74\",\"hair_color\": \"n/a\",\"skin_color\": \"green\",\"eye_color\": \"black\",\"birth_year\": \"44BBY\",\"gender\": \"male\",\"homeworld\": \"https://swapi.co/api/planets/23/\",\"films\": [\"https://swapi.co/api/films/1/\"],\"species\": [\"https://swapi.co/api/species/4/\"],\"vehicles\": [],\"starships\": [],\"created\": \"2014-12-10T17:03:30.334000Z\",\"edited\": \"2014-12-20T21:17:50.336000Z\",\"url\": \"https://swapi.co/api/people/15/\"}";

            JSONObject testObject = new JSONObject(testData);
            Log.i("Test", testObject.toString());

            JSONArray results = testObject.getJSONArray("results");
            Log.i("Test", results.length() + "");

            Car testCar = new Car(results.getJSONObject(0));
            CarViewModel carView = new CarViewModel(testCar);

            TextView textView = (TextView) findViewById(R.id.ownerDetails);
            textView.setText(carView.getOwnerAndYear());


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
