package com.example.scoutingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final String EXTRA_TEAM = "com.example.scoutingapp.TEAM";
    public final String EXTRA_MATCH = "com.example.scoutingapp.MATCH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, QueryActivity.class);
        EditText editText =  (EditText) findViewById(R.id.editText);
        String team = editText.getText().toString();
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String match = editText2.getText().toString();
        intent.putExtra(EXTRA_TEAM, team);
        intent.putExtra(EXTRA_MATCH, match);
        startActivity(intent);
    }
}
