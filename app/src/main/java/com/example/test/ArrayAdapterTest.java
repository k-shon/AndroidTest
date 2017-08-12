package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayAdapterTest extends AppCompatActivity implements AdapterView.OnItemClickListener,AbsListView.OnScrollListener {

    ListView lv;

    ArrayAdapter<String> arr_adapter;
    SimpleAdapter simp_adapter;
    String[] data;
    List<Map<String,Object>>dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter_test);

        lv=(ListView)findViewById(R.id.lv);
        data=new String[]{"慕课网1","慕课网2","慕课网3","慕课网4","慕课网5","慕课网6","慕课网7","慕课网8","慕课网9"};
        dataList=new ArrayList<Map<String, Object>>();
        Button array_bt=(Button)findViewById(R.id.array_bt);
        Button simp_bt=(Button)findViewById(R.id.simp_bt);
        array_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arr_adapter();
            }
        });
        simp_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simp_adapter();
            }
        });
        lv.setOnItemClickListener(this);
        lv.setOnScrollListener(this);
    }
    public void arr_adapter(){

        //第一个参数：上下文
        // 第二个：当前listview加载的每一个列表项所对应的布局文件
        //第三个：对应的数据源
        arr_adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,data);
        lv.setAdapter(arr_adapter);
    }
    public void simp_adapter(){
        /**参数1：上下文context
         * 参数2：data数据源——map组成的list集合
                  每个map都会对应listview列表中的一行
                  每个map的键值对中的键都必须包含所有第四个参数（from）中指定的键
         * 参数3：列表项的布局文件ID
         * 参数4：from 指定map中的键名
         * 参数5：to 绑定数据视图中的ID，与from成对应关系
        */
        //simp_adapter=new SimpleAdapter(this,getData(),R.layout.activity_array_adapter_test,new String[]{"image","textTV"},new int[]{R.id.iv,R.id.testTV});
        lv.setAdapter(simp_adapter);
    }
    public List<Map<String,Object>> getData(){
        for(int i=0;i<20;i++){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("image",R.mipmap.ic_launcher);
            map.put("textTV","慕课网"+i);
            dataList.add(map);
        }
        return dataList;
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i){
            case SCROLL_STATE_FLING:
                Toast.makeText(this,"用户在手指离开屏幕之前\n由于用力划了一下\n视图能依靠惯性继续滑动",Toast.LENGTH_SHORT);
                Log.i("scroll","用户在手指离开屏幕之前,由于用力划了一下,视图能依靠惯性继续滑动");
                Map<String,Object> map=new HashMap<String,Object>();
                map.put("image",R.mipmap.ic_launcher_round);
                map.put("textTV","增加项1");
                dataList.add(map);
                simp_adapter.notifyDataSetChanged();   //动态更新UI视图的数据
                break;
            case SCROLL_STATE_IDLE:
                Toast.makeText(this,"视图已经停止滑动",Toast.LENGTH_SHORT);
                Log.i("scroll","视图已经停止滑动");
                break;
            case SCROLL_STATE_TOUCH_SCROLL:
                Toast.makeText(this,"手指未离开屏幕\n视图正在滑动",Toast.LENGTH_SHORT);
                Log.i("scroll","手指未离开屏幕,视图正在滑动");
                break;
        }
    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {

    }
    // i 是列表项所对应的位置
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        lv.getItemAtPosition(i);
        Toast.makeText(this, "position="+i+"\n"+"text="+data[i], Toast.LENGTH_SHORT).show();
    }
}
