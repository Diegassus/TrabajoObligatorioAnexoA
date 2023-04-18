package com.example.trabajoobligatorioanexoa.ui.musica;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ServicioMusica extends ViewModel {

    private MediaPlayer mediaPlayer;
    private boolean isPlaying;

    public void startPlaying(Context context, int resId) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(context, resId);
            mediaPlayer.setOnCompletionListener((MediaPlayer mp) -> {
                stopPlaying();
            });
        }

        if (!isPlaying) {
            mediaPlayer.start();
            isPlaying = true;
        }
    }

    public void pausePlaying() {
        if (mediaPlayer != null && isPlaying) {
            mediaPlayer.pause();
            isPlaying = false;
        }
    }

    public void stopPlaying() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            isPlaying = false;
        }
    }

    public boolean isPlaying() {
        return isPlaying;
    }

}