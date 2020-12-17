package com.example.androidthreads;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    public static final String TAG = "1111";
    private TextView textView;
    private ScrollView scrollView;
    private ProgressBar progressBar;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        scrollView = findViewById(R.id.scrollView);

        handler = new Handler(getMainLooper())
        {
            @Override
            public void handleMessage(@NonNull Message msg)
            {
                super.handleMessage(msg);
                Toast.makeText(MainActivity.this, "" + msg.getData().get("Message"), Toast.LENGTH_SHORT).show();
            }
        };

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);


        // textView.setText(R.string.lorem);

    }

    public void runCode(View view)
    {
        log("Code Running");


        DownloadThread thread = new DownloadThread();
        thread.start();
        

//        Handler handler = new Handler();
//        handler.postDelayed(runnable,3000);


    } // runCode closed
    private void log(String message)
    {
        textView.append(message+"\n");

    }
    public void clearText(View view)
    {
        textView.setText("");

    }

} // mainActivity closed