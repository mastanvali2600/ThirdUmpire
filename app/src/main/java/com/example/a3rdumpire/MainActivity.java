package com.example.a3rdumpire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button create_button, join_button;
    Spinner game_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        create_button = findViewById(R.id.bt_creatematch);
        join_button = findViewById(R.id.bt_join_match);
        game_type = (Spinner) findViewById(R.id.spineer_type);
        game_type.setOnItemSelectedListener(new CustomOnItemClickListener());
        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Teams.class);
                startActivity(intent);
            }
        });
        join_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public class CustomOnItemClickListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(getApplicationContext(),"Game Type :" + adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_LONG).show();
            if (adapterView.getItemAtPosition(i).toString().equalsIgnoreCase("Online")) {
                join_button.setVisibility(View.VISIBLE);
                create_button.setVisibility(View.VISIBLE);
                join_button.setClickable(false);
                create_button.setClickable(false);

            }else if(adapterView.getItemAtPosition(i).toString().equalsIgnoreCase("Offline")){
             create_button.setVisibility(View.VISIBLE);
             join_button.setVisibility(View.INVISIBLE);
             create_button.setClickable(true);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }


}



