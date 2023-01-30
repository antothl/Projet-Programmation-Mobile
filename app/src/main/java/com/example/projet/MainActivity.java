package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
/*Activité Principale*/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /*Création du menu*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    /*Pour pouvoir ouvrir l'activité contact*/
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.tiakola:
                Intent intent = new Intent(this, ContactActivity.class);
                startActivity(intent);
                Log.i("CIO", "click");
        }
        return super.onOptionsItemSelected(item);
    }
    /*Fonctions permettant d'ouvrir les différentes activités*/
    public void openQuiz(View v) {
        Intent intent = new Intent(MainActivity.this, quizActivity.class);
        startActivity(intent);
        Log.i("CIO", "click");
    }
    public void openSoundboard(View v) {
        Intent intent = new Intent(MainActivity.this, soundboard.class);
        startActivity(intent);
        Log.i("CIO", "click");
    }

    public void openTeam(View v) {
        Intent intent = new Intent(MainActivity.this, teamActivity.class);
        startActivity(intent);
        Log.i("CIO", "click");
    }
    public void openBalle(View v) {
        Intent intent = new Intent(MainActivity.this, balleActivity.class);
        startActivity(intent);
        Log.i("CIO", "click");
    }
    public void openHistoire(View v) {
        Intent intent = new Intent(MainActivity.this, histoire.class);
        startActivity(intent);
        Log.i("CIO", "click");
    }

    public void openProfil(MenuItem item) {
        Intent intent = new Intent(this, profileActivity.class);
        startActivity(intent);
        Log.i("CIO", "click");
    }
}