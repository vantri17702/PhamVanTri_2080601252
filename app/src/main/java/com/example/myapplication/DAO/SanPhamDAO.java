package com.example.myapplication.DAO;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.myapplication.database.DbHelper;
import com.example.myapplication.model.SanPham;

import java.util.ArrayList;

    public class SanPhamDAO {
        private final DbHelper dbHelper;
        public SanPhamDAO(Context context){
            dbHelper = new DbHelper(context);
        }

        public ArrayList<SanPham> getListSanPham() {
            ArrayList<SanPham> list = new ArrayList<>();
            SQLiteDatabase database = dbHelper.getReadableDatabase();
            database.beginTransaction();
            try {
                Cursor cursor = database.rawQuery("SELECT * FROM SanPham", null);
                if(cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    do {
                        list.add(new SanPham(cursor.getInt(0),
                                cursor.getString(1),
                                cursor.getFloat(2),
                                cursor.getString(3)));
                    } while (cursor.moveToNext());
                    database.setTransactionSuccessful();
                }
            } catch (Exception e) {
                Log.e(TAG, "getListSanPham" + e);
            } finally {
                database.endTransaction();
            }
            return list;
        }
        public boolean deleteSP(int MaSP) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            int affectedRows = db.delete("SanPham", "MaSP=?", new String[]{String.valueOf(MaSP)});
            return affectedRows > 0;
        }
    }
