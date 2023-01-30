package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;

import com.example.projet.data.Contact;
import com.example.projet.fragments.ContactViewFragment;

import java.util.Objects;


public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
    }
    @Override
    public void onStart()
    {
        super.onStart();

        Bundle bundle = getIntent().getExtras();
        Contact contact = bundle.getParcelable("contact");
        ((ContactViewFragment) Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.ContactViewFragment))).setPhone(contact);



    }

}