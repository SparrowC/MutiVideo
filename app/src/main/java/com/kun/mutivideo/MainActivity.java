package com.kun.mutivideo;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    String[] uris = {
            "http://video.dispatch.tc.qq.com/4440082/t0020l8rzy3.mp4?sdtfrom=v1001&type=mp4&vkey=40F6AD746D08ECA0C58308A7AC3280A17FAE77E00D2D517E7DE2C640ACE96901531748E25F1652E9592BDC2648B376F449E06A4CAACED8C12705EE05FEDD73A745D1119C23104574234627C06E89AA9653DDCA864EB01C976F3D613A4D9EC15829F64579358832E624911F1A0E981C9F&platform=10902&fmt=auto&sp=350&guid=0b2978ae0ca8efbfbf5af006bd7b4298",
            "http://video.dispatch.tc.qq.com/98753718/r0020gsqibl.mp4?sdtfrom=v1001&type=mp4&vkey=464E2E5FC8FBE9385DF67440AAA1B523350DD503264EBCC3A1A96B0F2CF34371997E6AE3B0CA4C2ABEB8AE2262A66343D0DB76DBC49852A0A1E0C38A3A3D69FB0937E20B1FAF09682A41887E460F287A28C3CD32AC1CD9863A57B2AE6C87F67EEBC2ADA3A331668C5315C7E560C9D101&platform=10902&fmt=auto&sp=350&guid=628f16b29939d1b060af49f66ae0f7f8",
            "http://video.dispatch.tc.qq.com/45706395/o00203wgrxo.mp4?sdtfrom=v1001&type=mp4&vkey=CCF2ED4CFAD7AF34569DC8345FC2ADD5D7A7566B8F7C635D414A3A26CE6F3F6BCD9642DFCD056537AFE4AEE78E72AE9AC9DED9C0AF93DB27B46C2C233DAED6EDFE167E9C3C9F40D099E6ED56ABFDFB3DE61F526302065E9AEC99817685381C859102AB998FD689D0529D2EFC168F9638&platform=10902&fmt=auto&sp=350&guid=96a4d89ba25627b2966703bae2947543",
            "http://video.dispatch.tc.qq.com/83758052/g0020b2mnt8.mp4?sdtfrom=v1001&type=mp4&vkey=373BB2FD02B842953810E7E486CBE8630CB75E2A2FDC343CE0387562027DF96B7DA6D646B1DD7B3346AC743276139310402164DC80D431FE670BF8F76AE8BAD9EFF742B13FD649A79E319A745FFF68D21B82B86FEDA06BE5CD554BA1283ED823EAF9DD7E85B1A86CB8B697F13550FC9E&platform=10902&fmt=auto&sp=350&guid=b96fab78f4c997de5d5fa8621625e8b4",
            "http://video.dispatch.tc.qq.com/4440082/t0020l8rzy3.mp4?sdtfrom=v1001&type=mp4&vkey=40F6AD746D08ECA0C58308A7AC3280A17FAE77E00D2D517E7DE2C640ACE96901531748E25F1652E9592BDC2648B376F449E06A4CAACED8C12705EE05FEDD73A745D1119C23104574234627C06E89AA9653DDCA864EB01C976F3D613A4D9EC15829F64579358832E624911F1A0E981C9F&platform=10902&fmt=auto&sp=350&guid=0b2978ae0ca8efbfbf5af006bd7b4298",
            "http://video.dispatch.tc.qq.com/98753718/r0020gsqibl.mp4?sdtfrom=v1001&type=mp4&vkey=464E2E5FC8FBE9385DF67440AAA1B523350DD503264EBCC3A1A96B0F2CF34371997E6AE3B0CA4C2ABEB8AE2262A66343D0DB76DBC49852A0A1E0C38A3A3D69FB0937E20B1FAF09682A41887E460F287A28C3CD32AC1CD9863A57B2AE6C87F67EEBC2ADA3A331668C5315C7E560C9D101&platform=10902&fmt=auto&sp=350&guid=628f16b29939d1b060af49f66ae0f7f8",
            "http://video.dispatch.tc.qq.com/45706395/o00203wgrxo.mp4?sdtfrom=v1001&type=mp4&vkey=CCF2ED4CFAD7AF34569DC8345FC2ADD5D7A7566B8F7C635D414A3A26CE6F3F6BCD9642DFCD056537AFE4AEE78E72AE9AC9DED9C0AF93DB27B46C2C233DAED6EDFE167E9C3C9F40D099E6ED56ABFDFB3DE61F526302065E9AEC99817685381C859102AB998FD689D0529D2EFC168F9638&platform=10902&fmt=auto&sp=350&guid=96a4d89ba25627b2966703bae2947543",
            "http://video.dispatch.tc.qq.com/83758052/g0020b2mnt8.mp4?sdtfrom=v1001&type=mp4&vkey=373BB2FD02B842953810E7E486CBE8630CB75E2A2FDC343CE0387562027DF96B7DA6D646B1DD7B3346AC743276139310402164DC80D431FE670BF8F76AE8BAD9EFF742B13FD649A79E319A745FFF68D21B82B86FEDA06BE5CD554BA1283ED823EAF9DD7E85B1A86CB8B697F13550FC9E&platform=10902&fmt=auto&sp=350&guid=b96fab78f4c997de5d5fa8621625e8b4"
    };
    private static final int[] SURFACE_RES_IDS = {
            R.id.surfaceView1, R.id.surfaceView2, R.id.surfaceView3,R.id.surfaceView4,
            R.id.surfaceView5,R.id.surfaceView6,R.id.surfaceView7,R.id.surfaceView8};

    private MediaPlayer[] mMediaPlayers = new MediaPlayer[SURFACE_RES_IDS.length];
    private SurfaceView[] mSurfaceViews = new SurfaceView[SURFACE_RES_IDS.length];
    private SurfaceHolder[] mSurfaceHolders = new SurfaceHolder[SURFACE_RES_IDS.length];

    private ProgressBar progressBar;


    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        inti();
        loadVideo();
    }

    private void loadVideo() {
        for (int i=0; i<mSurfaceViews.length; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    mSurfaceHolders[finalI] = mSurfaceViews[finalI].getHolder();
                    mSurfaceHolders[finalI].addCallback(new MyCallBack(finalI));

                    try {
                        mMediaPlayers[finalI]=new MediaPlayer();
                        mMediaPlayers[finalI].setDataSource(MainActivity.this, Uri.parse(uris[finalI]));
                        mMediaPlayers[finalI].prepare();
                        mMediaPlayers[finalI].setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        mMediaPlayers[finalI].start();
                                    }
                                });
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    private void inti() {
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        for (int i=0; i<mSurfaceViews.length; i++)
            mSurfaceViews[i] = (SurfaceView) findViewById(SURFACE_RES_IDS[i]);

        progressBar.setVisibility(View.VISIBLE);
    }


    @Override
    protected void onPause() {
        super.onPause();
        releaseMediaPlayers();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseMediaPlayers();
    }

    private void releaseMediaPlayers() {
        for (int i=0; i<mMediaPlayers.length; i++) {
            if (mMediaPlayers[i] != null) {
                mMediaPlayers[i].release();
                mMediaPlayers[i] = null;
            }
        }
    }

    private class MyCallBack implements SurfaceHolder.Callback {
        int index;
        public MyCallBack(int i) {
            index=i;
        }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            mMediaPlayers[index].setDisplay(holder);
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            progressBar.setVisibility(View.INVISIBLE);
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

        }
    }
}
