package com.btahtaci.sorucevaplama;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mLoginBtn = (Button) findViewById(R.id.login);

        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);

        final Intent login_intent = new Intent(getBaseContext(), ProfileDetailActivity.class);


        String line = "";
        InputStream is = this.getResources().openRawResource(R.raw.user);
        BufferedReader r = new BufferedReader(new InputStreamReader(is));


        final List<User> usersList = new ArrayList<>();

        if(is != null){
            try{
                while ((line = r.readLine()) != null){
                    String[] uInfo = line.split(",");
                    User u = new User(uInfo[0],uInfo[1]);
                    usersList.add(u);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().length() == 0 || password.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(),"Enter your username and password",Toast.LENGTH_SHORT).show();
                }

                for(User tUser : usersList){
                    if(tUser.getUsername().equals(username.getText().toString()) && tUser.getPassword().equals(password.getText().toString())){
                        login_intent.putExtra("USERNAME",tUser.getUsername());
                        startActivity(login_intent);
                    }
                }

            }
        });

    }
}
