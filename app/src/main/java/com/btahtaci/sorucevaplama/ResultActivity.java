package com.btahtaci.sorucevaplama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String t_c = "";
        String f_c = "";
        String na_c = "";

        Intent i = getIntent();

        t_c = i.getStringExtra("TRUE_COUNT");
        f_c = i.getStringExtra("FALSE_COUNT");
        na_c = i.getStringExtra("NO_ANS_COUNT");

        TextView t = findViewById(R.id.correct_answers);
        TextView f = findViewById(R.id.wrong_answers);
        TextView u = findViewById(R.id.no_answer);

        Button exit = findViewById(R.id.exit_game);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        t.setText(t_c);
        f.setText(f_c);
        u.setText(na_c);
    }
}
