package com.demo.goon.roomdbmusictest;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.demo.goon.roomdbmusictest.Room.AppDatabase;
import com.demo.goon.roomdbmusictest.Room.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    FloatingActionButton fab;
    /*ArrayList<User> users;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycler_view);

        /*users = new ArrayList<>();

        for (int i=0;i<100;i++){
            *//*Room db*//*
            User user =new User("Daniel #"+i,"Smith","any@mail.com");
            *//**//*
            users.add(user);
        }*/

        /*adapter = new UserAdapter(users,this);*/

        /*Room database instance (wrap this in background thread)*/
        //AppDatabase database = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, "database-name").build();
        /**/


        /*Room database instance (wrap this in background thread)*/
        AppDatabase database = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, "room_user_sqlite_test")
                .allowMainThreadQueries().build();

        List<User> users = database.userDao().getAll();
        /**/
        adapter = new UserAdapter(users,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreateUser.class));
            }
        });
    }
}
