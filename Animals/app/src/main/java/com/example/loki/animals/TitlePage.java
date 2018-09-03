package com.example.loki.animals;


import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageButton;


public class TitlePage extends AppCompatActivity {
    private boolean soundStatus = true;
    private int currentApiVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_page);
        startService(new Intent(this, MyService.class));


        hideBarAndNavigation();

        runActivity();
        soundButtonStatus();


    }

    private void hideBarAndNavigation() {
        currentApiVersion = Build.VERSION.SDK_INT;

        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        // This work only for android 4.4+
        if (currentApiVersion >= Build.VERSION_CODES.KITKAT) {

            getWindow().getDecorView().setSystemUiVisibility(flags);

            // Code below is to handle presses of Volume up or Volume down.
            // Without this, after pressing volume buttons, the navigation bar will
            // show up and won't hide
            final View decorView = getWindow().getDecorView();
            decorView
                    .setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {

                        @Override
                        public void onSystemUiVisibilityChange(int visibility) {
                            if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                                decorView.setSystemUiVisibility(flags);
                            }
                        }
                    });
        }
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (currentApiVersion >= Build.VERSION_CODES.KITKAT && hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }


    public void onUserLeaveHint() { // выкл сервиса звука при нажатии кнопки хоум
        stopService(new Intent(this, MyService.class));
    }


    // switch on and off sound after close and open app
    @Override
    protected void onResume() {
        super.onResume();

        if (soundStatus) {
            startService(new Intent(this, MyService.class));

        } else {
            stopService(new Intent(this, MyService.class));
        }
    }


    // start button for main activity. with sound intent
    private void runActivity() {
        ImageButton playButton = findViewById(R.id.play_button);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TitlePage.this, ActionScreen.class);
                intent.putExtra("soundStatus", soundStatus);  //передаем в следующую активность состояние звука (вкл/выкл)
                startActivity(intent);
            }
        });
    }


    //кнопка вкл/выкл звука. завязана на логическую переменную. ее и отслеживает sound button is connected with boolean soundStatus. here we watching for it

    private void soundButtonStatus() {

        final ImageButton muteOff = findViewById(R.id.soundOff);
        muteOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (soundStatus) {

                    stopService(new Intent(TitlePage.this, MyService.class));
                    soundStatus = false;
                    muteOff.setImageResource(R.drawable.sound_off);

                } else {
                    startService(new Intent(TitlePage.this, MyService.class));
                    soundStatus = true;
                    muteOff.setImageResource(R.drawable.sound_on);
                }
            }


        });
    }


}
