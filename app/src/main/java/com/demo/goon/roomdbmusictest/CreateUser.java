package com.demo.goon.roomdbmusictest;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.demo.goon.roomdbmusictest.Room.AppDatabase;
import com.demo.goon.roomdbmusictest.Room.User;

public class CreateUser extends AppCompatActivity {

    private static final String TAG = "CreateUser";

    EditText firstName,lastName,email;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);

        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        email = findViewById(R.id.email);
        button = findViewById(R.id.button);

        /*Room database instance (wrap this in background thread)*/
        final AppDatabase database = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, "room_user_sqlite_test")
                .allowMainThreadQueries().build();
        /**/

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick: firstName: "+firstName.getText().toString());

                /*Room DB*/
                database.userDao().insertAll(new User(firstName.getText().toString(),lastName.getText().toString(),email.getText().toString()));
                /**/
                startActivity(new Intent(CreateUser.this,MainActivity.class));
            }
        });
    }
}
