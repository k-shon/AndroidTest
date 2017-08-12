package com.example.test;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ServiceTest extends Activity {

    TextView tv;
    Intent intent,intent1;
    ServiceTest2 test2;
    ServiceConnection conn=new ServiceConnection() {
        @Override//连接成功
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            test2=((ServiceTest2.MyBind)iBinder).getService();//得到服务对象
        }

        @Override//连接意外失败
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
    }
    public void doClick(View view){
        switch (view.getId()){
            case R.id.service_start:
                tv=(TextView)findViewById(R.id.service_tv1);
                Toast.makeText(ServiceTest.this,"点击了start..", Toast.LENGTH_SHORT);
                tv.setText("单击了start");
                intent=new Intent(ServiceTest.this,ServiceTest1.class);
                startService(intent);
                break;
            case R.id.service_stop:
                stopService(intent);
                break;
            case R.id.service_bind:
                intent1=new Intent(ServiceTest.this,ServiceTest2.class);
                bindService(intent1,conn,Service.BIND_AUTO_CREATE);
                break;
            case R.id.service_unbind:
                unbindService(conn);
                break;
            case R.id.service_next:
                test2.next();
                break;
            case R.id.service_pervious:
                test2.pervious();
                break;
            case R.id.service_play:
                test2.play();
                break;
            case R.id.service_pause:
                test2.pause();
                break;

        }
    }
}
