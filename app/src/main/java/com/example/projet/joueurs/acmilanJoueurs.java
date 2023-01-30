package com.example.projet.joueurs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.projet.Adapter.CustomListAdapter;
import com.example.projet.ContactActivity;
import com.example.projet.R;
import com.example.projet.model.listejoueurs;

import java.util.ArrayList;
import java.util.List;
/*classe de la liste des joueurs de l'équipe*/
public class acmilanJoueurs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joueur);


        List<listejoueurs> image_details = getListData();
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(this, image_details));

        // When the user clicks on the ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                listejoueurs lj = (listejoueurs) o;
                Toast.makeText(acmilanJoueurs.this, " " + lj, Toast.LENGTH_LONG).show();
            }
        });
    }

    /*remplissage de la liste*/
    private  List<listejoueurs> getListData() {
        List<listejoueurs> list = new ArrayList<listejoueurs>();
        listejoueurs gardien = new listejoueurs("Maignan", "maignan", 16, "Mike");
        listejoueurs def1 = new listejoueurs("Hernandez", "hernandez", 19,"Theo");
        listejoueurs def2 = new listejoueurs("Kjaer", "kjaer", 24,"Simon");
        listejoueurs def3 = new listejoueurs("Tomori", "tomori", 23, "Fikayo");
        listejoueurs def4 = new listejoueurs("Kalulu", "kalulu", 20,"Pierre");
        listejoueurs def5 = new listejoueurs("Bennacer", "bennacer", 4,"Ismael");
        listejoueurs mil1 = new listejoueurs("Tonali", "tonali", 8, "Sandro");
        listejoueurs mil2 = new listejoueurs("Rebic", "rebic", 12,"Ante");
        listejoueurs att1 = new listejoueurs("De Ketelaere", "deke", 90,"Charles");
        listejoueurs att2 = new listejoueurs("Giroud", "giroud", 9,"Olivier");
        listejoueurs att3 = new listejoueurs("Leao", "leao", 17,"Rafael");


        list.add(gardien);
        list.add(def1);
        list.add(def2);
        list.add(def3);
        list.add(def4);
        list.add(def5);
        list.add(mil1);
        list.add(mil2);
        list.add(att1);
        list.add(att2);
        list.add(att3);

        return list;
    }


}