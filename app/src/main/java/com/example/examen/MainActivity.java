package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.examen.utils.PreferencesProvider;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nextButton = findViewById(R.id.button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSecoondActivity();
            }
        });

        PreferencesProvider.init(this);
        Log.d(TAG,"Entero -->" + String.valueOf(PreferencesProvider.providePreferences().getInt("entero", 0)));
        PreferencesProvider.providePreferences().edit().putInt("entero", 54).commit();
        Log.d(TAG, String.valueOf("Entero -->" + PreferencesProvider.providePreferences().getInt("entero", 0)));

        PreferencesProvider.providePreferences().edit().putString("text", "Prueva1").commit();
        Log.d(TAG,"String -->" + PreferencesProvider.providePreferences().getString("text", null));

    }
    void openSecoondActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}