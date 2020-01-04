package com.example.th_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class FurnitureAdapterGrid extends ArrayAdapter<Categories> {
    public FurnitureAdapterGrid(@NonNull Context context, @NonNull ArrayList<Categories> objects) {
        super(context, 0, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Categories categories = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_item__grid, parent, false);
        }
        TextView name = convertView.findViewById(R.id.name);
        ImageView imgFlag = convertView.findViewById(R.id.image);

        name.setText(categories.name);
        imgFlag.setImageBitmap(Categories.convertStringToBitmapFromAccess(getContext(),categories.image));

        return convertView;
    }
}
