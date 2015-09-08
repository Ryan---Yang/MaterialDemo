package com.example.chenhaoych.materialdemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends Activity implements Slider.OnValueChangedListener {
    int color = Color.parseColor("#01579b");
    Slider red, green, blue;
    TextView rt, gt, bt;
    View headerView;

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
        headerView = findViewById(R.id.head_rl);

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
        headerView.setBackgroundColor(color);
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
