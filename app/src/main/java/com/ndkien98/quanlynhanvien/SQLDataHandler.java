package com.ndkien98.quanlynhanvien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SQLDataHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="QuanLyNhanVien";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "nhanVien";

    public static final String KEY_ID="id";
    public static final String KEY_NAME = "hoTen";
    public static final String KEY_NAMSINH="namSinh";
    public static final String KEY_PHONG_BAN="phongBan";
    public static final String KEY_LUONG="luong";
    public static final String KEY_DIACHI="diaChi";
    public static final String KEY_QUYEN="quyen";

    public SQLDataHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public SQLDataHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_table_nhanvien = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s VARCHAR ,%s VARCHAR , %s VARCHAR,%s VARCHAR,%s INTEGER,%s INTEGER)",
                                                    TABLE_NAME,KEY_ID,KEY_NAME,KEY_DIACHI,KEY_PHONG_BAN,KEY_NAMSINH,KEY_LUONG,KEY_QUYEN);
        sqLiteDatabase.execSQL(create_table_nhanvien);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String drop_table_nhanvien = String.format("DROP TABLE IF EXISTS %s",TABLE_NAME);
        sqLiteDatabase.execSQL(drop_table_nhanvien);
        onCreate(sqLiteDatabase);
    }

    public void addNhanVien(NhanVien nhanVien){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID,nhanVien.getId());
        values.put(KEY_NAME,nhanVien.getHoTen());
        values.put(KEY_DIACHI,nhanVien.getDiaChi());
        values.put(KEY_PHONG_BAN,nhanVien.getPhongBan());
        values.put(KEY_NAMSINH,nhanVien.getNamSinh());
        values.put(KEY_LUONG,nhanVien.getLuong());
        values.put(KEY_QUYEN,nhanVien.getQuyen());

        sqLiteDatabase.insert(TABLE_NAME,null,values);
        sqLiteDatabase.close();
    }

    public ArrayList<NhanVien> layDanhSachNhanVien(){

        ArrayList<NhanVien> nhanVienArrayList = new ArrayList<>();


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(String.format("select * from %s", TABLE_NAME),null);
        cursor.moveToFirst();

        while (cursor.isAfterLast()== false){

            int id = cursor.getInt(cursor.getColumnIndex(KEY_ID));
            String name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
            String diachi = cursor.getString(cursor.getColumnIndex(KEY_DIACHI));
            String phongban = cursor.getString(cursor.getColumnIndex(KEY_PHONG_BAN));
            String namsinh = cursor.getString(cursor.getColumnIndex(KEY_NAMSINH));
            int luong = cursor.getInt(cursor.getColumnIndex(KEY_LUONG));
            int quyen = cursor.getInt(cursor.getColumnIndex(KEY_QUYEN));
            NhanVien nhanVien = new NhanVien(id,name,diachi,phongban,namsinh,luong,quyen);

            cursor.moveToNext();
        }
        return nhanVienArrayList;

    }


    public NhanVien getNhanVien(int idNhanVien){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,null,KEY_ID+"=?",new String[]{String.valueOf(idNhanVien)},null,null,null);
        if (cursor != null){
            cursor.moveToNext();
        }
        NhanVien nhanVien = new NhanVien(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5),cursor.getInt(6));
        return nhanVien;
    }



}
