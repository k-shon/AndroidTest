package com.example.test;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ServiceTest2 extends Service {

    final String str="service";
    //类
    public class MyBind extends Binder{
        public ServiceTest2 getService(){
            return ServiceTest2.this;
        }
    }
    @Override
    public void onCreate() {
        Log.i(str,"onCreate启动中...");
        super.onCreate();
    }
    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        Log.i(str,"onStartCommand启动中...");
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(str,"onBind启动中...");
        return new MyBind();
    }
    @Override
    public void unbindService(ServiceConnection conn) {
        Log.i(str,"unBindService启动中...");
        super.unbindService(conn);
    }
    @Override
    public void onDestroy() {
        Log.i(str,"onDestroy启动中...");
        super.onDestroy();
    }

    public void play(){
        Log.i(str,"播放");
    }
    public void pause(){
        Log.i(str,"暂停");
    }
    public void next(){
        Log.i(str,"下一首");
    }
    public void pervious(){
        Log.i(str,"上一首");
    }
}
