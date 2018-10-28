package com.example.agamy.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SpreedSheetAdapter extends ArrayAdapter<SpreedSheetModel.ValueRange> {

    List<String> myTitles;
    List<String> myPics;

    public SpreedSheetAdapter(@NonNull Context context, @NonNull List<SpreedSheetModel.ValueRange> objects) {
        super(context, 0, objects);
        myTitles = objects.get(0).getValues().get(0);
        myPics = objects.get(1).getValues().get(0);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
         //super.getView(position, convertView, parent);

        // Get the data item for this position
        //SpreedSheetModel.ValueRange sheetModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.sheet_model_layout, parent, false);
        }
        // Lookup view for data population
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvRowTitle);
        ImageView ivPic = (ImageView) convertView.findViewById(R.id.ivRowImage);
        // Populate the data into the template view using the data object

        //sheetModel.valueRanges.get(0).values.get(0) text
        //sheetModel.valueRanges.get(1).values.get(0) img

        tvTitle.setText(myTitles.get(position));
        if(myPics.get(position).isEmpty())
        {
            ivPic.setImageResource(R.mipmap.ic_launcher);

        }else {
            Picasso.get().load(myPics.get(position)).placeholder(R.mipmap.ic_launcher).into(ivPic);
        }
        // Return the completed view to render on screen
        return convertView;

        //tvHome.setText(user.hometown);



    }

    @Override
    public int getCount() {
        return myPics.size();
    }


}
