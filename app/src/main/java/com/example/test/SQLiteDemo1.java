package com.example.test;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SQLiteDemo1 extends AppCompatActivity {

    TextView tv;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_demo1);

        tv=(TextView)findViewById(R.id.sqlite_tv1);
        db=openOrCreateDatabase("myFirstDB",MODE_PRIVATE,null);
    }
    public void doClick(View view){
        switch (view.getId()){
            case R.id.sqlite_bt1:
                execSQL();
                break;
            case R.id.sqlite_bt2:
                contentValues();
                break;
        }
    }
    public void execSQL(){
        db.execSQL("create table if not exists MyTB(_id integer primary key,name char(4) not null, age int(3) not null, sex char(2) not null);");
        db.execSQL("insert into MyTB(name,age,sex) values('张三',20,'男')");

        //查询数据
        Cursor cursor=db.rawQuery("select * from MyTB",null);
        if(cursor!=null){
            while(cursor.moveToNext()){
                Log.i("数据表的信息:","_id:"+cursor.getColumnIndex("_id"));
                Log.i("数据表的信息:","name:"+cursor.getColumnIndex("name"));
                Log.i("数据表的信息:","age:"+cursor.getColumnIndex("age"));
                Log.i("数据表的信息:","sex:"+cursor.getColumnIndex("sex"));

                Toast.makeText(SQLiteDemo1.this,""+cursor.getColumnIndex("name"),Toast.LENGTH_SHORT).show();
            }
            cursor.close();
        }
        db.close();
    }
    //利用内置函数ContentValues对数据库操作
    public void contentValues(){
        db.execSQL("create table if not exists tb1(name char(4) null,age integer null,sex char(2) null);");
        ContentValues values=new ContentValues();  //内置函数，相当于hashmap 的键值对存储方式
        values.put("name","曹操");
        values.put("age",20);
        values.put("sex","男");
        db.insert("tb1",null,values);
        //查询
        Cursor cursor=db.query("tb1",null,null,null,null,null,null);
        if (cursor!=null){
            String[] columns=cursor.getColumnNames();
            while (cursor.moveToNext()){
                for (String columnName:columns){
                    Log.i("数据库tb1的info：",cursor.getString(cursor.getColumnIndex(columnName)));
                    tv.setText(cursor.getString(cursor.getColumnIndex(columnName)));

                }
            }
        }
    }
}
