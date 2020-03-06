package com.example.scoutingapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class GenerateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);
        Intent intent = getIntent();
        Bundle input = intent.getBundleExtra("info");
        //String longinput = input.getStringArrayList("strings2");
        Bitmap bitmap;

        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        TextView textViewqr = (TextView) findViewById(R.id.textViewqr);

        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int width = point.x;
        int height = point.y;
        int smallerdimension = Math.max(width, height);
        smallerdimension = smallerdimension * 3 / 4;

        QRGEncoder qrgEncoder = new QRGEncoder(
                input.getStringArrayList("strings2").toString(), null,
                QRGContents.Type.TEXT,
                smallerdimension);
        try {
            bitmap = qrgEncoder.encodeAsBitmap();
            imageView.setImageBitmap(bitmap);
        }   catch (WriterException e){
            Log.v("GenerateQRCode", e.toString());
        }

    }
}
