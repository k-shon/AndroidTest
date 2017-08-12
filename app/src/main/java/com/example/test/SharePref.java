package com.example.test;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SharePref extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_pref);

        SharedPreferences pref=this.getSharedPreferences("prefTest",MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        //先获得值
        int sum=pref.getInt("int",0);
        Log.i("字符串:",pref.getString("str","没有字符串值"));
        Log.i("整形:",Integer.toString(sum));


        editor.putString("str","这是一个字符串");
        editor.putInt("int",299);
        editor.commit();

        Log.i("字符串Test:",pref.getString("str","没有字符串值"));
        Log.i("整形Test:",Integer.toString(pref.getInt("int",0)));
    }
}
