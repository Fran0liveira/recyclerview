package com.example.projetolista.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.projetolista.R;
import com.example.projetolista.RecyclerItemClickListener;
import com.example.projetolista.adapters.Adapter;
import com.example.projetolista.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> lstFilmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        lstFilmes = new ArrayList<>();

        //listagem de filmes
        for(int i = 0 ; i < 100; i++){
            Filme filme = new Filme();
            filme.setTitulo("Filme " + i);
            filme.setGenero("Genero " + i);
            filme.setAno("Ano " + i);
            lstFilmes.add(filme);
        }

        //configurar Adapter
        Adapter adapter = new Adapter(lstFilmes);

        //configrar recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Filme filme = lstFilmes.get(position);
                        String mensagem = "FILME PRESSIONADO: " + filme.getTitulo();
                        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT ).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Filme filme = lstFilmes.get(position);
                        String mensagem = "VOCÊ SELECIONOU: " + filme.getTitulo();
                        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    }
                }));


    }
}
