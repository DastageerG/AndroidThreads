package com.example.androidthreads;

import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import android.os.Handler;

import java.util.logging.LogRecord;

public class DownloadHandler extends Handler
{
    public static final String TAG = "1111";

    @Override
    public void handleMessage(@NonNull Message msg)
    {
        super.handleMessage(msg);

        downloadSong(msg.obj.toString());

    } // handle message closed


    private void downloadSong(String songName)
    {
        Log.d(TAG, "downloadSong: download Started ");
        try
        {
            Thread.sleep(3000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } // catch closed

        Log.d(TAG, "downloadSong: " + songName + " Downloaded");


    } /// downloadSongClosed


} // DownloadHandler closed
