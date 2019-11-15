package com.example.studyforplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.video_view)
    VideoView videoView;
    MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ButterKnife.bind(this);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.dragon);
        mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.requestFocus();
    }

    @OnClick(R.id.play_video)
    public void playVideo(View view){
        videoView.start();
    }

    @OnClick(R.id.stop_video)
    public void stopPlayer(View view){
        videoView.stopPlayback();
    }
    @OnClick(R.id.continue_video)
    public void continuePlayer(View view){

    }
    @OnClick(R.id.jump_surface_controller)
    public void jumpNextActivity(View view){
        Intent intent=new Intent(this,SurfaceViewVideoPlayer.class);
        startActivity(intent);
    }

}
