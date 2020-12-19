package com.example.androidthreads;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
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

public class MainActivity extends AppCompatActivity implements TaskFragment.TaskHandler
{

    private DownloadThread thread;
    public static final String TAG = "1111";
    private TextView textView;
    private ScrollView scrollView;
    private int count = 0;
    private boolean isTaskRunning;
    private TaskFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        scrollView = findViewById(R.id.scrollView);

        FragmentManager fm = getFragmentManager();
        fragment = (TaskFragment) fm.findFragmentByTag("Fragment");

        if (fragment == null)
        {
            fragment = new TaskFragment();
            fm.beginTransaction().add(fragment, "Fragment").commit();
        }


    } // onCreate closed


    public void runCode(View view)
    {
        // log("Code Running");

        fragment.runTask("Manjo Maye", "Na weende", "Hala Thayi", "Ha ustad", "Chicke Rakhis");

    } // runCode closed
    private void log(String message)
    {
        textView.append(message + "\n");

    }

    public void clearText(View view)
    {
        textView.setText("");

    }


    @Override
    public void handleTask(String message)
    {
        log(message);
    }
} // mainActivity closed


