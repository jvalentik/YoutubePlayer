package org.jvk.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandAloneActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String GOOGLE_API_KEY = "AIzaSyBxBOAksqev_ZLwn73TOqMDRDcyDF_kzsU";
    private static final String YOUTUBE_VIDEO_ID = "FpkwCKkA4do";
    private static final String YOUTUBE_PLAYLIST = "PLh6vppUwmWEMdp04u-tYABoDmgn9AX12n";
    private Button btnPlayVideo;
    private Button btnPlayPlaylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stand_alone);
        btnPlayVideo = (Button) findViewById(R.id.btnPlayVideo);
        btnPlayVideo.setOnClickListener(this);
        btnPlayPlaylist = (Button) findViewById(R.id.btnPlaylist);
        btnPlayPlaylist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()) {
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer
                        .createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);
                break;
            case R.id.btnPlaylist:
                intent = YouTubeStandalonePlayer
                        .createPlaylistIntent(this, GOOGLE_API_KEY, YOUTUBE_PLAYLIST);
                break;
            default:

        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
