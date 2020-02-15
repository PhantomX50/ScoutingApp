package com.example.scoutingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class QueryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        Intent intent = getIntent();
        String team = intent.getStringExtra(MainActivity.EXTRA_TEAM);
        String match = intent.getStringExtra(MainActivity.EXTRA_MATCH);

        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setText(team);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(match);

        
    }
}
