package com.example.androidthreads;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
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

    private DownloadThread thread;
    public static final String TAG = "1111";
    private TextView textView;
    private ScrollView scrollView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        scrollView = findViewById(R.id.scrollView);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);


    } // onCreate closed


    public void runCode(View view)
    {
        log("Code Running");

        new TaskCheck().execute("Hello", "Hi ", "Ola");


    } // runCode closed
    private void log(String message)
    {
        textView.append(message + "\n");

    }

    public void clearText(View view)
    {
        textView.setText("");

    }

    public class TaskCheck extends AsyncTask<String, Void, Void>
    {

        @Override
        protected Void doInBackground(String... strings)
        {

            for (String string : strings)
            {
                Log.d(TAG, "doInBackground: " + string);

                try
                {
                    Thread.sleep(3000);
                } // try closed
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                } // catch closed


            } // for closed
            return null;
        }
    }
} // mainActivity closed


