package com.example.gestion_matricula.Alumno;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.gestion_matricula.data.Alumno;

import java.util.List;

public class AlumnoAdapter
        extends RecyclerView.Adapter<AlumnoViewHolder> {

    private List<Alumno> Alumnos;

    @NonNull
    @Override
    public AlumnoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return AlumnoViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoViewHolder holder, int position) {
        Alumno item = Alumnos.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return Alumnos == null ? 0 : Alumnos.size();
    }

    public void setItems(List<Alumno> items) {
        Alumnos = items;
        notifyDataSetChanged();
    }
}