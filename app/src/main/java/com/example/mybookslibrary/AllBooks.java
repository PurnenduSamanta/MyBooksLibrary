package com.example.mybookslibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;

public class AllBooks extends AppCompatActivity
{
    RecyclerView allbooksrecyclerview;
    BookRecViewAdapter adapter;
    ArrayList<Books>b=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
        allbooksrecyclerview=findViewById(R.id.allbooksrecyclerview);
        adapter=new BookRecViewAdapter(this,Utility.getInstance(AllBooks.this).getAllBooks(),"allBooks");
        allbooksrecyclerview.setAdapter(adapter);
        allbooksrecyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

   // @Override
   // public void finish()
    {
     //   super.finish();
       // overridePendingTransition(R.anim.slide_out,R.anim.slide_in);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                break;
                default:
                break;
      }
        return super.onOptionsItemSelected(item);
    }
}