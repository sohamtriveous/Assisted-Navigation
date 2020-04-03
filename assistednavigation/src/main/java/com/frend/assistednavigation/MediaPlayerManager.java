package com.frend.assistednavigation;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import androidx.annotation.NonNull;

class MediaPlayerManager {

    private static MediaPlayerManager singletonObject = null;

    private MediaPlayer mediaPlayer;

    private MediaPlayerManager() {
        mediaPlayer = new MediaPlayer();
    }


    @NonNull
    static MediaPlayerManager getInstance() {
        if (singletonObject == null) {
            singletonObject = new MediaPlayerManager();
        }
        return singletonObject;
    }

    public void play(String url) {
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaPlayer.start();
    }

    public void playFromStorage(@NotNull Activity activity, String url) {

        String fileName = URLUtil.guessFileName(url, null, MimeTypeMap.getFileExtensionFromUrl(url));
        String audioPath = Environment.getExternalStorageDirectory().getPath() + "/InternetSaathi/" + fileName;
        mediaPlayer = MediaPlayer.create(activity.getApplicationContext(), Uri.parse(audioPath));
        if (mediaPlayer != null)
            mediaPlayer.start();
    }

    public void playFromAssets(@NotNull Activity activity, String resource){
        mediaPlayer = MediaPlayer.create(activity.getApplicationContext(), activity.getResources().getIdentifier(resource, "raw", activity.getPackageName()));
        if (mediaPlayer != null)
            mediaPlayer.start();
    }

    public void stop() {

        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
        singletonObject = null;
    }

}
