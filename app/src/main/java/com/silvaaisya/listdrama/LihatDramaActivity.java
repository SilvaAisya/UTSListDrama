package com.silvaaisya.listdrama;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

import com.silvaaisya.listdrama.Entities.Drama;
import com.silvaaisya.listdrama.Models.DramaModel;

public class LihatDramaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    // Data
    private DramaModel mDrama;
    private ArrayList<Drama> allDrama;
    private ArrayList<String> daftarNama;
    // Komponen
    private ListView listDrama;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_drama);

        this.initData();
        this.initComponents();
    }
    private void initData()
    {
        this.daftarNama = new ArrayList<>();

        this.mDrama = new DramaModel(this);
        this.allDrama = this.mDrama.selectAll();
        for(Drama drm : allDrama) {
            this.daftarNama.add(drm.getNama());
        }
    }
    private void initComponents()
    {
        this.listDrama = (ListView) this.findViewById(R.id.listDrama);
        this.btnOk = (Button) this.findViewById(R.id.btnOk);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, this.daftarNama);
        this.listDrama.setAdapter(adapter);

        this.listDrama.setOnItemClickListener(this);
    }

    public void button_onClick(View view)
    {
        Button b = (Button) view;
        if(b == this.btnOk)
            this.finish();
        Intent i = new Intent(this, HalamanUtamaActivity.class);
        this.startActivity(i);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        int id = this.allDrama.get(i).getId();
        Intent intent = new Intent(this, DetailDramaActivity.class);
        intent.putExtra("selectedContactId", id);
        this.startActivity(intent);
    }

}