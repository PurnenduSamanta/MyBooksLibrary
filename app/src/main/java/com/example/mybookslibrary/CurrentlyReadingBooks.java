package com.example.mybookslibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class CurrentlyReadingBooks extends AppCompatActivity {

    RecyclerView crbrecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_reading_books);
        crbrecyclerview=findViewById(R.id.crbrecyclerview);
        BookRecViewAdapter adapter=new BookRecViewAdapter(CurrentlyReadingBooks.this,Utility.getInstance(this).getCurrentlyReadingBooks(),"currentlyreading");
        crbrecyclerview.setAdapter(adapter);
        crbrecyclerview.setLayoutManager(new LinearLayoutManager(CurrentlyReadingBooks.this));
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(CurrentlyReadingBooks.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}