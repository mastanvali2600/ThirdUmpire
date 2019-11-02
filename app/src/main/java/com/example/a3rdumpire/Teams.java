package com.example.a3rdumpire;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;


public class Teams extends Activity {
    EditText team_one,team_two;
    Button next;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        
        team_one=findViewById(R.id.et_team1);
        team_two=findViewById(R.id.et_team2);
        next=findViewById(R.id.bt_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String temaone=   team_one.getText().toString();
                String teamtwo= team_two.getText().toString();
                if(temaone.isEmpty() || teamtwo.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Enter team name",Toast.LENGTH_LONG).show();
                }else {
                    Intent intent=new Intent(Teams.this,PalyerNames.class);
                    intent.putExtra("firstteamname",temaone);
                    intent.putExtra("secondteamname",teamtwo);
                    startActivity(intent);
                    team_one.setText("");
                    team_two.setText("");
                }
            }
        });

    }
}
