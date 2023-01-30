package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.projet.Adapter.ViewPagerAdapter;
import com.example.projet.joueurs.acmilanJoueurs;
import com.example.projet.joueurs.arsenalJoueurs;
import com.example.projet.joueurs.liverpoolJoueurs;
import com.example.projet.joueurs.psgJoueurs;
import com.example.projet.joueurs.realJoueurs;
import com.example.projet.model.Team;

import java.util.ArrayList;
import java.util.List;

/*Activité des équipes*/
public class teamActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    List<Team> teamList;

    ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        viewPager2=findViewById(R.id.view_pager);
        teamList=new ArrayList<>();
        teamList.add(new Team("Paris-Saint-Germain",R.drawable.psg));
        teamList.add(new Team("Liverpool",R.drawable.liverpool));
        teamList.add(new Team("Arsenal",R.drawable.arsenal));
        teamList.add(new Team("AC Milan",R.drawable.acmilan));
        teamList.add(new Team("Real Madrid",R.drawable.realmadrid));



        adapter=new ViewPagerAdapter(this,teamList);
        viewPager2.setAdapter(adapter);
        viewPager2.setPadding(80,20,80,20);
        viewPager2.setPageTransformer(new MarginPageTransformer(100));


    }
    /*Ouverture de la liste des joueurs correspondant à l'équipe choisie*/
    public void openJoueurs(View v) {
            if(viewPager2.getCurrentItem()==0) {
                Intent intent = new Intent(teamActivity.this, psgJoueurs.class);
                startActivity(intent);
            }

        if(viewPager2.getCurrentItem()==1){
            Intent intent = new Intent(teamActivity.this, liverpoolJoueurs.class);
            startActivity(intent);
        }
        if(viewPager2.getCurrentItem()==2){
            Intent intent = new Intent(teamActivity.this, arsenalJoueurs.class);
            startActivity(intent);
        }
        if(viewPager2.getCurrentItem()==3){
            Intent intent = new Intent(teamActivity.this, acmilanJoueurs.class);
            startActivity(intent);
        }
        if(viewPager2.getCurrentItem()==4){
            Intent intent = new Intent(teamActivity.this, realJoueurs.class);
            startActivity(intent);
        }

        Log.i("CIO", "click");
    }

}