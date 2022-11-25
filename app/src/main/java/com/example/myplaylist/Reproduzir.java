package com.example.myplaylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Reproduzir extends AppCompatActivity {

    private int id;
    private MediaPlayer mp;
    private Button btplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproduzir);
        //obter informaçoes passadas por parâmetro:
        btplay = findViewById(R.id.btnplay);
        Intent it = getIntent();
        String valor = (String) it.getSerializableExtra("musica");
        String nome = (String) it.getSerializableExtra("Nome");
        String pkg = this.getPackageName();
        // obter o id da musica:
        id = this.getResources().getIdentifier(valor, "raw",pkg);
        //associar a musica ao midia player;
        this.mp = MediaPlayer.create(this,id);
        TextView txtnome = findViewById(R.id.txtmusica);
        txtnome.setText(nome);

    }
    public void play(View v){
        mp.start();
        btplay.setEnabled(false);
    }
    public void pause(View v){
        mp.pause();
        btplay.setEnabled(true);
    }

    public void voltar (View v){
        mp.stop();
        Intent it = new Intent(Reproduzir.this,MusicList.class);
        startActivity(it);
        finish();
    }
}