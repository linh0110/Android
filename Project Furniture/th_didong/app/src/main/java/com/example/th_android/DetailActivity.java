package com.example.th_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    ImageView hinh;
    TextView name,des;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        hinh=findViewById(R.id.image);
        name=findViewById(R.id.name);
        des=findViewById(R.id.chitiet);

//        getSupportActionBar().setTitle( name.setText(getIntent().getStringExtra( "name" )));
        Intent intent=getIntent();
       //image.setImageBitmap(convertStringToBitmapFromAccess(intent.getStringExtra("image")));
        name.setText(intent.getStringExtra("name"));

        des.setText(intent.getStringExtra("des"));
       //Bitmap bmp = (Bitmap)this.getIntent().getParcelableExtra("image");
       hinh.setImageBitmap(convertStringToBitmapFromAccess(getBaseContext(),intent.getStringExtra("image")));

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
