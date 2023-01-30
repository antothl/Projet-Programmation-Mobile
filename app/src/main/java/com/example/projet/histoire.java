package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
/*Activité Histoire*/
public class histoire extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView texte;
    private TextView titre;
    private ImageView image;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_histoire);

        this.seekBar = (SeekBar) findViewById(R.id.seekBar );
        this.texte = (TextView) findViewById(R.id.texte);
        this.titre = (TextView) findViewById(R.id.titre);
        this.image = (ImageView) findViewById(R.id.image);

        /*On règle ici les dimenions de la barre, et sa valeur initiale*/
        this.seekBar.setMax(100);
        this.seekBar.setProgress(0);

        titre.setText("La naissance du football");
        texte.setText("Le football trouve naissance en Angleterre, se présentant comme un nouveau sport collectif. Le premier club non scolaire est le Sheffield United, qui existe encore aujourd'hui.");
        image.setImageResource(R.drawable.naissance);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            /*Changement des contenus lorsque la barre atteint une certaine valeur*/
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if((seekBar.getProgress())>=0){
                    titre.setText("La naissance du football");
                    texte.setText("Le football trouve naissance en Angleterre, se présentant comme un nouveau sport collectif. Le premier club non scolaire est le Sheffield United, qui existe encore aujourd'hui. Vient alors de naître le sport le plus suivi dans l'histoire, qui marquera toutes les générations.");
                    image.setImageResource(R.drawable.naissance);

                }
                if((seekBar.getProgress())>=20){
                    titre.setText("Le Brésil, le plus grand pays du Football ?");
                    texte.setText("Le Brésil est actuellement reconnu comme étant l'un des berceaux du football moderne, tant par les grands joueurs y provenant que par la place que le football occupe en son sein. Sacré de 5 Coupe du Monde, le pays est le plus titré dans la compétition. Parmis les légendes brésiliennes, on peut notamment citer Neymar Jr, Ronaldinho, Ronaldo ou encore Roberto Carlos.");
                    image.setImageResource(R.drawable.bresil);

                }
                if((seekBar.getProgress())>=40){
                    titre.setText("Lionel Messi, le GOAT");
                    texte.setText(("S'il y a bien un joueur que l'histoire retiendra, c'est lui. Lionel Messi, joueur argentin emblématique du FC Barcelone est sans aucun doute le meilleur joueur de l'histoire de ce sport. Ses qualités balle aux pieds, ses dribbles, et sa qualité de frappe et de passe font de  lui une des plus grandes légendes tous sports confondus."));
                    image.setImageResource(R.drawable.messih);
                }
                if((seekBar.getProgress())>=60){
                    titre.setText("La Ligue des Champions, la compétitions des clubs");
                    texte.setText("Se déroulant chaque année, cette compétition entre clubs européens est la plus prestigieuse à ce jour. Par son format, les scénarios les plus rocambolesques sont de mises, rendant cette compétition très attractive. Le Real Madrid en est l'équipe la plus victorieuse avec 14 éditions remportées.");
                    image.setImageResource(R.drawable.ldc);
                }
                if((seekBar.getProgress())>=80){
                    titre.setText("Et la France dans tout ça ?");
                    texte.setText(("Par ses talents et son palmarès, la France possède aujourd'hui une place majeure dans le football mondial. Michel PLatini, Zinedine Zidane, Kylian Mbappé : tels sont les joueurs qui ont marqué l'histoire où là marqueront. A l'échelle internationale, la France possède un gros palmarès : 2 Coupes de l'UEFA, ainsi que 2 Coupe du Monde, et peut-être, bientôt, une troisième."));
                    image.setImageResource(R.drawable.edf);
                }

            }

            /*méthodes obligatoires pour une seekBar*/
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




    }


}