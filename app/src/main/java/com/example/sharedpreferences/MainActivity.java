package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textViewName ;
    EditText editTextName ;
    Button buttonSave ;
    Button buttonLoad ;

    public static String SHARED_PREF = "mySharedPreferences" ;
    public static String NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewName = findViewById(R.id.name_tv);
        editTextName = findViewById(R.id.name_et);
        buttonSave = findViewById(R.id.save_btn);
        buttonLoad = findViewById(R.id.load_btn);





        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textViewName.setText(loadDate());
            }
        });


    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF,MODE_PRIVATE) ;
        //private that mean only this app can change the content of this Shared Preferences
        SharedPreferences.Editor editor = sharedPreferences.edit() ;
        Toast.makeText(this,editTextName.getText().toString() , Toast.LENGTH_SHORT).show();
        editor.putString(NAME,editTextName.getText().toString());
        editor.apply();

    }

    String loadDate(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF,MODE_PRIVATE) ;

        return sharedPreferences.getString(NAME,"") ;
        //s1 is the default value                   ^
    }
}