package com.example.mybookslibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class AlreadyReadBooks extends AppCompatActivity {
    RecyclerView arbrecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_read_books);
        arbrecyclerview=findViewById(R.id.arbrecyclerview);
        BookRecViewAdapter adapter=new BookRecViewAdapter(AlreadyReadBooks.this,Utility.getInstance(this).getAlreadyReadBooks(),"alreadyread");
        arbrecyclerview.setAdapter(adapter);
        arbrecyclerview.setLayoutManager(new LinearLayoutManager(AlreadyReadBooks.this));
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(AlreadyReadBooks.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}