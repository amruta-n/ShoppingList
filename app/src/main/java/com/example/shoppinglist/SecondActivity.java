package com.example.shoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends MainActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView txtProduct =  findViewById(R.id.tv);

        Intent i = getIntent();

        String product = i.getStringExtra("team");

        txtProduct.setText(product);
    }
}
