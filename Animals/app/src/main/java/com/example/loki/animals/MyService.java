package com.example.loki.animals;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    private static final String TAG = "MyService";
    MediaPlayer player;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, R.string.MyServiceCreated, Toast.LENGTH_LONG).show();

        player = MediaPlayer.create(this, R.raw.mus);
        player.setLooping(true); // loop
    }



    @Override
    public void onDestroy() {
        Toast.makeText(this, R.string.MyServiceStopped, Toast.LENGTH_LONG).show();
        player.stop();
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, R.string.MyServiceStarted, Toast.LENGTH_LONG).show();
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }




}