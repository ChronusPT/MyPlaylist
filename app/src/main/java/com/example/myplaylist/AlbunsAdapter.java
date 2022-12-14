package com.example.myplaylist;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myplaylist.Albuns;
import com.example.myplaylist.R;

import java.util.ArrayList;

public class AlbunsAdapter extends ArrayAdapter <Albuns> {

    private final Context context;
    private final ArrayList<Albuns> elementos;

    public AlbunsAdapter(@NonNull Context context, ArrayList<Albuns> elementos) {
        super(context, R.layout.linha, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha, parent, false);
        TextView band = (TextView) rowView.findViewById(R.id.banda);
        TextView music = (TextView) rowView.findViewById(R.id.musica);
        TextView album = (TextView) rowView.findViewById(R.id.albun);
        ImageView img = (ImageView) rowView.findViewById(R.id.img);

        band.setText(elementos.get(position).getNome());
        music.setText(elementos.get(position).getMusica());
        album.setText(elementos.get(position).getTour());
        img.setImageResource(elementos.get(position).getImagem());
        return rowView;
    }

}
