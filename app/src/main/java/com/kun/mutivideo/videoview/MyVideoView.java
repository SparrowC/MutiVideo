package com.kun.mutivideo.videoview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * Created by jiangkun on 16/7/25.
 */
public class MyVideoView extends VideoView {
    public static int WIDTH;
    public static int HEIGHT;
    public MyVideoView(Context context) {
        super(context);
    }

    public MyVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getDefaultSize(WIDTH, widthMeasureSpec);
        int height = getDefaultSize(HEIGHT, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }
}
