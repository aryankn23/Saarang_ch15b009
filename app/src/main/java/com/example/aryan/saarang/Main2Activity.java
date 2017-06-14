package com.example.aryan.saarang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView listView =(ListView)findViewById(R.id.listViewevent);
        ArrayList<String>events=new ArrayList<>();
        Intent intent=getIntent();

        Pattern p = Pattern.compile("\"(.*?)\"");
        Matcher m = p.matcher(intent.getStringExtra("event"));

        while (m.find()) {


            events.add(m.group(1));





        }

        Log.i("events",intent.getStringExtra("event"));
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,events);
        listView.setAdapter(arrayAdapter);



    }
}
