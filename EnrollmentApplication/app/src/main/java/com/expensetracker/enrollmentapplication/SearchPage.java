package com.expensetracker.enrollmentapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by K Sisayan on 17/04/2017.
 */

public class SearchPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.search_page);

        ImageView home_btn= (ImageView) findViewById(R.id.home_button);
        ImageView search_btn= (ImageView) findViewById(R.id.search_button);
        ImageView enlist_btn= (ImageView) findViewById(R.id.enlist_button);
        Button search = (Button) findViewById(R.id.search_class);

        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SearchPage.this, HomePage.class));
            }
        });
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SearchPage.this, SearchPage.class));
            }
        });
        enlist_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SearchPage.this, EnrollPage.class));
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add code to search for classes inside db and display to list view
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

                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(SearchPage.this);
                View mView = getLayoutInflater().inflate(R.layout.enlist_dialog, null);
                final View bView = getLayoutInflater().inflate(R.layout.search_page,null);
                Button submitButton = (Button) mView.findViewById(R.id.submit_Button);
                Button cancelButton = (Button) mView.findViewById(R.id.cancel_Button);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                submitButton.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v) {
                        //add code to enlist course and add enlisted course to database
                        Toast.makeText(SearchPage.this, "Course Enlisted.",Toast.LENGTH_SHORT).show();

                    }
                });
                cancelButton.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        dialog.hide();
                    }
                });
            }
        });



    }
}
