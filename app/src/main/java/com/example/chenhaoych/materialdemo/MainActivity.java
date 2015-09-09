package com.example.chenhaoych.materialdemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.chenhaoych.materialdemo.view.Slider;

public class MainActivity extends AppCompatActivity implements Slider.OnValueChangedListener {
    private int color = Color.parseColor("#01579b");
    private Slider red, green, blue;
    private TextView rt, gt, bt;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        red = (Slider) findViewById(R.id.red);
        green = (Slider) findViewById(R.id.green);
        blue = (Slider) findViewById(R.id.blue);
        rt = (TextView) findViewById(R.id.Rtext);
        gt = (TextView) findViewById(R.id.Gtext);
        bt = (TextView) findViewById(R.id.Btext);
//        headerView = findViewById(R.id.head_rl);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextAppearance(this, R.style.TitleTextStyle);
//        toolbar.setTitleTextColor(Color.WHITE);

        int r = (this.color >> 16) & 0xFF;
        int g = (this.color >> 8) & 0xFF;
        int b = (this.color >> 0) & 0xFF;

        red.setValue(r);
        green.setValue(g);
        blue.setValue(b);

        red.setOnValueChangedListener(this);
        green.setOnValueChangedListener(this);
        blue.setOnValueChangedListener(this);
    }

    @Override
    public void onValueChanged(int value) {
        color = Color.rgb(red.getValue(), green.getValue(), blue.getValue());
        toolbar.setBackgroundColor(color);
        red.setBackgroundColor(color);
        green.setBackgroundColor(color);
        blue.setBackgroundColor(color);
        rt.setTextColor(color);
        gt.setTextColor(color);
        bt.setTextColor(color);
/*        red.setDialogStatusBarColor(color);
        green.setDialogStatusBarColor(color);
        blue.setDialogStatusBarColor(color);*/
        getWindow().setStatusBarColor(color);
    }
}
