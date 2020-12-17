package com.example.androidthreads;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;

public class DownloadThread extends Thread
{

    public static final String TAG = "1111";
    private String songName;


    @Override
    public void run()
    {
        super.run();

        for (String songName : Playlist.songs)
        {
            downloadSong(songName);
        }

    } // run closed

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

}
