package com.zainabali.yz.recycleviwe;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {
    ArrayList<Book>booksList;

    public BookAdapter(ArrayList<Book>booksList) {
        this.booksList=booksList;
    }


    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
      View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_row,parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        holder.title_book.setText(booksList.get(position).title);
        holder.author_book.setText(booksList.get(position).author);
        holder.year_book.setText(booksList.get(position).year);

    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
       TextView title_book,author_book,year_book;
        public MyViewHolder(View itemView){
            super(itemView);
            title_book=itemView.findViewById(R.id.title_txt);
            author_book=itemView.findViewById(R.id.author_txt);
            year_book=itemView.findViewById(R.id.year_txt);
        }
    }
}
