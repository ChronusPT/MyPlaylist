package com.example.myplaylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MusicList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);

    ListView listaMusicas = (ListView) findViewById(R.id.Lista);
    final ArrayList<Albuns> al = adicionaMusicas();
    ArrayAdapter adapter = new AlbunsAdapter(this,al);
        listaMusicas.setAdapter(adapter);
        listaMusicas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            //Toast.makeText(getBaseContext(),"Item clicado"+al.get(i).getNome(), Toast.LENGTH_LONG).show();
            Intent it = new Intent(MusicList.this,Reproduzir.class);
            //Passagem por parametros para a activity destino:
            it.putExtra("musica",al.get(i).getMusica());
            it.putExtra("Nome",al.get(i).getNome());
            startActivity(it);
            finish();
        }
    });

}
    private ArrayList<Albuns> adicionaMusicas(){
        ArrayList<Albuns> arr = new ArrayList<Albuns>();
        Albuns a = new Albuns("TK from Ling tosite sigure",R.drawable.tgh,"katharsis","Tokyo Ghoul :Re");
        arr.add(a);
        a = new Albuns("Xutos & Pontapés",R.drawable.xutos,"casinha","Tour 2000");
        arr.add(a);
        a = new Albuns("System Shock 2",R.drawable.system,"ethicalconstraints","RemiX");
        arr.add(a);
        return arr;
    }
}