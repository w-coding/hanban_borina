package com.dya.hanbanborina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class Detail extends AppCompatActivity {

    DbClass mdbClass;
    SQLiteDatabase db;
    List <Item>aText1;
    RecyclerView DetailRecyclerView;
    EditText SearchRecyclerView;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DetailRecyclerView=findViewById(R.id.DetailRecyclerView);
        SearchRecyclerView=findViewById(R.id.SearchRecyclerView);

        back =findViewById(R.id.back);
        back.setOnClickListener(view -> onBackPressed());


        mdbClass = new DbClass(this);

        mdbClass.StartWork();
        db=mdbClass.getWritableDatabase();
        aText1 = new ArrayList<>();

        StoreDataInArrayList();

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, aText1 );
        DetailRecyclerView.setAdapter(recyclerViewAdapter);
        DetailRecyclerView.setLayoutManager(new LinearLayoutManager(this));



        SearchRecyclerView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                recyclerViewAdapter.getFilter().filter(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    void StoreDataInArrayList(){

            Cursor cursor = mdbClass.readAllkf();

            if (cursor.getCount() == 0) {
                Toast.makeText(this, "no data ", Toast.LENGTH_SHORT).show();
            } else {
                while (cursor.moveToNext()) {
                    aText1.add(new Item(cursor.getString(1),cursor.getString(2)));
                }
            }


    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Detail.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}