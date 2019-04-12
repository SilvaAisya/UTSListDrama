package com.silvaaisya.listdrama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.silvaaisya.listdrama.Entities.Drama;
import com.silvaaisya.listdrama.Models.DramaModel;

public class DetailDramaActivity extends AppCompatActivity {
    // Data
    private DramaModel mDrama;
    private Drama selectedDrama;
    // Komponen
    private EditText txtNama;
    private EditText txtNomor;
    private Button btnUbah;
    private Button btnHapus;
    private Button btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_drama);

        this.initData();
        this.initComponents();
    }
    private void initData()
    {
        this.mDrama = new DramaModel(this);
        int selectedContactId = this.getIntent().getIntExtra("selectedContactId", -1);
        this.selectedDrama = this.mDrama.selectOne(selectedContactId);
    }
    private void initComponents()
    {
        this.txtNama = (EditText) this.findViewById(R.id.txtJudul);
        this.txtNomor = (EditText) this.findViewById(R.id.txtGenre);
        this.btnUbah = (Button) this.findViewById(R.id.btnUbah);
        this.btnHapus = (Button) this.findViewById(R.id.btnHapus);
        this.btnKembali = (Button) this.findViewById(R.id.btnKembali);

        // Isi teks pada komponen saat Activity baru dimunculkan
        this.txtNama.setText(this.selectedDrama.getNama());
        this.txtNomor.setText(this.selectedDrama.getNomor());
    }
    public void button_onClick(View view)
    {
        Button b = (Button) view;
        if(b == this.btnUbah)
        {
            this.ubahDrama();
        }
        else if(b == this.btnHapus)
        {
            this.hapusDrama();
        }
        else if(b == this.btnKembali)
        {
            this.finish();
        }
    }
    private void ubahDrama()
    {
        String nama = this.txtNama.getText().toString();
        String nomor = this.txtNomor.getText().toString();
        this.selectedDrama.setNama(nama);
        this.selectedDrama.setNomor(nomor);
        this.mDrama.update(this.selectedDrama);
        Intent i = new Intent(this, LihatDramaActivity.class);
        this.resetFields("Data berhasil diperbarui!", false);
        this.startActivity(i);
    }
    private void hapusDrama()
    {
        this.mDrama.delete(this.selectedDrama);
        this.resetFields("Data dihapus!", true);
        Intent i = new Intent(this, LihatDramaActivity.class);
        this.btnHapus.setEnabled(false);
        this.startActivity(i);
    }
    private void resetFields(String pesan, boolean clear)
    {
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
        if(clear)
        {
            this.txtNama.setText("");
            this.txtNomor.setText("");
        }
    }
}
