package com.silvaaisya.listdrama.Models;

import java.util.ArrayList;
import android.content.Context;
import android.database.Cursor;

import com.silvaaisya.listdrama.Entities.Drama;
import com.silvaaisya.listdrama.Libraries.DBHelper;

public class DramaModel {
    private Context context;
    private DBHelper db;
    public DramaModel(Context context)
    {
        this.context = context;
        this.db = new DBHelper(this.context);
    }
    public ArrayList<Drama> selectAll()
    {
        String sql = "SELECT * FROM ListDrama";
        ArrayList<Drama> allDrama = new ArrayList<>();
        Cursor cursor = this.db.executeRead(sql);
        if(cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            do
            {
                int id = cursor.getInt(0);
                String nama = cursor.getString(1);
                String nomor = cursor.getString(2);
                Drama drm = new Drama();
                drm.setId(id);
                drm.setNama(nama);
                drm.setNomor(nomor);
                allDrama.add(drm);
            }
            while (cursor.moveToNext());
        }
        return allDrama;
    }
    public void insert(Drama drm)
    {
        String nama = drm.getNama();
        String nomor = drm.getNomor();
        String sql = "INSERT INTO ListDrama(nama, nomor) VALUES('" + nama + "', '" + nomor + "')";
        this.db.executeWrite(sql);
    }
    public void update(Drama drm)
    {
        if(drm.getId() < 0)
            return;
        int id = drm.getId();
        String nama = drm.getNama();
        String nomor = drm.getNomor();
        String sql = "UPDATE ListDrama SET nama = '" + nama + "', nomor = '" + nomor + "' WHERE id =  '" + id + "'";
        this.db.executeWrite(sql);
    }
    public Drama selectOne(int id)
    {
        String sql = "SELECT * FROM ListDrama WHERE id = '" + id + "'";
        Cursor cursor = this.db.executeRead(sql);
        if(cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            Drama drm = new Drama();
            drm.setId(cursor.getInt(0));
            drm.setNama(cursor.getString(1));
            drm.setNomor(cursor.getString(2));
            return drm;
        }
        return null;
    }
    public void delete(Drama drm)
    {
        if(drm.getId() < 0) // ID negatif -> Bukan dari tabel
            return;
        String sql = "DELETE FROM ListDrama WHERE id = '" + drm.getId() + "'";
        this.db.executeWrite(sql);
    }
}