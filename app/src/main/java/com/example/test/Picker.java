package com.example.test;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class Picker extends AppCompatActivity {

    Button bt1,bt2;
    TimePicker timePicker;
    DatePicker datePicker;
    Calendar cal;
    int year,month,day;
    int hour,minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
        //获取时间
        cal=Calendar.getInstance();
        year=cal.get(Calendar.YEAR);
        month=cal.get(Calendar.MONTH)+1;
        day=cal.get(Calendar.DAY_OF_MONTH);
        hour=cal.get(Calendar.HOUR_OF_DAY);
        minute=cal.get(Calendar.MINUTE);
        setTitle(year+"-"+month+"-"+day+"-"+hour+":"+minute);

        datePicker=(DatePicker)findViewById(R.id.datePicker);
        timePicker=(TimePicker)findViewById(R.id.timePicker);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                setTitle(i+"-"+i1+"-"+i2+"-"+hour+":"+minute);
            }
        });
        bt1=(Button)findViewById(R.id.picker_bt1);
        bt2=(Button)findViewById(R.id.picker_bt2);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Picker.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        setTitle(i+"-"+i1+"-"+i2);
                    }
                },year, month, day).show();
            }
        });
    }
}
