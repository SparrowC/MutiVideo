package com.kun.mutivideo.test;

import android.support.v7.widget.RecyclerView;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kun.mutivideo.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by jiangkun on 16/7/25.
 */
public class VideoPlayerViewHolder extends RecyclerView.ViewHolder {
    public JCVideoPlayerStandard videoPlayer;
    public TextView numText;

    public VideoPlayerViewHolder(View itemView) {
        super(itemView);
        videoPlayer = (JCVideoPlayerStandard) itemView.findViewById(R.id.videoPlayer);
        numText = (TextView) itemView.findViewById(R.id.numText);
    }
}
