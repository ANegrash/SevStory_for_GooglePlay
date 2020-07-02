package com.me.nav.sssgp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    //initialize view's
    ListView simpleListView, simpleListView2;
    FloatingActionButton fab, fab2;
    String[] animalName={"Памятник Затопленным кораблям","Памятник Екатерине II",
            "Памятник Нахимову","Памятник Казарскому","35 батарея", "Памятник двухсотлетия города",
            "Бронепоезд 'Железняков'","Обелиск штык-парус","Графская пристань",
            "Памятник Матросу и Солдату"};//animal names array
    int[] animalImages={R.mipmap.m,R.mipmap.o,R.mipmap.r,R.mipmap.t,R.mipmap.p,R.mipmap.a,R.mipmap.g,R.mipmap.s,R.mipmap.q,R.mipmap.n};//animal images array
    String[] tourName={"Площадь Нахимова"};//animal names array
    int[] tourImages={R.drawable.qw};//animal images array

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleListView=(ListView)findViewById(R.id.simpleListView);
        simpleListView2=(ListView)findViewById(R.id.simpleListView3);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

        tabHost.setup();
        getSupportActionBar().hide();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tag1");

        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("Памятники");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag3");
        tabSpec.setContent(R.id.tab3);
        tabSpec.setIndicator("Туры");
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTab(0);

        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
        for (int i=0;i<animalName.length;i++)
        {
            HashMap<String,String> hashMap=new HashMap<>();//create a hashmap to store the data in key value pair
            hashMap.put("image",animalImages[i]+"");
            hashMap.put("name",animalName[i]);
            arrayList.add(hashMap);//add the hashmap into arrayList
        }
        String[] from={"image", "name"};//string array
        int[] to={R.id.imageView2,R.id.textView};//int array of views id's
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,arrayList,R.layout.list_view_items,from,to);
        simpleListView.setAdapter(simpleAdapter);//sets the adapter for listView

        //perform listView item click event
        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(animalName[i]=="Памятник Затопленным кораблям"){
                    Intent i1 = new Intent(MainActivity.this, PZK.class);
                    startActivity(i1);
                }else if(animalName[i]=="Памятник Екатерине II"){
                    Intent i2 = new Intent(MainActivity.this, Ekat.class);
                    startActivity(i2);
                }else if(animalName[i]=="Памятник Нахимову"){
                    Intent i3 = new Intent(MainActivity.this, Nakhim.class);
                    startActivity(i3);
                }else if(animalName[i]=="Памятник Казарскому"){
                    Intent i4 = new Intent(MainActivity.this, Kaz.class);
                    startActivity(i4);
                }else if(animalName[i]=="35 батарея"){
                    Intent i5 = new Intent(MainActivity.this, bat.class);
                    startActivity(i5);
                }else if(animalName[i]=="Памятник двухсотлетия города"){
                    Intent i6 = new Intent(MainActivity.this, dvuhsotletie.class);
                    startActivity(i6);
                }else if(animalName[i]=="Бронепоезд 'Железняков'"){
                    Intent i7 = new Intent(MainActivity.this, Zeleznyak.class);
                    startActivity(i7);
                }else if(animalName[i]=="Обелиск штык-парус"){
                    Intent i8 = new Intent(MainActivity.this, shtykparus.class);
                    startActivity(i8);
                }else if(animalName[i]=="Графская пристань"){
                    Intent i9 = new Intent(MainActivity.this, Grafsk.class);
                    startActivity(i9);
                }else if(animalName[i]=="Памятник Матросу и Солдату"){
                    Intent i10 = new Intent(MainActivity.this, matrosisoldat.class);
                    startActivity(i10);
                }
            }
        });

        ArrayList<HashMap<String,String>> arrayList2=new ArrayList<>();
        for (int i=0;i<tourName.length;i++)
        {
            HashMap<String,String> hashMap2=new HashMap<>();//create a hashmap to store the data in key value pair
            hashMap2.put("image",tourImages[i]+"");
            hashMap2.put("name",tourName[i]);
            arrayList2.add(hashMap2);//add the hashmap into arrayList
        }
        String[] from2={"image", "name"};//string array
        int[] to2={R.id.imageView2,R.id.textView2};//int array of views id's
        SimpleAdapter simpleAdapter2=new SimpleAdapter(this,arrayList2,R.layout.list_view_items2,from2,to2);
        simpleListView2.setAdapter(simpleAdapter2);//sets the adapter for listView

        //perform listView item click event
        simpleListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(tourName[i]=="Площадь Нахимова"){
                    Intent i1 = new Intent(MainActivity.this, Tour.class);
                    startActivity(i1);
                }
            }
        });
    }


}