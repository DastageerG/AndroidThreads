package com.example.androidthreads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    private TextView textView;
    private ScrollView scrollView;
    private ProgressBar progressBar;
    Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        scrollView = findViewById(R.id.scrollView);

        progressBar = findViewById(R.id.progressBar);

        textView.setText(R.string.lorem);

    }

    public void runCode(View view)
    {
        log("Code Running");
        progressBar.setVisibility(View.VISIBLE);

        // this method block the UI Thread;
//
//        try
//        {
//            Thread.sleep(3000);
//        } catch (InterruptedException e)
//        {
//            e.printStackTrace();
//        }

///             This is the better way
        Runnable runnable = new Runnable()
        {
            @Override
            public void run()
            {
               progressBar.setVisibility(View.GONE);
            }
        };
        Handler handler = new Handler();
        handler.postDelayed(runnable,3000);



    } // runCode closed
    private void log(String message)
    {
        textView.append(message+"\n");
        scrollView.fullScroll(View.FOCUS_DOWN);
    }
    public void clearText(View view)
    {
        textView.setText("");
        scrollView.fullScroll(View.FOCUS_UP);
    }

} // mainActivity closed