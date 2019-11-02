package com.example.a3rdumpire;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class PalyerNames extends Activity {
    TextView team_one_name;
    String firstteamname, secondteamname;
    Button saveplayers;
    TextView py1, py2, py3, py4, py5, py6, py7, py8, py9, py10, py11, py12;
    EditText et_py1, et_py2, et_py3, et_py4, et_py5, et_py6, et_py7, et_py8, et_py9, et_py10, et_py11, et_py12;
    Spinner teamcapacity;
    SQLiteDatabase sqLiteDatabase;
    String sqlitequery;
    String clicked;
    String second="false";
    static String first = "false";
    static int i=0;
    String et1_value, et2_value, et3_value, et4_value, et5_value, et6_value, et7_value, et8_value, et9_value, et10_value, et11_value, et12_value;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playernames);

        team_one_name = findViewById(R.id.tv_team1_name);
        if (first.equalsIgnoreCase("false")) {
            firstteamname = getIntent().getStringExtra("firstteamname").toString();
            team_one_name.setText(firstteamname);
        } else {
            secondteamname = getIntent().getStringExtra("secondteamname").toString();
            team_one_name.setText(secondteamname);
        }

        py1 = findViewById(R.id.tv_player1);
        py2 = findViewById(R.id.tv_player2);
        py3 = findViewById(R.id.tv_player3);
        py4 = findViewById(R.id.tv_player4);
        py5 = findViewById(R.id.tv_player5);
        py6 = findViewById(R.id.tv_player6);
        py7 = findViewById(R.id.tv_player7);
        py8 = findViewById(R.id.tv_player8);
        py9 = findViewById(R.id.tv_player9);
        py10 = findViewById(R.id.tv_player10);
        py11 = findViewById(R.id.tv_player11);
        py12 = findViewById(R.id.tv_player12);

        et_py1 = findViewById(R.id.et_player1);
        et_py2 = findViewById(R.id.et_player2);
        et_py3 = findViewById(R.id.et_player3);
        et_py4 = findViewById(R.id.et_player4);
        et_py5 = findViewById(R.id.et_player5);
        et_py6 = findViewById(R.id.et_player6);
        et_py7 = findViewById(R.id.et_player7);
        et_py8 = findViewById(R.id.et_player8);
        et_py9 = findViewById(R.id.et_player9);
        et_py10 = findViewById(R.id.et_player10);
        et_py11 = findViewById(R.id.et_player11);
        et_py12 = findViewById(R.id.et_player12);


        teamcapacity = (Spinner) findViewById(R.id.spinner_teamcapacity);

        teamcapacity.setOnItemSelectedListener(new TeamCapacityListner());


        saveplayers = findViewById(R.id.bt_save);
        saveplayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                second="true";
                et1_value = et_py1.getText().toString();
                et2_value = et_py2.getText().toString();
                et3_value = et_py3.getText().toString();
                et4_value = et_py4.getText().toString();
                et5_value = et_py5.getText().toString();
                et6_value = et_py6.getText().toString();
                et7_value = et_py7.getText().toString();
                et8_value = et_py8.getText().toString();
                et9_value = et_py9.getText().toString();
                et10_value = et_py10.getText().toString();
                et11_value = et_py11.getText().toString();
                et12_value = et_py12.getText().toString();

                if (clicked.equalsIgnoreCase("one")) {
                    if (et1_value.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Please Enter Player Name", Toast.LENGTH_LONG).show();
                    } else {
                        DBcreate();
                        SubmitDataToSqlite();
                    }

                } else if (clicked.equalsIgnoreCase("two")) {
                    if (et1_value.isEmpty() || et2_value.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Please Enter Player Name", Toast.LENGTH_LONG).show();
                    } else {
                        DBcreate();
                        SubmitDataToSqlite();
                    }

                } else if (clicked.equalsIgnoreCase("three")) {
                    if (et1_value.isEmpty() || et2_value.isEmpty() || et3_value.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Please Enter Player Name", Toast.LENGTH_LONG).show();
                    } else {
                        DBcreate();
                        SubmitDataToSqlite();
                    }

                } else if (clicked.equalsIgnoreCase("four")) {
                    if (et1_value.isEmpty() || et2_value.isEmpty() || et3_value.isEmpty()
                            || et4_value.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Please Enter Player Name", Toast.LENGTH_LONG).show();
                    } else {
                        DBcreate();
                        SubmitDataToSqlite();
                    }

                } else if (clicked.equalsIgnoreCase("five")) {
                    if (et1_value.isEmpty() || et2_value.isEmpty() || et3_value.isEmpty()
                            || et4_value.isEmpty() || et5_value.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Please Enter Player Name", Toast.LENGTH_LONG).show();
                    } else {
                        DBcreate();
                        SubmitDataToSqlite();
                    }

                } else if (clicked.equalsIgnoreCase("six")) {
                    if (et1_value.isEmpty() || et2_value.isEmpty() || et3_value.isEmpty()
                            || et4_value.isEmpty() || et5_value.isEmpty() || et6_value.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Please Enter Player Name", Toast.LENGTH_LONG).show();
                    } else {
                        DBcreate();
                        SubmitDataToSqlite();
                    }

                } else if (clicked.equalsIgnoreCase("seven")) {

                    if (et1_value.isEmpty() || et2_value.isEmpty() || et3_value.isEmpty()
                            || et4_value.isEmpty() || et5_value.isEmpty() || et6_value.isEmpty() || et7_value.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Please Enter Player Name", Toast.LENGTH_LONG).show();
                    } else {
                        DBcreate();
                        SubmitDataToSqlite();
                    }

                } else if (clicked.equalsIgnoreCase("eight")) {

                    if (et1_value.isEmpty() || et2_value.isEmpty() || et3_value.isEmpty()
                            || et4_value.isEmpty() || et5_value.isEmpty() || et6_value.isEmpty() || et7_value.isEmpty() || et8_value.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Please Enter Player Name", Toast.LENGTH_LONG).show();
                    } else {
                        DBcreate();
                        SubmitDataToSqlite();
                    }
                } else if (clicked.equalsIgnoreCase("nine")) {
                    if (et1_value.isEmpty() || et2_value.isEmpty() || et3_value.isEmpty()
                            || et4_value.isEmpty() || et5_value.isEmpty() || et6_value.isEmpty() || et7_value.isEmpty() || et8_value.isEmpty() || et9_value.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Please Enter Player Name", Toast.LENGTH_LONG).show();
                    } else {
                        DBcreate();
                        SubmitDataToSqlite();
                    }


                } else if (clicked.equalsIgnoreCase("ten")) {
                    if (et1_value.isEmpty() || et2_value.isEmpty() || et3_value.isEmpty()
                            || et4_value.isEmpty() || et5_value.isEmpty() || et6_value.isEmpty() || et7_value.isEmpty() || et8_value.isEmpty() || et9_value.isEmpty()
                            || et10_value.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Please Enter Player Name", Toast.LENGTH_LONG).show();
                    } else {
                        DBcreate();
                        SubmitDataToSqlite();
                    }

                } else if (clicked.equalsIgnoreCase("eleven")) {
                    if (et1_value.isEmpty() || et2_value.isEmpty() || et3_value.isEmpty()
                            || et4_value.isEmpty() || et5_value.isEmpty() || et6_value.isEmpty() || et7_value.isEmpty() || et8_value.isEmpty() || et9_value.isEmpty()
                            || et10_value.isEmpty() || et11_value.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Please Enter Player Name", Toast.LENGTH_LONG).show();
                    } else {
                        DBcreate();
                        SubmitDataToSqlite();
                    }
                } else if (clicked.equalsIgnoreCase("twelve")) {
                    if (et1_value.isEmpty() || et2_value.isEmpty() || et3_value.isEmpty()
                            || et4_value.isEmpty() || et5_value.isEmpty() || et6_value.isEmpty() || et7_value.isEmpty() || et8_value.isEmpty() || et9_value.isEmpty()
                            || et10_value.isEmpty() || et11_value.isEmpty() || et12_value.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Please Enter Player Name", Toast.LENGTH_LONG).show();
                    } else {
                        DBcreate();
                        SubmitDataToSqlite();
                    }
                }
                et_py1.setText("");
                et_py2.setText("");
                et_py3.setText("");
                et_py4.setText("");
                et_py5.setText("");
                et_py6.setText("");
                et_py7.setText("");
                et_py8.setText("");
                et_py9.setText("");
                et_py10.setText("");
                et_py11.setText("");
                et_py12.setText("");
            }
        });


    }

    class TeamCapacityListner implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            adapterView.getItemAtPosition(i);
            if (adapterView.getItemAtPosition(i).toString().equalsIgnoreCase("1")) {
                selectedOne();
            } else if (adapterView.getItemAtPosition(i).toString().equalsIgnoreCase("2")) {
                selectedTwo();
            } else if (adapterView.getItemAtPosition(i).toString().equalsIgnoreCase("3")) {
                selectedThree();
            } else if (adapterView.getItemAtPosition(i).toString().equalsIgnoreCase("4")) {
                selectedFour();
            } else if (adapterView.getItemAtPosition(i).toString().equalsIgnoreCase("5")) {
                selectedFive();
            } else if (adapterView.getItemAtPosition(i).toString().equalsIgnoreCase("6")) {
                selectedSix();
            } else if (adapterView.getItemAtPosition(i).toString().equalsIgnoreCase("7")) {
                selectedSeven();
            } else if (adapterView.getItemAtPosition(i).toString().equalsIgnoreCase("8")) {
                selectedEight();
            } else if (adapterView.getItemAtPosition(i).toString().equalsIgnoreCase("9")) {
                selectedNine();
            } else if (adapterView.getItemAtPosition(i).toString().equalsIgnoreCase("10")) {
                selectedTen();
            } else if (adapterView.getItemAtPosition(i).toString().equalsIgnoreCase("11")) {
                selectedEleven();
            } else if (adapterView.getItemAtPosition(i).toString().equalsIgnoreCase("12")) {
                selectedTwelve();
            } else {

            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

    public void selectedOne() {
        clicked = "one";
        py1.setVisibility(View.VISIBLE);
        py2.setVisibility(View.INVISIBLE);
        py3.setVisibility(View.INVISIBLE);
        py4.setVisibility(View.INVISIBLE);
        py5.setVisibility(View.INVISIBLE);
        py6.setVisibility(View.INVISIBLE);
        py7.setVisibility(View.INVISIBLE);
        py8.setVisibility(View.INVISIBLE);
        py9.setVisibility(View.INVISIBLE);
        py10.setVisibility(View.INVISIBLE);
        py11.setVisibility(View.INVISIBLE);
        py12.setVisibility(View.INVISIBLE);

        et_py1.setVisibility(View.VISIBLE);
        et_py2.setVisibility(View.INVISIBLE);
        et_py3.setVisibility(View.INVISIBLE);
        et_py4.setVisibility(View.INVISIBLE);
        et_py5.setVisibility(View.INVISIBLE);
        et_py6.setVisibility(View.INVISIBLE);
        et_py7.setVisibility(View.INVISIBLE);
        et_py8.setVisibility(View.INVISIBLE);
        et_py9.setVisibility(View.INVISIBLE);
        et_py10.setVisibility(View.INVISIBLE);
        et_py11.setVisibility(View.INVISIBLE);
        et_py12.setVisibility(View.INVISIBLE);

    }

    public void selectedTwo() {
        clicked = "Two";
        py1.setVisibility(View.VISIBLE);
        py2.setVisibility(View.VISIBLE);
        py3.setVisibility(View.INVISIBLE);
        py4.setVisibility(View.INVISIBLE);
        py5.setVisibility(View.INVISIBLE);
        py6.setVisibility(View.INVISIBLE);
        py7.setVisibility(View.INVISIBLE);
        py8.setVisibility(View.INVISIBLE);
        py9.setVisibility(View.INVISIBLE);
        py10.setVisibility(View.INVISIBLE);
        py11.setVisibility(View.INVISIBLE);
        py12.setVisibility(View.INVISIBLE);

        et_py1.setVisibility(View.VISIBLE);
        et_py2.setVisibility(View.VISIBLE);
        et_py3.setVisibility(View.INVISIBLE);
        et_py4.setVisibility(View.INVISIBLE);
        et_py5.setVisibility(View.INVISIBLE);
        et_py6.setVisibility(View.INVISIBLE);
        et_py7.setVisibility(View.INVISIBLE);
        et_py8.setVisibility(View.INVISIBLE);
        et_py9.setVisibility(View.INVISIBLE);
        et_py10.setVisibility(View.INVISIBLE);
        et_py11.setVisibility(View.INVISIBLE);
        et_py12.setVisibility(View.INVISIBLE);
    }

    public void selectedThree() {
        clicked = "Three";
        py1.setVisibility(View.VISIBLE);
        py2.setVisibility(View.VISIBLE);
        py3.setVisibility(View.VISIBLE);
        py4.setVisibility(View.INVISIBLE);
        py5.setVisibility(View.INVISIBLE);
        py6.setVisibility(View.INVISIBLE);
        py7.setVisibility(View.INVISIBLE);
        py8.setVisibility(View.INVISIBLE);
        py9.setVisibility(View.INVISIBLE);
        py10.setVisibility(View.INVISIBLE);
        py11.setVisibility(View.INVISIBLE);
        py12.setVisibility(View.INVISIBLE);

        et_py1.setVisibility(View.VISIBLE);
        et_py2.setVisibility(View.VISIBLE);
        et_py3.setVisibility(View.VISIBLE);
        et_py4.setVisibility(View.INVISIBLE);
        et_py5.setVisibility(View.INVISIBLE);
        et_py6.setVisibility(View.INVISIBLE);
        et_py7.setVisibility(View.INVISIBLE);
        et_py8.setVisibility(View.INVISIBLE);
        et_py9.setVisibility(View.INVISIBLE);
        et_py10.setVisibility(View.INVISIBLE);
        et_py11.setVisibility(View.INVISIBLE);
        et_py12.setVisibility(View.INVISIBLE);
    }

    public void selectedFour() {
        clicked = "four";
        py1.setVisibility(View.VISIBLE);
        py2.setVisibility(View.VISIBLE);
        py3.setVisibility(View.VISIBLE);
        py4.setVisibility(View.VISIBLE);
        py5.setVisibility(View.INVISIBLE);
        py6.setVisibility(View.INVISIBLE);
        py7.setVisibility(View.INVISIBLE);
        py8.setVisibility(View.INVISIBLE);
        py9.setVisibility(View.INVISIBLE);
        py10.setVisibility(View.INVISIBLE);
        py11.setVisibility(View.INVISIBLE);
        py12.setVisibility(View.INVISIBLE);

        et_py1.setVisibility(View.VISIBLE);
        et_py2.setVisibility(View.VISIBLE);
        et_py3.setVisibility(View.VISIBLE);
        et_py4.setVisibility(View.VISIBLE);
        et_py5.setVisibility(View.INVISIBLE);
        et_py6.setVisibility(View.INVISIBLE);
        et_py7.setVisibility(View.INVISIBLE);
        et_py8.setVisibility(View.INVISIBLE);
        et_py9.setVisibility(View.INVISIBLE);
        et_py10.setVisibility(View.INVISIBLE);
        et_py11.setVisibility(View.INVISIBLE);
        et_py12.setVisibility(View.INVISIBLE);
    }

    public void selectedFive() {
        clicked = "five";
        py1.setVisibility(View.VISIBLE);
        py2.setVisibility(View.VISIBLE);
        py3.setVisibility(View.VISIBLE);
        py4.setVisibility(View.VISIBLE);
        py5.setVisibility(View.VISIBLE);
        py6.setVisibility(View.INVISIBLE);
        py7.setVisibility(View.INVISIBLE);
        py8.setVisibility(View.INVISIBLE);
        py9.setVisibility(View.INVISIBLE);
        py10.setVisibility(View.INVISIBLE);
        py11.setVisibility(View.INVISIBLE);
        py12.setVisibility(View.INVISIBLE);

        et_py1.setVisibility(View.VISIBLE);
        et_py2.setVisibility(View.VISIBLE);
        et_py3.setVisibility(View.VISIBLE);
        et_py4.setVisibility(View.VISIBLE);
        et_py5.setVisibility(View.VISIBLE);
        et_py6.setVisibility(View.INVISIBLE);
        et_py7.setVisibility(View.INVISIBLE);
        et_py8.setVisibility(View.INVISIBLE);
        et_py9.setVisibility(View.INVISIBLE);
        et_py10.setVisibility(View.INVISIBLE);
        et_py11.setVisibility(View.INVISIBLE);
        et_py12.setVisibility(View.INVISIBLE);
    }

    public void selectedSix() {
        clicked = "six";
        py1.setVisibility(View.VISIBLE);
        py2.setVisibility(View.VISIBLE);
        py3.setVisibility(View.VISIBLE);
        py4.setVisibility(View.VISIBLE);
        py5.setVisibility(View.VISIBLE);
        py6.setVisibility(View.VISIBLE);
        py7.setVisibility(View.INVISIBLE);
        py8.setVisibility(View.INVISIBLE);
        py9.setVisibility(View.INVISIBLE);
        py10.setVisibility(View.INVISIBLE);
        py11.setVisibility(View.INVISIBLE);
        py12.setVisibility(View.INVISIBLE);

        et_py1.setVisibility(View.VISIBLE);
        et_py2.setVisibility(View.VISIBLE);
        et_py3.setVisibility(View.VISIBLE);
        et_py4.setVisibility(View.VISIBLE);
        et_py5.setVisibility(View.VISIBLE);
        et_py6.setVisibility(View.VISIBLE);
        et_py7.setVisibility(View.INVISIBLE);
        et_py8.setVisibility(View.INVISIBLE);
        et_py9.setVisibility(View.INVISIBLE);
        et_py10.setVisibility(View.INVISIBLE);
        et_py11.setVisibility(View.INVISIBLE);
        et_py12.setVisibility(View.INVISIBLE);
    }

    public void selectedSeven() {
        clicked = "seven";
        py1.setVisibility(View.VISIBLE);
        py2.setVisibility(View.VISIBLE);
        py3.setVisibility(View.VISIBLE);
        py4.setVisibility(View.VISIBLE);
        py5.setVisibility(View.VISIBLE);
        py6.setVisibility(View.VISIBLE);
        py7.setVisibility(View.VISIBLE);
        py8.setVisibility(View.INVISIBLE);
        py9.setVisibility(View.INVISIBLE);
        py10.setVisibility(View.INVISIBLE);
        py11.setVisibility(View.INVISIBLE);
        py12.setVisibility(View.INVISIBLE);

        et_py1.setVisibility(View.VISIBLE);
        et_py2.setVisibility(View.VISIBLE);
        et_py3.setVisibility(View.VISIBLE);
        et_py4.setVisibility(View.VISIBLE);
        et_py5.setVisibility(View.VISIBLE);
        et_py6.setVisibility(View.VISIBLE);
        et_py7.setVisibility(View.VISIBLE);
        et_py8.setVisibility(View.INVISIBLE);
        et_py9.setVisibility(View.INVISIBLE);
        et_py10.setVisibility(View.INVISIBLE);
        et_py11.setVisibility(View.INVISIBLE);
        et_py12.setVisibility(View.INVISIBLE);

    }

    public void selectedEight() {
        clicked = "eight";
        py1.setVisibility(View.VISIBLE);
        py2.setVisibility(View.VISIBLE);
        py3.setVisibility(View.VISIBLE);
        py4.setVisibility(View.VISIBLE);
        py5.setVisibility(View.VISIBLE);
        py6.setVisibility(View.VISIBLE);
        py7.setVisibility(View.VISIBLE);
        py8.setVisibility(View.VISIBLE);
        py9.setVisibility(View.INVISIBLE);
        py10.setVisibility(View.INVISIBLE);
        py11.setVisibility(View.INVISIBLE);
        py12.setVisibility(View.INVISIBLE);

        et_py1.setVisibility(View.VISIBLE);
        et_py2.setVisibility(View.VISIBLE);
        et_py3.setVisibility(View.VISIBLE);
        et_py4.setVisibility(View.VISIBLE);
        et_py5.setVisibility(View.VISIBLE);
        et_py6.setVisibility(View.VISIBLE);
        et_py7.setVisibility(View.VISIBLE);
        et_py8.setVisibility(View.VISIBLE);
        et_py9.setVisibility(View.INVISIBLE);
        et_py10.setVisibility(View.INVISIBLE);
        et_py11.setVisibility(View.INVISIBLE);
        et_py12.setVisibility(View.INVISIBLE);
    }

    public void selectedNine() {
        clicked = "nine";
        py1.setVisibility(View.VISIBLE);
        py2.setVisibility(View.VISIBLE);
        py3.setVisibility(View.VISIBLE);
        py4.setVisibility(View.VISIBLE);
        py5.setVisibility(View.VISIBLE);
        py6.setVisibility(View.VISIBLE);
        py7.setVisibility(View.VISIBLE);
        py8.setVisibility(View.VISIBLE);
        py9.setVisibility(View.VISIBLE);
        py10.setVisibility(View.INVISIBLE);
        py11.setVisibility(View.INVISIBLE);
        py12.setVisibility(View.INVISIBLE);

        et_py1.setVisibility(View.VISIBLE);
        et_py2.setVisibility(View.VISIBLE);
        et_py3.setVisibility(View.VISIBLE);
        et_py4.setVisibility(View.VISIBLE);
        et_py5.setVisibility(View.VISIBLE);
        et_py6.setVisibility(View.VISIBLE);
        et_py7.setVisibility(View.VISIBLE);
        et_py8.setVisibility(View.VISIBLE);
        et_py9.setVisibility(View.VISIBLE);
        et_py10.setVisibility(View.INVISIBLE);
        et_py11.setVisibility(View.INVISIBLE);
        et_py12.setVisibility(View.INVISIBLE);
    }

    public void selectedTen() {
        clicked = "ten";
        py1.setVisibility(View.VISIBLE);
        py2.setVisibility(View.VISIBLE);
        py3.setVisibility(View.VISIBLE);
        py4.setVisibility(View.VISIBLE);
        py5.setVisibility(View.VISIBLE);
        py6.setVisibility(View.VISIBLE);
        py7.setVisibility(View.VISIBLE);
        py8.setVisibility(View.VISIBLE);
        py9.setVisibility(View.VISIBLE);
        py10.setVisibility(View.VISIBLE);
        py11.setVisibility(View.INVISIBLE);
        py12.setVisibility(View.INVISIBLE);

        et_py1.setVisibility(View.VISIBLE);
        et_py2.setVisibility(View.VISIBLE);
        et_py3.setVisibility(View.VISIBLE);
        et_py4.setVisibility(View.VISIBLE);
        et_py5.setVisibility(View.VISIBLE);
        et_py6.setVisibility(View.VISIBLE);
        et_py7.setVisibility(View.VISIBLE);
        et_py8.setVisibility(View.VISIBLE);
        et_py9.setVisibility(View.VISIBLE);
        et_py10.setVisibility(View.VISIBLE);
        et_py11.setVisibility(View.INVISIBLE);
        et_py12.setVisibility(View.INVISIBLE);
    }

    public void selectedEleven() {
        clicked = "eleven";
        py1.setVisibility(View.VISIBLE);
        py2.setVisibility(View.VISIBLE);
        py3.setVisibility(View.VISIBLE);
        py4.setVisibility(View.VISIBLE);
        py5.setVisibility(View.VISIBLE);
        py6.setVisibility(View.VISIBLE);
        py7.setVisibility(View.VISIBLE);
        py8.setVisibility(View.VISIBLE);
        py9.setVisibility(View.VISIBLE);
        py10.setVisibility(View.VISIBLE);
        py11.setVisibility(View.VISIBLE);
        py12.setVisibility(View.INVISIBLE);

        et_py1.setVisibility(View.VISIBLE);
        et_py2.setVisibility(View.VISIBLE);
        et_py3.setVisibility(View.VISIBLE);
        et_py4.setVisibility(View.VISIBLE);
        et_py5.setVisibility(View.VISIBLE);
        et_py6.setVisibility(View.VISIBLE);
        et_py7.setVisibility(View.VISIBLE);
        et_py8.setVisibility(View.VISIBLE);
        et_py9.setVisibility(View.VISIBLE);
        et_py10.setVisibility(View.VISIBLE);
        et_py11.setVisibility(View.VISIBLE);
        et_py12.setVisibility(View.INVISIBLE);

    }

    public void selectedTwelve() {
        clicked = "twelve";
        py1.setVisibility(View.VISIBLE);
        py2.setVisibility(View.VISIBLE);
        py3.setVisibility(View.VISIBLE);
        py4.setVisibility(View.VISIBLE);
        py5.setVisibility(View.VISIBLE);
        py6.setVisibility(View.VISIBLE);
        py7.setVisibility(View.VISIBLE);
        py8.setVisibility(View.VISIBLE);
        py9.setVisibility(View.VISIBLE);
        py10.setVisibility(View.VISIBLE);
        py11.setVisibility(View.VISIBLE);
        py12.setVisibility(View.VISIBLE);

        et_py1.setVisibility(View.VISIBLE);
        et_py2.setVisibility(View.VISIBLE);
        et_py3.setVisibility(View.VISIBLE);
        et_py4.setVisibility(View.VISIBLE);
        et_py5.setVisibility(View.VISIBLE);
        et_py6.setVisibility(View.VISIBLE);
        et_py7.setVisibility(View.VISIBLE);
        et_py8.setVisibility(View.VISIBLE);
        et_py9.setVisibility(View.VISIBLE);
        et_py10.setVisibility(View.VISIBLE);
        et_py11.setVisibility(View.VISIBLE);
        et_py12.setVisibility(View.VISIBLE);
    }

    public void DBcreate() {
        sqLiteDatabase = openOrCreateDatabase("SampleDataBase", Context.MODE_PRIVATE, null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sampleTable (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name VARCHAR);");
    }

    public void SubmitDataToSqlite() {
        first = "true";

        sqlitequery = "INSERT INTO sampleTable (name ) VALUES ('" + et1_value + "');";
        sqLiteDatabase.execSQL(sqlitequery);
        Toast.makeText(getApplicationContext(), "Data insert successfully", Toast.LENGTH_LONG).show();
            if(i==0) {
                i=1;
                finish();
                startActivity(getIntent());

            }else {
                Intent intent=new Intent(PalyerNames.this,ScoreCardActivity.class);
                startActivity(intent);
            }

    }
}
