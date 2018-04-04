package com.btahtaci.sorucevaplama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail);

        Button mEditProfileBtn = findViewById(R.id.edit_profile);
        Button mBeginTestBtn = findViewById(R.id.begin_test);

        Intent i = new Intent();

        String strFromIntent;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                strFromIntent= null;
            } else {
                strFromIntent= extras.getString("USERNAME");
            }
        } else {
            strFromIntent= (String) savedInstanceState.getSerializable("USERNAME");
        }

        TextView uname = findViewById(R.id.username_lbl);
        uname.setText(strFromIntent);

        final Intent begin_test = new Intent(this, CategoriesActivity.class);

        mBeginTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(begin_test);
            }
        });
    }
}
