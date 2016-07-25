package com.kun.mutivideo.test;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.kun.mutivideo.R;

import java.io.IOException;

/**
 * Created by jiangkun on 16/7/25.
 */
public class VideoActivity extends Activity {
    private SurfaceView surfaceView;
    private MediaPlayer player;
    private SurfaceHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surfaceview_item);
        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        String uri="http://video.dispatch.tc.qq.com/4440082/t0020l8rzy3.mp4?sdtfrom=v1001&type=mp4&vkey=40F6AD746D08ECA0C58308A7AC3280A17FAE77E00D2D517E7DE2C640ACE96901531748E25F1652E9592BDC2648B376F449E06A4CAACED8C12705EE05FEDD73A745D1119C23104574234627C06E89AA9653DDCA864EB01C976F3D613A4D9EC15829F64579358832E624911F1A0E981C9F&platform=10902&fmt=auto&sp=350&guid=0b2978ae0ca8efbfbf5af006bd7b4298";

        player=new MediaPlayer();
        try {
            player.setDataSource(this, Uri.parse(uri));
            holder=surfaceView.getHolder();
            holder.addCallback(new MyCallBack());
            player.prepare();
            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {


                    player.start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class MyCallBack implements SurfaceHolder.Callback {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {

        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

        }
    }
}
