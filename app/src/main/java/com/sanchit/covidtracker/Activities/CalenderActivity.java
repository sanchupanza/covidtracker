package com.sanchit.covidtracker.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;

import com.sanchit.covidtracker.R;
import com.sanchit.covidtracker.databinding.ActivityCalenderBinding;

public class CalenderActivity extends AppCompatActivity {

    private ActivityCalenderBinding binding;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_calender);
        context = this;



    }
}
