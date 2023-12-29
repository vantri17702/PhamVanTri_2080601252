package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.Adapter.SanPhamAdapter;
import com.example.myapplication.DAO.SanPhamDAO;
import com.example.myapplication.model.SanPham;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SanPhamAdapter sanPhamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SanPhamDAO sanPhamDAO = new SanPhamDAO(this);
        ArrayList<SanPham> listSanPham = sanPhamDAO.getListSanPham();
        sanPhamAdapter = new SanPhamAdapter(this, listSanPham);
        recyclerView.setAdapter(sanPhamAdapter);
    }

    public void refreshRecyclerView() {
        SanPhamDAO sanPhamDAO = new SanPhamDAO(MainActivity.this);
        ArrayList<SanPham> list = sanPhamDAO.getListSanPham();
        SanPhamAdapter sanPhamAdapter = new SanPhamAdapter(MainActivity.this, list);
        recyclerView.setAdapter(sanPhamAdapter);
    }
}