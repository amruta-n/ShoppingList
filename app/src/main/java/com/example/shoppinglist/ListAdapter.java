package com.example.shoppinglist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    private ArrayList<String> mSpinnerItems;
    private ArrayList<String> mData;
    private Context mContext;

    FirebaseDatabase database;
    DatabaseReference reff;
    Member member;
    ImageButton button;
    Spinner spinner;
    int maxid=0;



    public ListAdapter(ArrayList<String> data, ArrayList<String> spinnerItems, Context context) {
        mData = data;
        mContext = context;
        mSpinnerItems = spinnerItems;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item, null);
        }

        button = (ImageButton) view.findViewById(R.id.cartButton);
        //spinner = findViewById(R.id.spinner);
        member = new Member();
        reff = database.getInstance().getReference().child("Data ");

        TextView textView = (TextView) view.findViewById(R.id.textview);
         spinner = (Spinner) view.findViewById(R.id.spinner);

        textView.setText(mData.get(position));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, mSpinnerItems);
        spinner.setAdapter(adapter);

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                    maxid = (int) dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String spin = spinner.getSelectedItem().toString();
                if (spinner != null){
                    
                    member.setSpinner(spin);
                    //Toast.makeText(Main2Activity.this, "Registration Successfull", Toast.LENGTH_LONG).show();
                    //toast.show();

                    reff.child(String.valueOf(maxid+1)).setValue(member);

                }
            }
        });

        return view;
    }

}
