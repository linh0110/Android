package com.example.th_android;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

public class Furniture implements Serializable {
            String name;
            String description;
            String image;
            int idCategory;
            int id;
            Categories idcate;

    public Furniture(String name, String description, String image, Categories idcate, int id) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.id = id;
        this.idcate = idcate;
    }

    public Categories getIdcate() {
        return idcate;
    }

    public void setIdcate(Categories idcate) {
        this.idcate = idcate;
    }

    public Furniture(String name, String description, String image, int idCategory, int id) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.idCategory = idCategory;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public Furniture(String name, String description, String image) {
            this.name = name;
            this.description = description;
            this.image = image;
        }

    public String getName() {
            return name;
        }

            public void setName(String name) {
            this.name = name;
        }

            public String getDescription() {
            return description;
        }

            public void setDescription(String description) {
            this.description = description;
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
