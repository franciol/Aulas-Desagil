package com.example.frana.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.frana.myapplication.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {
    final int[] conti = {0};
    private static final int REQUEST_EXAMPLE = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        final Button mais = (Button) findViewById(R.id.mais);
        final Button menos = (Button) findViewById(R.id.menos);
        final Button zerar = (Button) findViewById(R.id.zerar);
        final Button bonus = (Button) findViewById(R.id.bonus);
        final Button gotoImage = (Button) findViewById(R.id.gotoImage);
        final Button gotoCamera = (Button) findViewById(R.id.camera_bt);
        final Button gotoSMS = (Button) findViewById(R.id.gotoSMS);
        final Button gotoTxt = (Button) findViewById(R.id.gotoTxt);
        final TextView contar = (TextView) findViewById(R.id.contador);



        if ( getIntent().getSerializableExtra("getBack") == null){
            contar.setText(String.format("%d", conti[0]));
        }
        else {
            conti[0] = (int) getIntent().getSerializableExtra("getBack");
            contar.setText(String.format("%d", conti[0]));

        }
        mais.setOnClickListener(new View.OnClickListener() {
            public void  onClick(View v) {
                conti[0]++;
                contar.setText(String.format("%d", conti[0]));

            }
        });
        menos.setOnClickListener(new View.OnClickListener() {
            public void  onClick(View v) {
                conti[0]--;
                contar.setText(String.format("%d", conti[0]));
            }
        });
        zerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conti[0] = 0;
                contar.setText(String.format("%d", conti[0]) );
                    }
                });
        bonus.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                goToActivity2();
            }
        });
        gotoImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gotoActivityImage();
            }
        });
        gotoCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoActivityCamera();
            }
        });
        gotoSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryToGoToSendActivity(v);
            }
        });
        gotoTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoActivityTxt();
            }
        });

    }


    public void goToActivity2(){
        Intent i = new Intent(getApplicationContext(),OtherActivity.class);
        i.putExtra("Int",conti[0]);
        startActivity(i);
    }
    public void gotoActivityImage() {
        Intent o = new Intent(getApplicationContext(),ImageActivity.class);
        startActivity(o);
    }
    public void gotoActivityCamera() {
        Intent i = new Intent(getApplicationContext(),CameraActivity.class);
        startActivity(i);
    }
    public void gotoActivitySMS () {
        Intent i = new Intent(getApplicationContext(),SMSActivity.class);
        startActivity(i);
    }
    public void gotoActivityTxt () {
        Intent i = new Intent(getApplicationContext(),TxtActivity.class);
        startActivity(i);
    }

    public void tryToGoToSendActivity(View view) {
        int permission = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS);

        if(permission == PackageManager.PERMISSION_GRANTED) {
            gotoActivitySMS();
        }
        else {
            String[] permissions = new String[1];
            permissions[0] = Manifest.permission.SEND_SMS;
            ActivityCompat.requestPermissions(MainActivity.this, permissions, REQUEST_EXAMPLE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if(requestCode == REQUEST_EXAMPLE) {
            if(grantResults.length == 0 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast toast = Toast.makeText(this, "Cannot use this application without permission to send SMS!", Toast.LENGTH_SHORT);
                toast.show();
            }
            else {
                gotoActivitySMS();
            }
        }
    }



}
