## Interface View


<p align="center">
  <table align="center">
  <tr>
  <td><img width="200px"src="https://i.ibb.co/XX0STJ7/Screenshot-2022-02-12-16-22-43-028-com-example-sharedpreferences.jpg" /></td>
  <td><img width="200px"src="https://i.ibb.co/xJyTrSn/Screenshot-2022-02-12-16-22-57-999-com-example-sharedpreferences.jpg" /></td>
  </tr>
  </table>

  

  
</p>



## Java Code

``` java

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

```

## XML

```xml

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">


    <Button
        android:id="@+id/save_btn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Save"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="@id/name_et"
        app:layout_constraintLeft_toRightOf="@id/name_et"

        />
    <EditText
        android:layout_marginTop="50dp"
        android:inputType="textPersonName"
        android:id="@+id/name_et"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="Enter Your Name "
        app:layout_constraintRight_toLeftOf="@id/save_btn"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        />

    <TextView
        android:id="@+id/name_tv"
        android:textSize="20dp"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        android:layout_marginTop="30dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="......."
        app:layout_constraintTop_toBottomOf="@id/name_et"/>

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toBottomOf="@id/name_tv"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        android:layout_marginTop="10dp"
        android:text="Load last name"
        android:id="@+id/load_btn" />



</androidx.constraintlayout.widget.ConstraintLayout>
```
