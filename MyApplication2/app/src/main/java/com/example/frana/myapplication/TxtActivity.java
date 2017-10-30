package com.example.frana.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by frana on 05/10/2017.
 */

public class TxtActivity extends AppCompatActivity {
    private TextView txt_save;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txt);


        Button save_btn = (Button) findViewById(R.id.Save_txt_btn);
        txt_save = (TextView) findViewById(R.id.txtV_save_txt);

        displayData();
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInfo(v);
            }
        });


    }

    public void saveInfo(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("txt",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username",txt_save.getText().toString());
        editor.apply();

        Toast.makeText(this, "Username Saved!!!",Toast.LENGTH_LONG);
    }
    public void displayData() {
        SharedPreferences sharedPreferences = getSharedPreferences("txt",Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("username","");
        if (name != null) {
            txt_save.setText(name);
        }
    }

}
