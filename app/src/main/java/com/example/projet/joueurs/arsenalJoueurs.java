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

public class arsenalJoueurs extends AppCompatActivity {

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
                Toast.makeText(arsenalJoueurs.this, "" + lj, Toast.LENGTH_LONG).show();
            }
        });
    }

    private  List<listejoueurs> getListData() {
        List<listejoueurs> list = new ArrayList<listejoueurs>();
        listejoueurs gardien = new listejoueurs("Ramsdale", "ramsdale", 1, "Aaron");
        listejoueurs def1 = new listejoueurs("White", "white", 4,"Ben");
        listejoueurs def2 = new listejoueurs("Saliba", "saliba", 12,"William");
        listejoueurs def3 = new listejoueurs("Gabriel", "gabriel", 6, "");
        listejoueurs def4 = new listejoueurs("Tomiyasu", "tomiyasu", 18,"Takehiro");
        listejoueurs def5 = new listejoueurs("Partey", "partey", 5,"Thomas");
        listejoueurs mil1 = new listejoueurs("Odegaard", "odegaard", 8, "Martin");
        listejoueurs mil2 = new listejoueurs("Xhaka", "xhaka", 34,"Granit");
        listejoueurs att1 = new listejoueurs("Saka", "saka", 7,"Bukayo");
        listejoueurs att2 = new listejoueurs("Martinelli", "martinelli", 11,"Gabriel");
        listejoueurs att3 = new listejoueurs("Jesus", "jesus", 9,"Gabriel");


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
