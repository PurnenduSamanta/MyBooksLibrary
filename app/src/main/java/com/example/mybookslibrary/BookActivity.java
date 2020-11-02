package com.example.mybookslibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity
{

    ImageView bookphoto;
     Button crb,wtr,ar,atf;
     TextView bn,ath,pa,desc,ABC,XYZ,hun,abc;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        bn=findViewById(R.id.bn);
        ath=findViewById(R.id.ath);
        pa=findViewById(R.id.pa);
        desc=findViewById(R.id.desc);
        ABC=findViewById(R.id.ABC);
        XYZ=findViewById(R.id.XYZ);
        hun=findViewById(R.id.hun);
        abc=findViewById(R.id.abc);
        crb=findViewById(R.id.crb);
        wtr=findViewById(R.id.wtr);
        ar=findViewById(R.id.ar);
        atf=findViewById(R.id.atf);
        bookphoto=findViewById(R.id.bookphoto);
        Intent intent=getIntent();
        if(null!=intent)
        {
            int bookId=intent.getIntExtra("bookId",-1);
            if(-1!=bookId)
            {
                Books inComingBooks = Utility.getInstance(this).getBookById(bookId);
                if (null != inComingBooks)
                {
                    setData(inComingBooks);
                    handleAlreadyRead(inComingBooks);
                    handleCurrentlyReading(inComingBooks);
                    handleWantToRead(inComingBooks);
                    handlefavourite(inComingBooks);
                }
            }
        }

    }

    private void handlefavourite(final Books books)
    {
        boolean existfavourite=false;
        for(Books b:Utility.getInstance(this).getFavouriteBooks())
        {
            if(b.getId()==books.getId())
            {
                existfavourite=true;
            }
        }
        if( existfavourite) {
            atf.setEnabled(false);
        }
        else
        {
            atf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    if(Utility.getInstance(BookActivity.this).addToWantToFavourite(books)) {
                        Toast.makeText(BookActivity.this, "Book added successfully", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(BookActivity.this,FavouriteBooks.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(BookActivity.this, "Something wrong happened", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }




    }

    private void handleWantToRead(final Books books)
    {
        boolean existWantToReadBooks=false;
        for(Books b:Utility.getInstance(this).getWantToReadBooks())
        {
            if(b.getId()==books.getId())
            {
                existWantToReadBooks=true;
            }
        }
        if( existWantToReadBooks) {
            wtr.setEnabled(false);
        }
        else
        {
            wtr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    if(Utility.getInstance(BookActivity.this).addToWantToReadBooks(books)) {
                        Toast.makeText(BookActivity.this, "Book added successfully", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(BookActivity.this,WantToReadBooks.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(BookActivity.this, "Something wrong happened", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }



    }

    private void handleCurrentlyReading(final Books  books)
    {
        boolean existInCurrentlyReadingBooks=false;
        for(Books b:Utility.getInstance(BookActivity.this).getCurrentlyReadingBooks())
        {
            if(b.getId()==books.getId())
            {
                existInCurrentlyReadingBooks=true;
            }
        }
        if( existInCurrentlyReadingBooks) {
            crb.setEnabled(false);
        }
        else
        {
            crb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    if(Utility.getInstance(BookActivity.this).addToCurrentlyReadingBooks(books)) {
                        Toast.makeText(BookActivity.this, "Book added successfully", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(BookActivity.this,CurrentlyReadingBooks.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(BookActivity.this, "Something wrong happened", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleAlreadyRead(final Books books)
    {
        boolean existInAlreadyReadBooks=false;
        for(Books b:Utility.getInstance(BookActivity.this).getAlreadyReadBooks())
        {
            if(b.getId()==books.getId())
            {
                existInAlreadyReadBooks=true;
            }
        }
        if( existInAlreadyReadBooks) {
            ar.setEnabled(false);
        }
        else
        {
            ar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    if(Utility.getInstance(BookActivity.this).addToAlreadyReadBook(books)) {
                        Toast.makeText(BookActivity.this, "Book added successfully", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(BookActivity.this,AlreadyReadBooks.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(BookActivity.this, "Something wrong happened", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setData(Books boo)
    {
        ABC.setText(boo.getName());
        XYZ.setText(boo.getAuthor());
        hun.setText(String.valueOf(boo.getPages()));
        abc.setText(boo.getLongdesc());
        Glide.with(this).load(boo.getImageurl()).into(bookphoto);
    }

}