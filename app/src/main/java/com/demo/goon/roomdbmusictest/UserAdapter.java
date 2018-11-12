package com.demo.goon.roomdbmusictest;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.goon.roomdbmusictest.Room.User;

import java.util.ArrayList;
import java.util.List;

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> users;
    private Context context;

    public UserAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, final int position) {
        holder.first_name.setText(users.get(position).getFirstName());
        holder.last_name.setText(users.get(position).getLastName());
        holder.email_address.setText(users.get(position).getEmail());

        System.out.println("TEST LISTz  "+users);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView first_name;
        public TextView last_name;
        public TextView email_address;

        public ViewHolder(View itemView) {
            super(itemView);
            first_name = itemView.findViewById(R.id.firstName);
            last_name = itemView.findViewById(R.id.lastName);
            email_address = itemView.findViewById(R.id.emailAddress);
        }
    }
}
