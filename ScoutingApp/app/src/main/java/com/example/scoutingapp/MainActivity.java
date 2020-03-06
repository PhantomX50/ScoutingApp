package com.example.scoutingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TEAM = "com.example.scoutingapp.TEAM";
    public static final String EXTRA_MATCH = "com.example.scoutingapp.MATCH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        Intent qintent = new Intent(this, QueryActivity.class);
        Intent pitent = new Intent (this, PitActivity.class);
        Bundle bundle = new Bundle();
        ArrayList<String> strings = new ArrayList<String>();

        EditText editText =  (EditText) findViewById(R.id.editText);
        String team = editText.getText().toString();
        if(team.isEmpty()) {
            team = "0";
        }
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String match = editText2.getText().toString();
        if(match.isEmpty()) {
            match = "0";
        }
        CheckBox checkbox = (CheckBox) findViewById(R.id.checkBox);
        boolean pitEnable = checkbox.isChecked();
        strings.add(team);
        strings.add(match);
        bundle.putStringArrayList("strings", strings);
        if (pitEnable){
            pitent.putExtra("bundle",bundle);
            startActivity(pitent);
        }
        else {
            qintent.putExtra("bundle", bundle);
            startActivity(qintent);
        }
    }
}
