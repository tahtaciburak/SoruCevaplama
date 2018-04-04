package com.btahtaci.sorucevaplama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_detail);

        TextView mQuestionText = findViewById(R.id.question);

        Button mBtnA = findViewById(R.id.a);
        Button mBtnB = findViewById(R.id.b);
        Button mBtnC = findViewById(R.id.c);
        Button mBtnD = findViewById(R.id.d);

        Intent i = getIntent();

        final Question currentQuestion = (Question) i.getSerializableExtra("QUESTION");

        mQuestionText.setText(currentQuestion.getQuestionText());
        mBtnA.setText(currentQuestion.getA());
        mBtnB.setText(currentQuestion.getB());
        mBtnC.setText(currentQuestion.getC());
        mBtnD.setText(currentQuestion.getD());


        mBtnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestion.getCorrectAnswer()==1){
                    Intent i = new Intent();
                    i.putExtra("STATUS","T");
                    setResult(2,i);
                    finish();
                    Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_SHORT).show();

                }else {
                    Intent i = new Intent();
                    i.putExtra("STATUS","F");
                    setResult(2,i);
                    finish();

                }

            }
        });

        mBtnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestion.getCorrectAnswer()==2){
                    Intent i = new Intent();
                    i.putExtra("STATUS","T");
                    setResult(2,i);
                    finish();
                    Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_SHORT).show();


                }else {
                    Intent i = new Intent();
                    i.putExtra("STATUS","F");
                    setResult(2,i);
                    finish();

                }

            }
        });

        mBtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestion.getCorrectAnswer()==3){
                    Intent i = new Intent();
                    i.putExtra("STATUS","T");
                    setResult(2,i);
                    finish();
                    Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_SHORT).show();

                }else {
                    Intent i = new Intent();
                    i.putExtra("STATUS","F");
                    setResult(2,i);
                    finish();

                }

            }
        });

        mBtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestion.getCorrectAnswer()==4){
                    Intent i = new Intent();
                    i.putExtra("STATUS","T");
                    setResult(2,i);
                    finish();
                    Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_SHORT).show();

                }else {
                    Intent i = new Intent();
                    i.putExtra("STATUS","F");
                    setResult(2,i);
                    finish();

                }

            }
        });

    }
}
