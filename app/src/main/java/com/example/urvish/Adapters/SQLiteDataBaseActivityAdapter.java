package com.example.urvish.Adapters;

import static com.example.urvish.R.color.white1;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urvish.Activity.SQLiteDataBaseActivity;
import com.example.urvish.Activity.SQLteUpdateActivity;
import com.example.urvish.HelperClasses.SQLiteDatabaseHelperClass;
import com.example.urvish.R;
import com.example.urvish.modelClasses.SQLiteUserdataModalClass;

import java.util.ArrayList;

public class SQLiteDataBaseActivityAdapter extends RecyclerView.Adapter<SQLiteDataBaseActivityAdapter.sqlclass> {

    SQLiteDataBaseActivity sQliteDataBaseActivity;
    ArrayList<SQLiteUserdataModalClass> userlist;

    public SQLiteDataBaseActivityAdapter(SQLiteDataBaseActivity sQliteDataBaseActivity, ArrayList<SQLiteUserdataModalClass> userlist) {
        this.sQliteDataBaseActivity = sQliteDataBaseActivity;
        this.userlist = userlist;
    }

    @NonNull
    @Override
    public SQLiteDataBaseActivityAdapter.sqlclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(sQliteDataBaseActivity).inflate(R.layout.sqlitem,parent,false);

        return new sqlclass(v);
    }

    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
    @Override
    public void onBindViewHolder(@NonNull SQLiteDataBaseActivityAdapter.sqlclass holder, @SuppressLint("RecyclerView") int position) {

        SQLiteUserdataModalClass ll=userlist.get(position);
        holder.sql_name.setText("Name          : "+ll.getSqlname());
        holder.sql_email.setText("Email           : "+ll.getSqlemail());
        holder.sql_age.setText("age              : "+ll.getSqlage());
        holder.sql_gender.setText("Gender       : "+ll.getSqlgender());
        holder.sql_number.setText("Phone no. : "+ll.getSqlnumber());
        holder.sql_image.setImageURI(Uri.parse((ll.sqlimage)));

        if(position%2==0)
        {
            holder.liner_database.setBackgroundResource(white1);
        }else {
            holder.liner_database.setBackgroundColor(Color.WHITE);
        }

        holder.sql_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(sQliteDataBaseActivity);
                builder.setMessage("Do you want to Delete "+ll.sqlname+" User Information ?")
                        .setCancelable(false);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        SQLiteDatabaseHelperClass dbhelper=new SQLiteDatabaseHelperClass(sQliteDataBaseActivity);
                        dbhelper.deletedata(ll.getId());

                        userlist.remove(position);
                        notifyDataSetChanged();

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });


                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(sQliteDataBaseActivity, SQLteUpdateActivity.class);
                intent.putExtra("id0",ll.getId());
                intent.putExtra("name0",ll.getSqlname());
                intent.putExtra("email0",ll.getSqlemail());
                intent.putExtra("age0",ll.getSqlage());
                intent.putExtra("gender0",ll.getSqlgender());
                intent.putExtra("number0",ll.getSqlnumber());
                intent.putExtra("image0",ll.getSqlimage());
                sQliteDataBaseActivity.startActivity(intent);
                sQliteDataBaseActivity.finish();

            }
        });

    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class sqlclass extends RecyclerView.ViewHolder {

        ImageView sql_cancel,sql_image;
        LinearLayout liner_database;
        TextView  sql_name,sql_email,sql_age,sql_number,sql_gender;

        public sqlclass(@NonNull View itemView) {
            super(itemView);

            sql_cancel=itemView.findViewById(R.id.sql_cancel);
            liner_database=itemView.findViewById(R.id.liner_database);
            sql_image=itemView.findViewById(R.id.sql_image);
            sql_name=itemView.findViewById(R.id.sql_name);
            sql_email=itemView.findViewById(R.id.sql_email);
            sql_age=itemView.findViewById(R.id.sql_age);
            sql_number=itemView.findViewById(R.id.sql_number);
            sql_gender=itemView.findViewById(R.id.sql_gender);

        }
    }
}
