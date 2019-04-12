package com.silvaaisya.listdrama;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.facebook.stetho.Stetho;

public class HalamanUtamaActivity extends AppCompatActivity {
    private Button btnLihatDrama;
    private Button btnTambahDrama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);

        this.initComponents();
    }
    private void initComponents()
    {
        this.btnLihatDrama = (Button) this.findViewById(R.id.btnLihatDrama);
        this.btnTambahDrama = (Button) this.findViewById(R.id.btnTambahDrama);
    }
    public void button_onClick(View view)
    {
        Button b = (Button) view;
        if(b == this.btnLihatDrama)
        {
            this.openLihatDramaActivity();
        }
        else if(b == this.btnTambahDrama)
        {
            this.openTambahDramaActivity();
        }
    }
    private void openLihatDramaActivity()
    {
        Intent i = new Intent(this, LihatDramaActivity.class);
        this.startActivity(i);
    }
    private void openTambahDramaActivity()
    {
        Intent i = new Intent(this, TambahDramaActivity.class);
        this.startActivity(i);
    }
}
