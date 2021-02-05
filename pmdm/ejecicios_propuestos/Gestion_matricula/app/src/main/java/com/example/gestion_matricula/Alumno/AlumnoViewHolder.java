package com.example.gestion_matricula.Alumno;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.gestion_matricula.R;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestion_matricula.data.Alumno;

public class AlumnoViewHolder extends RecyclerView.ViewHolder {

    private final TextView NameText;
    private final TextView surnamesText;
    private final TextView DNIText;



    public AlumnoViewHolder(@NonNull View itemView) {
        super(itemView);
        NameText = itemView.findViewById(R.id.name);
        surnamesText = itemView.findViewById(R.id.surmanes);
        DNIText = itemView.findViewById(R.id.DNI);
    }

    public void bind(Alumno item) {
        NameText.setText(item.getName());
        surnamesText.setText(item.getSurnames());
        DNIText.setText(item.getDNI());
    }

    public static AlumnoViewHolder create(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.alumno_list_item, parent, false);
        return new AlumnoViewHolder(v);
    }
}