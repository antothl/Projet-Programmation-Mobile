package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
/*ActivitéSoundboard*/
public class soundboard extends AppCompatActivity {

    private MediaPlayer son; /*initialisation du mediaPlayer*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soundboard);
    }
    /*méthodes appelées lorsque le bouton est pressé*/
    public void Francais(View v) {
        son=MediaPlayer.create(soundboard.this, R.raw.francais);
        son.start();
    }
    public void Siuu(View v) {
        son=MediaPlayer.create(soundboard.this, R.raw.siuu);
        son.start();
    }
    public void casentbon(View v) {
        son=MediaPlayer.create(soundboard.this, R.raw.casentbon);
        son.start();
    }
    public void Viry(View v) {
        son=MediaPlayer.create(soundboard.this, R.raw.virychatillon);
        son.start();
    }
    public void lefootilachange(View v) {
        son=MediaPlayer.create(soundboard.this, R.raw.changer);
        son.start();
    }
    public void irecuptheball(View v){
        son=MediaPlayer.create(soundboard.this, R.raw.irecuptheball);
    }

}