package com.kun.mutivideo;

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

import com.kun.mutivideo.test.VideoPlayerViewHolder;
import com.kun.mutivideo.test.VideoViewHolder;

import java.io.IOException;

/**
 * Created by jiangkun on 16/7/25.
 */
public class VideoPlayerAdapter extends RecyclerView.Adapter<VideoPlayerViewHolder> {
    private Context context;
    private String[] uris;


    public VideoPlayerAdapter(Context context, String[] uris) {
        this.context = context;
        this.uris = uris;
    }

    @Override
    public VideoPlayerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VideoPlayerViewHolder(LayoutInflater.from(context).inflate(R.layout.videoplayer_item,parent,false));
    }

    @Override
    public void onBindViewHolder(VideoPlayerViewHolder holder, int position) {
        holder.numText.setText(""+position);
        holder.videoPlayer.setUp(uris[position],""+position);
    }


    @Override
    public int getItemCount() {
        return uris.length;
    }

}
