package com.me.nav.sssgp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class NewTour extends AppCompatActivity {
    ListView simpleListView;
    FloatingActionButton fab4;
    String[] pamName={"Памятник Затопленным кораблям","Памятник Екатерине II",
            "Памятник Нахимову","Памятник Казарскому","35 батарея", "Памятник двухсотлетия города",
            "Бронепоезд 'Железняков'","Обелиск штык-парус","Графская пристань",
            "Памятник Матросу и Солдату"};//animal names array
    int[] pamImages={R.mipmap.m,R.mipmap.o,R.mipmap.r,R.mipmap.t,R.mipmap.p,R.mipmap.a,R.mipmap.g,R.mipmap.s,R.mipmap.q,R.mipmap.n};//animal images array

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_tour);

        simpleListView=(ListView)findViewById(R.id.listView3);
        fab4=(FloatingActionButton) findViewById(R.id.view3);

        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
        for (int i=0;i<pamName.length;i++)
        {
            HashMap<String,String> hashMap=new HashMap<>();//create a hashmap to store the data in key value pair
            hashMap.put("image",pamImages[i]+"");
            hashMap.put("name",pamName[i]);
            arrayList.add(hashMap);//add the hashmap into arrayList
        }
        String[] from={"image", "name"};//string array
        int[] to={R.id.imageView3,R.id.textView3};//int array of views id's
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,arrayList,R.layout.list_view_items3,from,to);
        simpleListView.setAdapter(simpleAdapter);//sets the adapter for listView

        //perform listView item click event


        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Сохраняем...", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}

