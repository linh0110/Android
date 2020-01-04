package com.example.th_android;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    ListView listView;
    ArrayList<Furniture> arrayList;
    FurnitureAdapter furnitureAdapter;
    Utils utils;
    DBHelper dbHelper;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        utils=new Utils(getContext());
       // dbHelper= new DBHelper(getContext());
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    @Override
    public  void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view,savedInstanceState);
        listView=view.findViewById(R.id.listView);
        arrayList=utils.getMockData();
        //arrayList = dbHelper.getALLFurniture();
        furnitureAdapter = new FurnitureAdapter(getContext(),arrayList);
        listView.setAdapter(furnitureAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Utils.furnitureHistory.add(arrayList.get(i));
                Toast.makeText(getContext(),i+"",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),DetailActivity.class);
                //intent.putExtra("furniture",arrayList.get(i));
                intent.putExtra("name",arrayList.get(i).name);
                intent.putExtra("des",arrayList.get(i).description);
                intent.putExtra("image",arrayList.get(i).image);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onPause(){
        super.onPause();
        utils.WriteToFileInternal(arrayList);
    }
}
