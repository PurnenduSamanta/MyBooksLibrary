package com.example.mybookslibrary;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookRecViewAdapter extends RecyclerView.Adapter<BookRecViewAdapter.MyViewHolder>
{
    Context c;
    String tag;
    ArrayList<Books> booklist=new ArrayList<>();
    public BookRecViewAdapter(Context c,ArrayList<Books> booklist,String tag)
    {
        this.c=c;
        this.booklist=booklist;
        this.tag=tag;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.booklist,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return (holder);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position)
    {
     holder.bookname.setText(booklist.get(position).getName());
     holder.authortxt.setText(booklist.get(position).getAuthor());
     holder.sortdesc.setText(booklist.get(position).getShortdesc());
        Glide.with(c).load(booklist.get(position).getImageurl()).into(holder.bookimage);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(c,BookActivity.class);
                in.putExtra("bookId",booklist.get(position).getId());
                c.startActivity(in);
            }
        });
        holder.down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Books books=booklist.get(position);
                books.setExpanded(!books.isExpanded());
                notifyItemChanged(position);
            }
        });
        holder.up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Books books=booklist.get(position);
                books.setExpanded(!books.isExpanded());
                notifyItemChanged(position);
            }
        });
        if (booklist.get(position).isExpanded())
        {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedcard.setVisibility(View.VISIBLE);
            holder.down.setVisibility(View.GONE);
            if(tag.equals("allBooks"))
            {
                holder.delete.setVisibility(View.GONE);
            }
            else if(tag.equals("alreadyread"))
            {
              holder.delete.setVisibility(View.VISIBLE);
              holder.delete.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      AlertDialog.Builder builder=new AlertDialog.Builder(c);
                      builder.setMessage("Are you sure to delete "+booklist.get(position).getName()+"?");
                      builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                          @Override
                          public void onClick(DialogInterface dialog, int which) {
                              if(Utility.getInstance(c).removeFromAlreadyRead(booklist.get(position)))
                              {
                                  Toast.makeText(c, "Book removed", Toast.LENGTH_SHORT).show();
                                  notifyDataSetChanged();
                              }
                          }
                      });
                      builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                          @Override
                          public void onClick(DialogInterface dialog, int which) {

                          }
                      });
                      builder.create().show();

                  }
              });
            }
            else if(tag.equals("wanttoread"))
            {
                holder.delete.setVisibility(View.VISIBLE);
                holder.delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder=new AlertDialog.Builder(c);
                        builder.setMessage("Are you sure to delete "+booklist.get(position).getName()+"?");
                        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(Utility.getInstance(c).removeWantToread(booklist.get(position)))
                                {
                                    Toast.makeText(c, "Book removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();

                    }
                });

            }
            else if(tag.equals("currentlyreading"))
            {
                holder.delete.setVisibility(View.VISIBLE);
                holder.delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder=new AlertDialog.Builder(c);
                        builder.setMessage("Are you sure to delete "+booklist.get(position).getName()+"?");
                        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(Utility.getInstance(c).removeCurrentlyread(booklist.get(position)))
                                {
                                    Toast.makeText(c, "Book removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();

                    }
                });
            }
            else
            {
                holder.delete.setVisibility(View.VISIBLE);
                holder.delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder=new AlertDialog.Builder(c);
                        builder.setMessage("Are you sure to delete "+booklist.get(position).getName()+"?");
                        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(Utility.getInstance(c).removeFavourite(booklist.get(position)))
                                {
                                    Toast.makeText(c, "Book removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();

                    }
                });
            }
        }
        else
        {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.down.setVisibility(View.VISIBLE);
            holder.expandedcard.setVisibility(View.GONE);
            holder.up.setVisibility(View.GONE);

        }

    }

    @Override
    public int getItemCount() {
        return (booklist.size());
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
{
    CardView parent;
    RelativeLayout expandedcard;
    ImageView bookimage,up,down;
    TextView bookname,authortxt,txrauthoer,sortdesc,delete;
    public MyViewHolder(@NonNull View itemView)
    {
        super(itemView);
        parent=itemView.findViewById(R.id.parent);
        bookimage=itemView.findViewById(R.id.bookimages);
        bookname=itemView.findViewById(R.id.bookname);
        expandedcard=itemView.findViewById(R.id.expandedcard);
        up=itemView.findViewById(R.id.up);
        down=itemView.findViewById(R.id.down);
        authortxt=itemView.findViewById(R.id.authortxt);
        txrauthoer=itemView.findViewById(R.id.txrauthoer);
        sortdesc=itemView.findViewById(R.id.sortdesc);
        delete=itemView.findViewById(R.id.delete);

    }
}

}
