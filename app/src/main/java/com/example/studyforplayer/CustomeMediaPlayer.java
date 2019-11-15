package com.example.studyforplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studyforplayer.utils.FormatTimeUtils;

public class CustomeMediaPlayer implements
        MediaPlayer.OnPreparedListener,MediaPlayer.OnCompletionListener,
        MediaPlayer.OnErrorListener,MediaPlayer.OnInfoListener,MediaPlayer.OnSeekCompleteListener,
        MediaPlayer.OnVideoSizeChangedListener, SeekBar.OnSeekBarChangeListener{
    private TextView mstartTime,mendTime;
    private SeekBar mseekBar;
    private MediaPlayer mediaPlayer;
    private Context mContext;

    /**
     *
     * @param mstartTime    播放视频当前时间
     * @param mendTime      视频最大时间
     * @param mseekBar      进度条
     * @param mediaPlayer
     * @param mContext
     */
    public CustomeMediaPlayer(TextView mstartTime, TextView mendTime, SeekBar mseekBar, MediaPlayer mediaPlayer, Context mContext) {
        this.mstartTime = mstartTime;
        this.mendTime = mendTime;
        this.mseekBar = mseekBar;
        this.mediaPlayer = mediaPlayer;
        this.mContext = mContext;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        //temporary
        Toast.makeText(mContext,"播放完毕,是否重新播放",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {

        mstartTime.setText(FormatTimeUtils.formatVideoTimeToSecond(mp.getCurrentPosition()));
        mendTime.setText(FormatTimeUtils.formatVideoTimeToSecond(mp.getDuration()));
        mseekBar.setMax(mp.getDuration());
        mseekBar.setProgress(mp.getCurrentPosition());

    }

    @Override
    public void onSeekComplete(MediaPlayer mp) {

    }

    @Override
    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(mediaPlayer!=null && fromUser){
            mediaPlayer.seekTo(progress);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
