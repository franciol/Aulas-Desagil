package com.example.frana.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by frana on 18/09/2017.
 */

public class OtherActivity extends AppCompatActivity {

    private int lhi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        final TextView aki = (TextView) findViewById(R.id.textView);
        final Button zero = (Button) findViewById(R.id.zerar);
        lhi = (int) getIntent().getSerializableExtra("Int");
        aki.setText("Você ganhou "+lhi+" Hue's");
        zero.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
               gotoActivity1();
            }
        });
    }
    public void gotoActivity1() {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        i.putExtra("getBack",lhi);
        startActivity(i);
    }
}

