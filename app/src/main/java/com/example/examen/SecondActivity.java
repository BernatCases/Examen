package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.example.examen.databinding.ActivitySecondBinding;
import com.example.examen.utils.PreferencesProvider;
import com.example.examen.viewmodel.SecondViewModel;

public class SecondActivity extends AppCompatActivity {
    private SecondViewModel secondViewModel;
    private ActivitySecondBinding activitySecondBinding;
    private String TAG = "MainTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        secondViewModel = new SecondViewModel();
        initDataBinding();

        Button enter = findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence textError = "Torna a introduir";
                CharSequence textCorrecte = "Perfecte";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, textCorrecte, duration);
                toast.show();


            }
        });

        Button fragment = findViewById(R.id.button_fragment);
        fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment();
            }
        });

        PreferencesProvider.providePreferences().edit().putString("text", "Prueva2").commit();
        Log.d(TAG,"String -->" + PreferencesProvider.providePreferences().getString("text", null));

        PreferencesProvider.providePreferences().edit().putInt("entero", 23).commit();
        Log.d(TAG, String.valueOf("Entero -->" + PreferencesProvider.providePreferences().getInt("entero", 0)));


        secondViewModel.getEmailLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d(TAG, "getEmail -->" + s);
            }
        });
    }


    private  void initDataBinding(){
        activitySecondBinding = DataBindingUtil.setContentView(this,R.layout.activity_second);
        activitySecondBinding.setSecondViewModel(secondViewModel);
        activitySecondBinding.setLifecycleOwner(this);
    }

    void showFragment(){
        final Dialog dialog = new Dialog(SecondActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_final);
        dialog.getWindow().setGravity(Gravity.TOP);

        Button exit = dialog.findViewById(R.id.exit);
        Button inici = dialog.findViewById(R.id.inici);

        exit.setOnClickListener(view -> {
            dialog.dismiss();
        });
        inici.setOnClickListener(view -> {
            openMainActivity();
        });

        dialog.show();

    }

    void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


}