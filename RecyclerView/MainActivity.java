package com.example.hasibuzzaman.myrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> myDatas = new ArrayList();

        myDatas.add("Hasibuzzaman"); myDatas.add("Shakibuzzaman");
        myDatas.add("Shakiluzzaman");myDatas.add("Maruf Hossain");
        myDatas.add("Shakhawat Hossain"); myDatas.add("Simor Alam");
        myDatas.add("Malik Khan");
        myDatas.add("Hasibuzzaman"); myDatas.add("Shakibuzzaman");
        myDatas.add("Shakiluzzaman");myDatas.add("Maruf Hossain");
        myDatas.add("Shakhawat Hossain"); myDatas.add("Simor Alam");
        myDatas.add("Malik Khan");
        myDatas.add("Hasibuzzaman"); myDatas.add("Shakibuzzaman");
        myDatas.add("Shakiluzzaman");myDatas.add("Maruf Hossain");
        myDatas.add("Shakhawat Hossain"); myDatas.add("Simor Alam");
        myDatas.add("Malik Khan");
        myDatas.add("Hasibuzzaman"); myDatas.add("Shakibuzzaman");
        myDatas.add("Shakiluzzaman");myDatas.add("Maruf Hossain");
        myDatas.add("Shakhawat Hossain"); myDatas.add("Simor Alam");
        myDatas.add("Malik Khan");

        for(String s:myDatas)
        {
            Log.e("s",s);
        }

        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(this,myDatas);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itemArrayAdapter);

    }
}
