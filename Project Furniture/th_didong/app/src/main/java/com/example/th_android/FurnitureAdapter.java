package com.example.th_android;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import android.graphics.Bitmap;

public class FurnitureAdapter extends ArrayAdapter<Furniture> {

    public FurnitureAdapter(@NonNull Context context, @NonNull ArrayList<Furniture> objects) {
        super(context, 0, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Furniture furniture = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_item__menu, parent, false);
        }
        TextView tvName = convertView.findViewById(R.id.name);
        TextView tvHome = convertView.findViewById(R.id.description);
        ImageView imgFlag = convertView.findViewById(R.id.image);

        tvName.setText(furniture.name);
        tvHome.setText(furniture.description);

        imgFlag.setImageBitmap(Furniture.convertStringToBitmapFromAccess(getContext(),furniture.image));

        return convertView;
    }

}
