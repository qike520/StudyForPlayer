package com.example.studyforplayer;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SurfaceViewVideoPlayer extends AppCompatActivity {

    TextView startTime;
    TextView endTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surface_view_video_player);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        judgeOrientation();
        ButterKnife.bind(this);
    }

    private void judgeOrientation() {
        Configuration configuration=this.getResources().getConfiguration();
        int orientation=configuration.orientation;
        //横屏
        if(orientation==Configuration.ORIENTATION_LANDSCAPE){
            return;
        }else{
            Button button=findViewById(R.id.transform_screen);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    Toast.makeText(SurfaceViewVideoPlayer.this.getBaseContext(),"成功切换了屏幕",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }



}
