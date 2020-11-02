package com.example.mybookslibrary;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.content.Intent;
        import android.os.Bundle;

public class WantToReadBooks extends AppCompatActivity {
    RecyclerView wtrbrecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_to_read_books);
        wtrbrecyclerview=findViewById(R.id.wtrbrecyclerview);
        BookRecViewAdapter adapter=new BookRecViewAdapter(WantToReadBooks.this,Utility.getInstance(this).getWantToReadBooks(),"wanttoread");
        wtrbrecyclerview.setAdapter(adapter);
        wtrbrecyclerview.setLayoutManager(new LinearLayoutManager(WantToReadBooks.this));
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(WantToReadBooks.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}