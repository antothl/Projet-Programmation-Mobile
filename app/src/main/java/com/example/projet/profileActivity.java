package com.example.projet;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class profileActivity extends AppCompatActivity {

    ImageView imageView;
    EditText username;
    EditText prenomUser;
    EditText userdate;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        imageView=findViewById(R.id.photoprofil);
        sharedPreferences=this.getPreferences(Context.MODE_PRIVATE);

        /*demande d'autorisation pour la caméra*/
        if(ContextCompat.checkSelfPermission(profileActivity.this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(profileActivity.this,new String[]{
                Manifest.permission.CAMERA
            },100);
        }
        username=findViewById(R.id.username);
        prenomUser=findViewById(R.id.prenomUser);
        userdate=findViewById(R.id.userdate);

        /*initialisation des sharedPreferences*/
        if(sharedPreferences!=null) {
            username.setText(sharedPreferences.getString("Nom","Da Silva Santos"));
            prenomUser.setText(sharedPreferences.getString("Prenom","Neymar"));
            userdate.setText(sharedPreferences.getString("Date","05/02/1992"));

        }
    }

    public void openCamera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100) {
            assert data != null;
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }
    }
    public void validerProfil(View Button){
        String nom = username.getText().toString();
        String prenom = prenomUser.getText().toString();
        String date = userdate.getText().toString();

        /*enregistrement dans les sharedPreferences*/
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Nom", nom);
        editor.putString("Prenom", prenom);
        editor.putString("Date", date);

        editor.apply();
    }

}