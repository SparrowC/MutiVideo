package com.kun.mutivideo.test;

import android.support.v7.widget.RecyclerView;
import android.view.SurfaceView;
import android.view.View;

import com.kun.mutivideo.R;

/**
 * Created by jiangkun on 16/7/25.
 */
public class VideoViewHolder extends RecyclerView.ViewHolder{
    public SurfaceView surfaceView;
    public VideoViewHolder(View itemView) {
        super(itemView);
        surfaceView= (SurfaceView) itemView.findViewById(R.id.surfaceView);
    }
}
