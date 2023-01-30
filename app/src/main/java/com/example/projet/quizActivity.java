package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projet.model.choix;
/*Activité Quiz*/

public class quizActivity extends AppCompatActivity implements View.OnClickListener {


    TextView nb_questions;
    TextView question;
    TextView record;
    Button repA,repB,repC,repD;
    Button valider;
    int totalQuestion = choix.question.length;
    int curentQuestionIndex=0, score=0,highscore=0;
    String selectreponse="";
    private MediaPlayer son;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        SharedPreferences sharedPreferences=this.getPreferences(Context.MODE_PRIVATE); /*Utilisation des SharedPreferences*/
        highscore=sharedPreferences.getInt("recordP", 0);


        repA=findViewById(R.id.repA);
        repB=findViewById(R.id.repB);
        repC=findViewById(R.id.repC);
        repD=findViewById(R.id.repD);

        valider=findViewById(R.id.valider);
        nb_questions=findViewById(R.id.nb_questions);
        question=findViewById(R.id.question);
        record=findViewById(R.id.record);
        record.setText("Votre record : "+(highscore));

        repA.setOnClickListener(this);
        repB.setOnClickListener(this);
        repC.setOnClickListener(this);
        repD.setOnClickListener(this);

        valider.setOnClickListener(this);

    loadNewQuestion();/*Fonction permettant d'appeler de changer de question*/

    }
    /*Fonction OnClick, pour sélectionner et valider les réponses*/
    @Override
    public void onClick(View view){

        repA.setBackgroundColor(Color.BLUE);
        repB.setBackgroundColor(Color.BLUE);
        repC.setBackgroundColor(Color.BLUE);
        repD.setBackgroundColor(Color.BLUE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.valider){
            if(selectreponse.equals(choix.reponse[curentQuestionIndex])){
                score++;
                Siuu();
            }
            else{
                mauvais();
            }

            curentQuestionIndex++;
            loadNewQuestion();

        }else{
            selectreponse = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
    }

    void loadNewQuestion(){
        if(curentQuestionIndex == totalQuestion){
            finishQuizz();
            return;
        }


        question.setText(choix.question[curentQuestionIndex]);
        repA.setText(choix.choix[curentQuestionIndex][0]);
        repB.setText(choix.choix[curentQuestionIndex][1]);
        repC.setText(choix.choix[curentQuestionIndex][2]);
        repD.setText(choix.choix[curentQuestionIndex][3]);

    }
    @SuppressLint("SetTextI18n")
    void finishQuizz(){
        String statut;



        if(score==totalQuestion){
            statut="Gagné";
        }else{
            statut="Perdu";
        }
        new AlertDialog.Builder(this)
                .setTitle(statut)
                .setMessage("Votre score est de "+score+" sur "+ totalQuestion)
                .setPositiveButton("Recommencer",((dialogInterface, i) -> recommencer()))
                .setNegativeButton("Quitter", (((dialogInterface, i) -> quitter())))
                .setCancelable(false)
                .show();
        if(score>highscore){
            this.highscore=this.score;
        }
        /*Enregistrement du score*/
        SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("recordP",this.highscore);
        Log.i("okd", ""+highscore);
        editor.apply();

    }
    void recommencer(){
        score = 0;
        curentQuestionIndex=0;
        loadNewQuestion();
    }
    void quitter(){
            Intent intent = new Intent(quizActivity.this, MainActivity.class);
            startActivity(intent);
    }
    /*Sons déclenchés lors de la validation d'une réponse*/
    public void Siuu() {
        son= MediaPlayer.create(quizActivity.this, R.raw.siu);
        son.start();
    }
    public void mauvais() {
        son= MediaPlayer.create(quizActivity.this, R.raw.mauvais);
        son.start();
    }

}