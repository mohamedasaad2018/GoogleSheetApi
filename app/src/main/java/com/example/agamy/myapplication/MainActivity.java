package com.example.agamy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

public class MainActivity extends AppCompatActivity {

    ListView spreedSheetList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidNetworking.initialize(getApplicationContext());

        spreedSheetList = findViewById(R.id.spreedSheetList);
        //getData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getData();
    }

    private void getData() {

        String sheetUrl = "https://sheets.googleapis.com/v4/spreadsheets/1tZJ13FikGkuw_HmmTLhY9QOTyZ5DeJm6tXM7oVAYetE/values:batchGet?ranges=Sheet1!A:A&ranges=Sheet1!C:C&majorDimension=COLUMNS&key=AIzaSyATIgNaNipzppfuw-EPeYSIgZ1ysPZpUco";

        /*--------------Example Two -> Getting an user----------------*/
        AndroidNetworking.get(sheetUrl)
                .setTag(this)
                .setPriority(Priority.HIGH)
                .build()
                .getAsObject(SpreedSheetModel.class, new ParsedRequestListener<SpreedSheetModel>() {
                    @Override
                    public void onResponse(SpreedSheetModel sheetModel) {
                        // do anything with response
                        Log.d("", sheetModel.toString());
                        //sheetModel.valueRanges.get(0).values.get(0) text
                        //sheetModel.valueRanges.get(1).values.get(0) img
                        spreedSheetList.setAdapter(new SpreedSheetAdapter(getBaseContext(),sheetModel.getValueRanges()));
                    }

                    @Override
                    public void onError(ANError anError) {
                        // handle error
                        Log.d("", anError.getErrorBody().toString());
                    }
                });
        /*-- Note : YourObject.class, getAsObject and getAsObjectList are important here --*/
    }
}