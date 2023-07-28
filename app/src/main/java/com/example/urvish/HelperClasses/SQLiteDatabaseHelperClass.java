package com.example.urvish.HelperClasses;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteDatabaseHelperClass extends SQLiteOpenHelper {
    public SQLiteDatabaseHelperClass(@Nullable Context context) {
        super(context, "dd", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create = "create table usertable (id integer primary key autoincrement ,Name Text,Email Text,Age Text,Number Text,Gender Text,Image Text)";
        db.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertdata(String name, String email, String age, String number, String user_imagess, String imagessssss) {

        String insert = "insert into usertable (Name,Email,Age,Number,Gender,Image) values ('" + name + "','" + email + "','" + age + "','" + number + "','" + imagessssss + "','" + user_imagess + "')";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(insert);


    }

    public Cursor viewdata() {

        String select="select * from usertable";
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();

        Cursor cursor=sqLiteDatabase.rawQuery(select,null);
        return cursor;
    }

    public void deletedata(int id) {

        String delete="delete from usertable where id='"+id+"'";
        SQLiteDatabase database=getWritableDatabase();
        database.execSQL(delete);

    }

    public void Updatedata(String name, String email, String age, String number, String valueOf, String chckegender, int id9) {

        String update="update usertable set Name='"+name+"',Email='"+email+"',Age='"+age+"',Number='"+number+"',Gender='"+chckegender+"',Image='"+valueOf+"' where id='"+id9+"'";
        SQLiteDatabase database=getWritableDatabase();
        database.execSQL(update);

    }
}
