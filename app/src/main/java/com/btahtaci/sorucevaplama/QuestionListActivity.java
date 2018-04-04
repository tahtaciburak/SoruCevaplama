package com.btahtaci.sorucevaplama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QuestionListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    Integer t_count = 0;
    Integer f_count = 0;
    Integer all_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);

        String category_name = "";
        String strFromIntent;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                strFromIntent= null;
            } else {
                strFromIntent= extras.getString("CAT_NAME");
            }
        } else {
            strFromIntent= (String) savedInstanceState.getSerializable("CAT_NAME");
        }
        TextView cName = findViewById(R.id.category_name);
        category_name = strFromIntent;
        cName.setText(category_name);
        Button mSumbitBtn = findViewById(R.id.submit);

        final Intent getResults = new Intent(this, ResultActivity.class);
        mSumbitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer temp = all_count-t_count-f_count;
                getResults.putExtra("TRUE_COUNT", t_count.toString());
                getResults.putExtra("FALSE_COUNT",f_count.toString());
                getResults.putExtra("NO_ANS_COUNT",temp.toString());
                startActivity(getResults);
            }
        });


        mRecyclerView = (RecyclerView) findViewById(R.id.question_list);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        final List<Question> myDataset;
        myDataset = new ArrayList<>();

        StringBuffer mBuffer = new StringBuffer();
        String line = "";
        InputStream is = this.getResources().openRawResource(R.raw.questions);
        BufferedReader r = new BufferedReader(new InputStreamReader(is));

        if(is != null){
            try{
                while ((line = r.readLine()) != null){
                    String[] qInfo = line.split(",");
                    if(qInfo[1].equals(category_name)){
                        Question q = new Question(qInfo[0],qInfo[1],Integer.parseInt(qInfo[2]),qInfo[3],qInfo[4],qInfo[5],qInfo[6],Integer.parseInt(qInfo[7]));
                        myDataset.add(q);
                        all_count ++;
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        QuestionAdapter mAdapter = new QuestionAdapter(this, myDataset, new CustomItemClickListener() {
            Intent showQuestionDetails = new Intent(getBaseContext(),QuestionDetail.class);
            @Override
            public void onItemClick(View v, int position) {
                Question tempQuestion = myDataset.get(position);
                v.setEnabled(false);
                v.setBackgroundColor(0x80808000);
                showQuestionDetails.putExtra("QUESTION", tempQuestion);
                startActivityForResult(showQuestionDetails,2);

            }
        });
        mRecyclerView.setAdapter(mAdapter);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2)
        {
            String message=data.getStringExtra("STATUS");
            if (message.equals("T")){
                t_count ++;
            }else{
                f_count++;
            }
        }
    }
}
