package com.silvaaisya.listdrama;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.silvaaisya.listdrama.Entities.Drama;
import com.silvaaisya.listdrama.Models.DramaModel;

public class TambahDramaActivity extends AppCompatActivity{
    private DramaModel mDrama;
    // Komponen
    private EditText txtNama;
    private EditText txtNomor;
    private Button btnSimpan;
    private Button btnBatal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_drama);

        this.initData();
        this.initComponents();
    }
    private void initData()
    {
        this.mDrama = new DramaModel(this);
    }
    private void initComponents()
    {
        this.txtNama = (EditText) this.findViewById(R.id.txtJudul);
        this.txtNomor = (EditText) this.findViewById(R.id.txtGenre);
        this.btnSimpan = (Button) this.findViewById(R.id.btnSimpan);
        this.btnBatal = (Button) this.findViewById(R.id.btnBatal);
    }
    public void button_onClick(View view)
    {
        Button b = (Button) view;
        if(b == this.btnSimpan)
        {
            this.tambahDrama();
        }
        else if(b == this.btnBatal)
        {
            this.finish();
        }
    }
    private void tambahDrama()
    {
        String nama = this.txtNama.getText().toString();
        String nomor = this.txtNomor.getText().toString();
        Drama dramaBaru = new Drama();
        dramaBaru.setNama(nama);
        dramaBaru.setNomor(nomor);
        this.mDrama.insert(dramaBaru);
        Toast.makeText(this, "Drama berhasil ditambahkan", Toast.LENGTH_SHORT).show();
        this.btnBatal.setText("Kembali");
    }
}
