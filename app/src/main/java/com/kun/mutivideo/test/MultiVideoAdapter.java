package com.kun.mutivideo.test;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
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

    public MultiVideoAdapter(Context context, String[] uris) {
        this.context = context;
        this.uris = uris;
        mediaPlayers=new MediaPlayer[uris.length];
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VideoViewHolder(LayoutInflater.from(context).inflate(R.layout.surfaceview_item,parent,false));
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, final int position) {
        mediaPlayers[position]=new MediaPlayer();
        try {
            mediaPlayers[position].setDataSource(context, Uri.parse(uris[position]));
            mediaPlayers[position].prepare();
            holder.surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
                @Override
                public void surfaceCreated(SurfaceHolder holder) {
                    mediaPlayers[position].setDisplay(holder);
                }

                @Override
                public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

                }

                @Override
                public void surfaceDestroyed(SurfaceHolder holder) {

                }
            });
            mediaPlayers[position].setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayers[position].start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return uris.length;
    }
}
