package com.btahtaci.sorucevaplama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        Button mHistoryBtn = findViewById(R.id.history);
        Button mCultureBtn = findViewById(R.id.culture);
        Button mScienceBtn = findViewById(R.id.science);
        Button mLawBtn = findViewById(R.id.law);
        Button mBooksBtn = findViewById(R.id.books);
        Button mBiologyBtn = findViewById(R.id.biology);
        Button mMathBtn = findViewById(R.id.math);
        Button mSportBtn = findViewById(R.id.sport);

        final Intent play_game = new Intent(this,QuestionListActivity.class);

        mScienceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play_game.putExtra("CAT_NAME","science");
                startActivity(play_game);
            }
        });

        mCultureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play_game.putExtra("CAT_NAME","culture");
                startActivity(play_game);
            }
        });

        mHistoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play_game.putExtra("CAT_NAME","history");
                startActivity(play_game);
            }
        });

        mLawBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play_game.putExtra("CAT_NAME","law");
                startActivity(play_game);

            }
        });

        mBooksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play_game.putExtra("CAT_NAME","books");
                startActivity(play_game);

            }
        });

        mBiologyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play_game.putExtra("CAT_NAME","biology");
                startActivity(play_game);

            }
        });

        mMathBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play_game.putExtra("CAT_NAME","math");
                startActivity(play_game);
            }
        });

        mSportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play_game.putExtra("CAT_NAME","sport");
                startActivity(play_game);
            }
        });
    }
}
