package com.example.urvish.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urvish.Adapters.SQLiteDataBaseActivityAdapter;
import com.example.urvish.HelperClasses.SQLiteDatabaseHelperClass;
import com.example.urvish.R;
import com.example.urvish.modelClasses.SQLiteUserdataModalClass;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class SQLiteDataBaseActivity extends AppCompatActivity {

    RecyclerView sql_recyclerview;
    FloatingActionButton user_add;
    TextView empty_view;
    SearchView search_view;
    ArrayList<SQLiteUserdataModalClass> userlist = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_data_base);

        sql_recyclerview = findViewById(R.id.sql_recyclerview);
        user_add = findViewById(R.id.user_add);
        empty_view = findViewById(R.id.empty_view);
        search_view = findViewById(R.id.search_view);

        SQLiteDatabaseHelperClass dbhelper = new SQLiteDatabaseHelperClass(SQLiteDataBaseActivity.this);
        Cursor cursor = dbhelper.viewdata();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String sqlname = cursor.getString(1);
            String sqlemail = cursor.getString(2);
            String sqlage = cursor.getString(3);
            String sqlnumber = cursor.getString(4);
            String sqlgender = cursor.getString(5);
            String sqlimage = cursor.getString(6);

            SQLiteUserdataModalClass userdata = new SQLiteUserdataModalClass(id, sqlname, sqlemail, sqlage, sqlnumber, sqlgender, sqlimage);
            userlist.add(userdata);

        }

        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                ArrayList<SQLiteUserdataModalClass> searchlist = new ArrayList<>();

                for (int i = 0; i < userlist.size(); i++) {
                    String name = userlist.get(i).getSqlname();
                    if (name.toLowerCase().contains(newText.toLowerCase())) {
                        searchlist.add(userlist.get(i));
                    }
                }

                if (searchlist.isEmpty()) {
                    sql_recyclerview.setVisibility(View.GONE);
                    empty_view.setVisibility(View.VISIBLE);
                } else {
                    sql_recyclerview.setVisibility(View.VISIBLE);
                    empty_view.setVisibility(View.GONE);
                }

                SQLiteDataBaseActivityAdapter sqlAdapter1 = new SQLiteDataBaseActivityAdapter(SQLiteDataBaseActivity.this, searchlist);
                sql_recyclerview.setAdapter(sqlAdapter1);

                return false;
            }
        });

        if (userlist.isEmpty()) {
            sql_recyclerview.setVisibility(View.GONE);
            empty_view.setVisibility(View.VISIBLE);
        } else {
            sql_recyclerview.setVisibility(View.VISIBLE);
            empty_view.setVisibility(View.GONE);
        }

        SQLiteDataBaseActivityAdapter sqlAdapter = new SQLiteDataBaseActivityAdapter(SQLiteDataBaseActivity.this, userlist);
        sql_recyclerview.setAdapter(sqlAdapter);

        user_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SQLiteDataBaseActivity.this, SQLiteAddDataActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
}