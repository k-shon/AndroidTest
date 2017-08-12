package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.R.attr.contentInsetStart;
import static android.R.attr.onClick;
import static android.R.attr.start;

public class MainActivity extends AppCompatActivity {

    Button bt,bt1,bt2,bt3,bt4,bt5,bt6;
    String tag="tag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt=(Button)findViewById(R.id.main_bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ArrayAdapterTest.class);
                startActivity(intent);
                finish();
            }
        });
        bt1=(Button)findViewById(R.id.main_bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Test.class);
                startActivity(intent);
                finish();
            }
        });
        bt2=(Button)findViewById(R.id.main_bt2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Picker.class);
                startActivity(intent);
                finish();
            }
        });
        bt3=(Button)findViewById(R.id.main_bt3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, SpinnerTest.class);
                startActivity(intent);
                finish();
            }
        });
        bt4=(Button)findViewById(R.id.main_bt4);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ServiceTest.class);
                startActivity(intent);
                finish();
            }
        });
        bt5=(Button)findViewById(R.id.main_bt5);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SharePref.class);
                startActivity(intent);
                finish();
            }
        });
        bt6=(Button)findViewById(R.id.main_bt6);
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,WebViewTest.class);
                startActivity(intent);
                finish();
            }
        });
    }


    protected void onStart(){
        super.onStart();
        Log.i(tag,"onStart()方法");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(tag,"onPause()方法");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(tag,"onStop()方法");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(tag,"onDestroy()方法");
    }
    protected void onRestart() {
        super.onRestart();
        Log.i(tag,"onRestart()方法");
    }
}
