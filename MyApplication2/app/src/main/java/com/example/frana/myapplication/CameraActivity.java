package com.example.frana.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

/**
 * Created by frana on 25/09/2017.
 */

public class CameraActivity extends AppCompatActivity {
    private static final int REQUEST_EXAMPLE = 0;

    private File imageFile;
    private ImageView image;


    private void trocar_Imagem() {
        String path = imageFile.getAbsolutePath();
        Bitmap bitmap = BitmapFactory.decodeFile(path);

        if(bitmap != null) {
            image.setImageBitmap(bitmap);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        File dir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        imageFile = new File(dir,"camera.jpg");
        image = (ImageView) findViewById(R.id.imageView2);

        trocar_Imagem();


    }

    public void tryToReplaceImage(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(intent.resolveActivity(getPackageManager()) == null) {
            Toast toast = Toast.makeText(this, "Cannot use this application without access to a camera!", Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            Uri uri = FileProvider.getUriForFile(this, "com.example.frana.myapplication.fileprovider", imageFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            startActivityForResult(intent, REQUEST_EXAMPLE);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_EXAMPLE && resultCode == RESULT_OK) {
            trocar_Imagem();
        }
    }
}
