package com.example.projet.joueurs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.projet.ContactActivity;
import com.example.projet.R;
import com.example.projet.model.listejoueurs;
import com.example.projet.Adapter.CustomListAdapter;
import java.util.ArrayList;
import java.util.List;

public class realJoueurs extends AppCompatActivity {

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
                Toast.makeText(realJoueurs.this, ""+ lj, Toast.LENGTH_LONG).show();
            }
        });
    }

    private  List<listejoueurs> getListData() {
        List<listejoueurs> list = new ArrayList<listejoueurs>();
        listejoueurs gardien = new listejoueurs("Courtois", "courtois", 1, "Thibaut");
        listejoueurs def1 = new listejoueurs("Mendy", "mendy", 32,"Ferland");
        listejoueurs def2 = new listejoueurs("Alaba", "alaba", 4,"David");
        listejoueurs def3 = new listejoueurs("Militao", "militao", 26, "Eder");
        listejoueurs def4 = new listejoueurs("Carvajal", "carvajal", 66,"David");
        listejoueurs def5 = new listejoueurs("Tchouaméni", "tchouameni", 3,"Aurélien");
        listejoueurs mil1 = new listejoueurs("Modric", "modric", 10, "Lucas");
        listejoueurs mil2 = new listejoueurs("Kroos", "kroos", 8,"Tony");
        listejoueurs att1 = new listejoueurs("Vinicius Jr", "vinicius", 11,"");
        listejoueurs att2 = new listejoueurs("Rodrygo", "rodrygo", 23,"");
        listejoueurs att3 = new listejoueurs("Benzema", "benzema", 9,"Karim");


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