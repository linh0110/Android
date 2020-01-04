package com.example.th_android;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;

//danh muc san pham
public class Categories  {
    String name;
    ArrayList<Furniture> arrayList;
    String image;
    int id;

    public Categories(String name, String image, int id) {
        this.name = name;
        this.image = image;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categories(String name, ArrayList<Furniture> arrayList, String bitmap) {
        this.name = name;
        this.arrayList = arrayList;
        this.image = bitmap;
    }
    public Categories(String name,  String bitmap) {
        this.name = name;

        this.image = bitmap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Furniture> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Furniture> arrayList) {
        this.arrayList = arrayList;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public static Bitmap convertStringToBitmapFromAccess(Context context, String filename)
    {
        AssetManager assetManager = context.getAssets();
        try{
            InputStream is = assetManager.open(filename);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            return bitmap;
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
