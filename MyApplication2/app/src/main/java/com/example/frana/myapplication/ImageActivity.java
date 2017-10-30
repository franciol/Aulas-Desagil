package com.example.frana.myapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewAnimator;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by frana on 22/09/2017.
 */

public class ImageActivity extends AppCompatActivity {
    MediaPlayer mysound;
    int[] images = {R.drawable.gato,R.drawable.cao,R.drawable.dogo};
    private ViewAnimator VF;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        mysound = MediaPlayer.create(this,R.raw.hooked);
        VF = (ViewAnimator) findViewById(R.id.viewAnimator);
        Button button = (Button) findViewById(R.id.returnMain);
        Button change = (Button) findViewById(R.id.changeIm);
        mysound.start();

        for(int i=0;i<images.length;i++) {
            GifImageView imageView = new GifImageView(getApplicationContext());
            imageView.setImageResource(images[i]);
            VF.addView(imageView);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMain();
            }
        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            VF.showNext();
            }
        });
    }


    private void goToMain() {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        mysound.stop();
        startActivity(i);
    }
}
