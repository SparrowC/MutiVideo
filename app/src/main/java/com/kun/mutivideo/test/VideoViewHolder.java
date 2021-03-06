package com.kun.mutivideo.test;

import android.support.v7.widget.RecyclerView;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kun.mutivideo.R;

/**
 * Created by jiangkun on 16/7/25.
 */
public class VideoViewHolder extends RecyclerView.ViewHolder {
    public SurfaceView surfaceView;
    public ProgressBar progressBar;
    public TextView numText;

    public VideoViewHolder(View itemView) {
        super(itemView);
        surfaceView = (SurfaceView) itemView.findViewById(R.id.surfaceView);
        progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
        numText = (TextView) itemView.findViewById(R.id.numText);
    }
}
