package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button start, stop;
    TextView counter;

    int i;

    Handler handler;

    Runnable runnable;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start =  findViewById(R.id.startbut);
        stop =  findViewById(R.id.stopbut);
        counter =  findViewById(R.id.out);

        handler = new Handler();
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    public void Counter() {
        runnable = new Runnable() {
            @Override
            public void run() {
                i++;
                counter.setText(String.valueOf(i));
                handler.postDelayed(this, 100);
            }
        };
        handler.post(runnable);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.startbut)
        {
            Counter();
            start.setEnabled(false);
            stop.setEnabled(true);
        }
        else if (view.getId()==R.id.stopbut)
        {
            handler.removeCallbacks(runnable);
            start.setEnabled(true);
            stop.setEnabled(false);
        }

    }

}

