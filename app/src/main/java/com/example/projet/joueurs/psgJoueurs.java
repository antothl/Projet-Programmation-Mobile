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

public class psgJoueurs extends AppCompatActivity {

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
                Toast.makeText(psgJoueurs.this, ""+lj, Toast.LENGTH_LONG).show();
            }
        });
    }

    private  List<listejoueurs> getListData() {
        List<listejoueurs> list = new ArrayList<listejoueurs>();
        listejoueurs gardien = new listejoueurs("Donnarumma", "donnarumma", 99, "Gianluigi");
        listejoueurs def1 = new listejoueurs("Kimpembe", "kimpembe", 3,"Presnel");
        listejoueurs def2 = new listejoueurs("Marquinhos", "marquinhos", 5,"Marco");
        listejoueurs def3 = new listejoueurs("Ramos", "ramos", 4, "Sergio");
        listejoueurs def4 = new listejoueurs("Mendes", "nuno", 25,"Nuno");
        listejoueurs def5 = new listejoueurs("Hakimi", "hakimi", 5,"Achraf");
        listejoueurs mil1 = new listejoueurs("Verratti", "verratti", 6, "Marco");
        listejoueurs mil2 = new listejoueurs("Vitinha", "vitinha", 17,"Vitor");
        listejoueurs att1 = new listejoueurs("Neymar Jr", "neymar", 10," ");
        listejoueurs att2 = new listejoueurs("Mbappé", "mbappe", 7,"Kylian");
        listejoueurs att3 = new listejoueurs("Messi", "messi", 30,"Lionel");


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