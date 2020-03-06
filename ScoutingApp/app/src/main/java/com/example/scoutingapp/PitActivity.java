package com.example.scoutingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class PitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pit);

    }

    public void generateQR(View view){
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        ArrayList<String> strings;
        strings = bundle.getStringArrayList("strings");
        String team = strings.get(0);
        String match = strings.get(1);
        TextView textView18 = (TextView) findViewById(R.id.textView18);
        textView18.setText(team);
        TextView textView20 = (TextView) findViewById(R.id.textView20);
        textView20.setText(match);
        Button button = (Button) findViewById(R.id.button);

        Intent qrin = new Intent(this, GenerateActivity.class);
        Bundle info = new Bundle();
        ArrayList<String> strings2 = new ArrayList<String>();
        strings2 = (ArrayList<String>) strings.clone();
        info.putStringArrayList("strings2", strings2);
        qrin.putExtra("info", info);
        startActivity(qrin);
    }
}
