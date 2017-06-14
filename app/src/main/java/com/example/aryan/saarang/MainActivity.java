package com.example.aryan.saarang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    String template="[{\"catagory\":\"choreo\",\"event\":[\"freestyle solo\",\"salsa workshop\",\"JustDuet\"]},{\"catagory\":\"comedy\",\"event\":[\"Whose Line is Any Way\"]},{\"catagory\":\"Design\",\"event\":[\"graphic Design Team\",\"Graphic Design Solo\"]},{\"catagory\":\"Fine Arts\",\"event\":[\"CornuCopia\",\"Fasest Fingers\"]},{\"catagory\":\"Food Fest\",\"event\":[\"Chef War\"]},{\"catagory\":\"GamePlex\",\"event\":[\"Dota\",\"Fifa\",\"GTA\"]}]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView =(ListView)findViewById(R.id.list_view);

        ArrayList<String>catagories =new ArrayList<String>();


        try {
            JSONArray jsonArray=new JSONArray(template);

            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObjectCatagories=jsonArray.getJSONObject(i);
                String catagory=jsonObjectCatagories.getString("catagory");
                Log.i("Catagory",catagory);
                catagories.add(catagory);
                String events=jsonObjectCatagories.getString("event");
                Pattern p = Pattern.compile("\"(.*?)\"");
                Matcher m = p.matcher(events);

                while (m.find()) {
                    ArrayList<String>event=new ArrayList<String>();

                    System.out.println(m.group(1));



                }







            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,catagories);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent =new Intent(getApplicationContext(),Main2Activity.class);


                    ArrayList<String>arrayList=new ArrayList<String>();
                try {
                    JSONArray jsonArray=new JSONArray(template);

                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObjectCatagories=jsonArray.getJSONObject(i);
                        String catagory=jsonObjectCatagories.getString("catagory");
                        Log.i("Catagory",catagory);

                        String events=jsonObjectCatagories.getString("event");
                        arrayList.add(events);










                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                intent.putExtra("event",arrayList.get(position));
                startActivity(intent);




            }
        });




    }
}
