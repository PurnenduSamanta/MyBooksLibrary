package com.example.mybookslibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
   Button sab,cr,arb,yw,syf,about;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Utility.getInstance(this);
        setContentView(R.layout.activity_main);
        sab=findViewById(R.id.sab);
        cr=findViewById(R.id.crb);
        arb=findViewById(R.id.arb);
        yw=findViewById(R.id.yw);
        syf=findViewById(R.id.syf);
        about=findViewById(R.id.about);
        sab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AllBooks.class);
                startActivity(intent);
            }
        });
        arb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AlreadyReadBooks.class);
                startActivity(intent);
            }
        });
        cr.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(MainActivity.this,CurrentlyReadingBooks.class);
            startActivity(intent);
        }
    });
        yw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,WantToReadBooks.class);
                startActivity(intent);
            }
        });
        syf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,FavouriteBooks.class);
                startActivity(intent);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setMessage("Designed and Developed with love by Purnendu\n"+"Check my website for more information");
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(MainActivity.this,web.class);
                        String url="https://google.co.in/";
                        intent.putExtra("webview",url);
                        startActivity(intent);

                    }
                });
                builder.create().show();
            }
        });


    }
}