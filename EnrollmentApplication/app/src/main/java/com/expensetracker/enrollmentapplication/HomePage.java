package com.expensetracker.enrollmentapplication; /**
 * Created by K Sisayan on 03/04/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home_page);

        ImageView home_btn= (ImageView) findViewById(R.id.home_button);
        ImageView search_btn= (ImageView) findViewById(R.id.search);
        ImageView enlist_btn= (ImageView) findViewById(R.id.enlist_button);

        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, HomePage.class));
            }
        });
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, SearchPage.class));
            }
        });
        enlist_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, EnrollPage.class));
            }
        });


        ListView class_list = (ListView) findViewById(R.id.class_list);
        String[] subj = {"Math","Science","English","Science","COMPRO","WOW","Wee"};
        ArrayList<String> classes = new ArrayList<>(Arrays.asList(subj));

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,classes);

        class_list.setAdapter(adapter);
        class_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView txt = (TextView) view;
                System.out.println(txt.getText().toString());

            }
        });
    }
}