package com.example.gestion_matricula.Alumno;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gestion_matricula.R;

import java.util.List;

public class AlumnoAdapter
        extends RecyclerView.Adapter<AlumnoAdapter.AlumnoViewHolder> {

    private List<AlumnoForList> Alumnos;
    private ItemListener mItemListener;

    @NonNull
    @Override
    public AlumnoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AlumnoViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.alumno_list_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoViewHolder holder, int position) {
        AlumnoForList item = Alumnos.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return Alumnos == null ? 0 : Alumnos.size();
    }

    public void setItems(List<AlumnoForList> items) {
        Alumnos = items;
        notifyDataSetChanged();
    }

    public void setItemListener(ItemListener listener) {
        mItemListener = listener;
    }

    interface ItemListener {
        void onEditIconClicked(AlumnoForList Alumno);
        void onDeleteIconClicked(AlumnoForList Alumno);
        void onInfoIconClicked(AlumnoForList Alumno);

    }

    public class AlumnoViewHolder extends RecyclerView.ViewHolder {
        //variables
        private final TextView NameText;
        private final TextView surnamesText;
        private final TextView DNIText;
        private final ImageView img_dlt, img_edit, img_info;
        //constructor con los elementos de alumno
        public AlumnoViewHolder(@NonNull View itemView) {
            super(itemView);
            NameText = itemView.findViewById(R.id.name);
            surnamesText = itemView.findViewById(R.id.surmanes);
            DNIText = itemView.findViewById(R.id.DNI);
            img_edit = itemView.findViewById(R.id.img_edit);
            img_info = itemView.findViewById(R.id.img_info);
            img_dlt = itemView.findViewById(R.id.img_dlt);

            // Setear eventos
            img_edit.setOnClickListener(this::manageEvents);
            img_dlt.setOnClickListener(this::manageEvents);
            img_info.setOnClickListener(this::manageEvents);

            itemView.setOnClickListener(this::manageEvents);

        }
        //metodo para manejar eventos
        private void manageEvents(View view) {
            if (mItemListener != null) {
                AlumnoForList clickedItem = Alumnos.get(getAdapterPosition());

                   if (view.getId() == R.id.img_edit) {
                       mItemListener.onEditIconClicked(clickedItem);
                   }
                    if (view.getId() == R.id.img_info) {
                    mItemListener.onInfoIconClicked(clickedItem);
                    }
                   if (view.getId() == R.id.img_dlt) {
                       mItemListener.onDeleteIconClicked(clickedItem);
                    return;
                }
            }
        }

        //asignamos los datos
        public void bind(AlumnoForList item) {
            NameText.setText(item.name);
            surnamesText.setText(item.surnames);
            DNIText.setText(item.DNI);
        }
    }
}