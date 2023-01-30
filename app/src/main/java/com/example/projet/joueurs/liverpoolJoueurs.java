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

public class liverpoolJoueurs extends AppCompatActivity {

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
            Toast.makeText(liverpoolJoueurs.this, "" + lj, Toast.LENGTH_LONG).show();
        }
    });
}

    private  List<listejoueurs> getListData() {
        List<listejoueurs> list = new ArrayList<listejoueurs>();
        listejoueurs gardien = new listejoueurs("Alisson", "alisson", 1, "");
        listejoueurs def1 = new listejoueurs("Matip", "matip", 32,"Joel");
        listejoueurs def2 = new listejoueurs("Van Dijk", "vandijk", 4,"Virgil");
        listejoueurs def3 = new listejoueurs("Robertson", "robertson", 26, "Andy");
        listejoueurs def4 = new listejoueurs("Alexander-Arnold", "taa", 66,"Trent");
        listejoueurs def5 = new listejoueurs("Fabinho", "fabinho", 3,"");
        listejoueurs mil1 = new listejoueurs("Alcantara", "alcantara", 6, "Thiago");
        listejoueurs mil2 = new listejoueurs("Henderson", "henderson", 14,"Jordan");
        listejoueurs att1 = new listejoueurs("Salah", "salah", 11,"Mohamed");
        listejoueurs att2 = new listejoueurs("Diaz", "diaz", 23,"Luis");
        listejoueurs att3 = new listejoueurs("Nunez", "nunez", 27,"Darwin");


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