package com.example.test;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ServiceTest1 extends Service {

    final String tag="ServiceTest1";

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"service启动中..",Toast.LENGTH_SHORT).show();
        Log.i(tag,"service启动中..");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"startCommand启动中..",Toast.LENGTH_SHORT).show();
        Log.i(tag,"startCommand启动中..");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"service销毁中..",Toast.LENGTH_SHORT).show();
        Log.i(tag,"service销毁中..");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(tag,">>>>>>>>>>>>>onBind启动..");
        return null;
    }
    public boolean onUnbind(Intent i){
        Log.i(tag,">>>>>>>>>>>onUnBind启动.");
        return false;
    }
}
