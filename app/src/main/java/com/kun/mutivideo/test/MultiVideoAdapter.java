package com.kun.mutivideo.test;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;

import com.kun.mutivideo.R;

import java.io.IOException;

/**
 * Created by jiangkun on 16/7/25.
 */
public class MultiVideoAdapter extends RecyclerView.Adapter<VideoViewHolder> {
    private Context context;
    private String[] uris;
    private MediaPlayer[] mediaPlayers;
    private Handler handler;

    public MultiVideoAdapter(Context context, String[] uris) {
        this.context = context;
        this.uris = uris;
        handler=new Handler(context.getMainLooper()){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

            }
        };
        mediaPlayers=new MediaPlayer[uris.length];
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VideoViewHolder(LayoutInflater.from(context).inflate(R.layout.surfaceview_item,parent,false));
    }

    @Override
    public void onBindViewHolder(final VideoViewHolder videoHolder, final int position) {
        videoHolder.numText.setText(""+position);
        videoHolder.progressBar.setVisibility(View.VISIBLE);
        videoHolder.surfaceView.getHolder().addCallback(new MyCallBack(videoHolder,position));
    }

    @Override
    public int getItemCount() {
        return uris.length;
    }

    private class MyCallBack implements SurfaceHolder.Callback {
        private VideoViewHolder videoHolder;
        private int position;
        public MyCallBack(VideoViewHolder videoHolder, int position) {
            this.videoHolder=videoHolder;
            this.position=position;
        }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            if(mediaPlayers[position]==null)
            {
                mediaPlayers[position]=new MediaPlayer();
                try {
                    mediaPlayers[position].setDataSource(context, Uri.parse(uris[position]));
                    mediaPlayers[position].prepareAsync();
                    mediaPlayers[position].setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            if(mediaPlayers[position]!=null)
                            {
                                videoHolder.progressBar.setVisibility(View.INVISIBLE);
                                mediaPlayers[position].start();
                                mediaPlayers[position].setLooping(true);
                            }
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            mediaPlayers[position].setDisplay(holder);
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            if(mediaPlayers[position]!=null)
            {
                mediaPlayers[position].stop();
                mediaPlayers[position].release();
                mediaPlayers[position]=null;
                videoHolder.progressBar.setVisibility(View.VISIBLE);
            }
        }
    }
}
