package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.Year;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer;

    Button btnstart, btnend;
    RadioButton rdoTime, rdoCal;
    CalendarView calendar;
    TimePicker timepicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    int sYear, sMonth, sDay;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = findViewById(R.id.chronometer);
        btnstart = findViewById(R.id.btnstart);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.start();
                chronometer.setTextColor(Color.GREEN);
            }
        });

        calendar = findViewById(R.id.calendar);
        timepicker = findViewById(R.id.timepicker);
        rdoCal = findViewById(R.id.rdoCal);
        rdoTime = findViewById(R.id.rdoTime);
        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.setVisibility(View.VISIBLE);
                timepicker.setVisibility(View.INVISIBLE);
            }
        });
        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.setVisibility(View.INVISIBLE);
                timepicker.setVisibility(View.VISIBLE);
            }
        });
        btnend = findViewById(R.id.btnend);
        tvYear = findViewById(R.id.tvYear);
        tvDay = findViewById(R.id.tvDay);
        tvMonth = findViewById(R.id.tvMonth);
        tvHour = findViewById(R.id.tvHour);
        tvMinute = findViewById(R.id.tvMinute);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView,
                                            int Year, int Month, int Day) {
                sYear = Year;
                sMonth = Month;
                sDay = Day;
            }
        });




        btnend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.stop();
                chronometer.setTextColor(Color.GRAY);
                tvYear.setText(Integer.toString(sYear));
                tvMonth.setText(Integer.toString(sMonth));
                tvDay.setText(Integer.toString(sDay));
                tvHour.setText(Integer.toString(timepicker.getCurrentHour()));
                tvMinute.setText(Integer.toString((timepicker.getCurrentMinute())));
            }
        });


    }
}