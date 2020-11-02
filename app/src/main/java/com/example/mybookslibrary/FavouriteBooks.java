package com.example.mybookslibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class FavouriteBooks extends AppCompatActivity {
     RecyclerView fbrecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_books);
        fbrecyclerview=findViewById(R.id.fbrecyclerview);
        BookRecViewAdapter adapter=new BookRecViewAdapter(FavouriteBooks.this,Utility.getInstance(this).getFavouriteBooks(),"favouritebook");
        fbrecyclerview.setAdapter(adapter);
        fbrecyclerview.setLayoutManager(new LinearLayoutManager(FavouriteBooks.this));
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(FavouriteBooks.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}