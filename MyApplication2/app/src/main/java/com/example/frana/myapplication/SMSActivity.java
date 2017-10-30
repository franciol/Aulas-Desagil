package com.example.frana.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by frana on 25/09/2017.
 */

public class SMSActivity extends AppCompatActivity {
    private EditText number;
    private EditText message;
    private Button bt_sms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        number = (EditText) findViewById(R.id.editNumber);
        message = (EditText) findViewById(R.id.editSMS);
        bt_sms = (Button) findViewById(R.id.sms__Bt);

        bt_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v);
            }
        });



    }

    public void sendMessage(View view) {
        SmsManager manager = SmsManager.getDefault();

        String numbers = number.getText().toString();
        String messages = message.getText().toString();

        try {
            manager.sendTextMessage(numbers, null, messages, null, null);

            Toast toast = Toast.makeText(this, "Message sent to number!", Toast.LENGTH_SHORT);
            toast.show();
        }
        catch(IllegalArgumentException exception) {
            Log.e("SendActivity", "number or message empty");
        }
    }
}
