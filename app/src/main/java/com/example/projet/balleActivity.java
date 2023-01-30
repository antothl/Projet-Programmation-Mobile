package com.example.projet;

import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.hardware.Sensor;

import com.example.projet.model.jeuBalle;
/*Activité du ballon*/
    public class balleActivity extends Activity {

        private jeuBalle ballView;
        private SensorManager sensorManager = null;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_balle);

            ballView = new jeuBalle( this );
            setContentView( ballView );


            sensorManager = (SensorManager) getSystemService( SENSOR_SERVICE );

        }

        @Override
        protected void onResume() {
            super.onResume();
            sensorManager.registerListener(
                    ballView,
                    sensorManager.getDefaultSensor( Sensor.TYPE_ACCELEROMETER ),
                    SensorManager.SENSOR_DELAY_GAME);
        }

        @Override
        protected void onPause() {
            super.onPause();
            sensorManager.unregisterListener( ballView );
        }
    }