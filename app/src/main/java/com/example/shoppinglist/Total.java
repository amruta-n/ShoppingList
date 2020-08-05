package com.example.shoppinglist;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Total extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.total);

        ListView lv = (ListView) findViewById(R.id.listViewTotal);

        ArrayList<String> mData = new ArrayList<>();
        mData.add("Apples");
        mData.add("Oranges");
        mData.add("Bananas");
        mData.add("Mangoes");
        mData.add("Cherries");
        mData.add("Watermelon");
        mData.add("Strawberries");
        mData.add("Sweet Limes");
        mData.add("Kiwis");

        TextView tv2 = (TextView) findViewById(R.id.tv2);
        Spinner spinner= findViewById(R.id.spinner);

        tv2.setText(spinner.getSelectedItem().toString());
    }
}
