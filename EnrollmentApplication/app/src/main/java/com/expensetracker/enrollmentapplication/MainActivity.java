package com.expensetracker.enrollmentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = (LinearLayout) findViewById(R.id.mainlayout);
        Button logInBtn = (Button) findViewById(R.id.submit_button);
        final EditText userID = (EditText) findViewById(R.id.user_name);
        final EditText userPwd = (EditText) findViewById(R.id.user_password);


        logInBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if(userID.getText().toString().equals("11337656")&& userPwd.getText().toString().equals("1234")){
                    startActivity(new Intent(MainActivity.this, HomePage.class));
                }
            }
        });
    }
}
