package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test extends AppCompatActivity implements AdapterView.OnItemClickListener,AbsListView.OnScrollListener{

    ListView lv;
    Button bt1,bt2;
    ArrayAdapter arr;
    SimpleAdapter simp;
    String[] data;
    List<Map<String,Object>> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        lv=(ListView)findViewById(R.id.test_lv);
        bt1=(Button)findViewById(R.id.test_bt1);
        bt2=(Button)findViewById(R.id.test_bt2);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrAdapter();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpAdapter();
            }
        });
    }
    public void arrAdapter(){
        data=new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
        arr=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,data);
        lv.setAdapter(arr);
    }
    public List<Map<String,Object>> getData(){
        for(int i=0;i<20;i++){
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("kshon1",R.id.simp_tv1);
            map.put("kshon2",R.id.simp_tv2);
            dataList.add(map);
        }
        return dataList;
    }
    public void simpAdapter(){
        simp=new SimpleAdapter(this,getData(),R.layout.simple_adapter,
                new String[]{"kshon1","kshon2"},new int[]{R.id.simp_tv1,R.id.simp_tv2});
        lv.setAdapter(simp);
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {

    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
