package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.projet.data.ContactArrayAdapter;
import com.example.projet.fragments.ContactViewFragment;
import com.example.projet.interfaces.OnClickedItemContactListFragment;
import com.example.projet.fragments.ContactListFragment;

/*Activités des contacts*/
public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        /*Demande d'autorisation d'accès aux contacts*/

        if(ContextCompat.checkSelfPermission(ContactActivity.this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(ContactActivity.this,new String[]{
                    Manifest.permission.READ_CONTACTS
            },100);
        }
    }
    @Override
    public void onStart()
    {
        super.onStart();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction();
        ContactListFragment contactListFragment = (ContactListFragment) fragmentManager.findFragmentById(R.id.ContactListFragment);

        contactListFragment.setOnItemClickListenerContactList(this::onItemClick);
    }

        /*Fonction onItemClick qui se déclenche lorsqu'un contact est selectionné*/
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Log.i("itemClicked", parent.getItemAtPosition(position).toString());

        ContactViewFragment contactViewFragment = (ContactViewFragment) getSupportFragmentManager().findFragmentById(R.id.ContactViewFragment);
        if(contactViewFragment != null)
        {
            contactViewFragment.setPhone(ContactArrayAdapter.getContactAt(parent, position));
        }
        else
        {
            Intent intent = new Intent(this, ViewActivity.class);
            intent.putExtra("contact", (Parcelable) ContactArrayAdapter.getContactAt(parent,position));
            startActivity(intent);
        }
    }

}