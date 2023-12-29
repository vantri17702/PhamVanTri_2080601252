package com.example.myapplication.database;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context, "QLSanPham", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE SanPham(MaSP INTEGER PRIMARY KEY AUTOINCREMENT, " + "TenSP TEXT, GiaTien REAL, Image TEXT)";
        db.execSQL(sql);
        String data = "INSERT INTO SanPham VALUES(1, 'Hủ tiếu', '25000', 'https://znews-photo.zadn.vn/w660/Uploaded/jaroin/2017_08_03/1_3.jpg')," +
                "(2, 'Mì Quảng', '30000', 'https://statics.vinpearl.com/mi-quang-hoi-an-2_1631199897.jpg')," +
                "(4, 'Bánh Canh', '35000', 'https://cdn.tgdd.vn/2021/05/CookProduct/thumbcmscn-1200x676-4.jpg'),"+
                "(3, 'Bún Bò', '50000', 'https://static.vinwonders.com/production/bun-bo-hue-cau-giay-1.jpg')";

        db.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i != i1){
            db.execSQL("DROP TABLE IF EXISTS SanPham");
            onCreate(db);
        }
    }
}
