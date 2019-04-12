package com.silvaaisya.listdrama.Libraries;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private int id;
    private String nama;
    private String nomor;

    public DBHelper(Context context) {

        super(context, "ListDrama.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS ListDrama(id integer PRIMARY KEY, nama VARCHAR, nomor VARCHAR)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS ListDrama";
        db.execSQL(sql);
        this.onCreate(db);
    }
    public Cursor executeRead(String sql)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }
    public void executeWrite(String sql)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }
}