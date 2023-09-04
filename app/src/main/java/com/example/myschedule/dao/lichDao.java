package com.example.myschedule.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myschedule.database.dbHelper;
import com.example.myschedule.model.lich;

import java.util.ArrayList;

public class lichDao {
    private final dbHelper dbHelper;

    public lichDao(Context context) {
        dbHelper = new dbHelper(context);
    }

    public ArrayList<lich> selectAll() {
        ArrayList<lich> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor = db.rawQuery("select * from lich", null);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    lich lich = new lich();
                    lich.setId(cursor.getInt(0));
                    lich.setNgayThangNam(cursor.getString(1));
                    lich.setNgayThang(cursor.getString(2));
                    lich.setLichNgay(cursor.getString(3));
                    list.add(lich);
                    cursor.moveToNext();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
