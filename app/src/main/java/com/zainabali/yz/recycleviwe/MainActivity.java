package com.zainabali.yz.recycleviwe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
BookAdapter myAdapter;
Toolbar myToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Book> booksList=new ArrayList<>();

        String title,author,year;
        booksList.add(new Book(title="Book1",author="author1",year="year1"));
        booksList.add(new Book(title="Book2",author="author2",year="year2"));
        booksList.add(new Book(title="Book3",author="author3",year="year3"));
        booksList.add(new Book(title="Book4",author="author4",year="year4"));
        booksList.add(new Book(title="Book5",author="author5",year="year5"));
        booksList.add(new Book(title="Book6",author="author6",year="year6"));
        booksList.add(new Book(title="Book7",author="author7",year="year7"));
        booksList.add(new Book(title="Book8",author="author8",year="year8"));


        recyclerView=findViewById(R.id.Rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter=new BookAdapter(booksList);
        recyclerView.setAdapter(myAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));//لعمل تقسيم للشاشه

        myToolBar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolBar);




        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(),recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
             Book book=booksList.get(position);
                Toast.makeText(getApplicationContext(), "Selected Item IS :"+book.title, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


}//on create


   }
