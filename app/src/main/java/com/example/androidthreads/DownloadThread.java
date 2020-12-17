package com.example.androidthreads;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class DownloadThread extends Thread
{

    public static final String TAG = "1111";
    private String songName;
    public DownloadHandler mHandler;

    @Override
    public void run()
    {
        super.run();
        Looper.prepare();
        mHandler = new DownloadHandler();
        Looper.loop();

    } // run closed

}
