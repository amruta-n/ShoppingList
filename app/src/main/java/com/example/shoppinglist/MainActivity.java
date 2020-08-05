package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*String[] teams = getResources().getStringArray(R.array.items);
        String[] spinner = getResources().getStringArray(R.array.quantity);

        // Binding resources Array to ListAdapter
        ListView lv = findViewById(R.id.listView);
        lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.textview, teams));

        ListAdapter adapter = new ListAdapter(teams, spinner, this);
        lv.setAdapter(adapter);

        // listening to single list item on click
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // selected item
                String team = ((TextView) view).getText().toString();

                // Launching new Activity on selecting single List Item
                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                // sending data to new activity
                i.putExtra("team", team);
                startActivity(i);

            }
        });*/



        ListView lv = (ListView) findViewById(R.id.listView);
        Button button = (Button) findViewById(R.id.imageButton);

        ArrayList<String> mData = new ArrayList<>();
        mData.add("Apples");
        mData.add("Oranges");
        mData.add("Bananas");
        mData.add("Mangoes");
        mData.add("Cherries");
        mData.add("Watermelon");
        mData.add("Strawberries");
        mData.add("Sweet Limes");


        ArrayList<String> mSpinnerData = new ArrayList<>();
        mSpinnerData.add("1 kg");
        mSpinnerData.add("2 kg");
        mSpinnerData.add("3 kg");
        mSpinnerData.add("4 kg");
        mSpinnerData.add("5 kg");
        mSpinnerData.add("10 kg");

        ListAdapter adapter = new ListAdapter(mData, mSpinnerData, this);
        lv.setAdapter(adapter);

        //button.setOnClickListener((View.OnClickListener) this);
    }

    public void onClick(View view){
        //Intent i = new Intent(getApplicationContext(), Total.class);
        // sending data to new activity
        //i.putExtra("team", );
        //startActivity(i);
    }
}