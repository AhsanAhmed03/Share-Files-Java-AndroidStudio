package com.sharefilesandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imageView);

        Bitmap bitmap = ((BitmapDrawable) img.getDrawable()).getBitmap();

        file = new File(String.valueOf(bitmap));
//        FileOutputStream outputStream = null;
//        try {
//            outputStream = new FileOutputStream(file);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            outputStream.flush();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            outputStream.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    }

    public void share_image(View view) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/*");
        Uri uri = FileProvider.getUriForFile(this,"com.sharefilesandroid.fileprovider",file);
        share.putExtra(Intent.EXTRA_STREAM,uri);
        startActivity(Intent.createChooser(share,"Share Image"));
    }
}