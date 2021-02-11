package com.example.gestion_matricula.Asignatura;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestion_matricula.Alumno.AlumnoForList;
import com.example.gestion_matricula.R;
import com.example.gestion_matricula.data.Asignatura.Asignatura;

import java.util.List;

public class AsignaturaAdapter
        extends RecyclerView.Adapter<AsignaturaAdapter.AsignaturaViewHolder> {

    private List<AsignaturaForList> Asignaturas;
    private ItemListener mItemListener;

    @NonNull
    @Override
    public AsignaturaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AsignaturaViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.asignatura_list_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull AsignaturaViewHolder holder, int position) {
        AsignaturaForList item = Asignaturas.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return Asignaturas == null ? 0 : Asignaturas.size();
    }

    public void setItems(List<AsignaturaForList> items) {
        Asignaturas = items;
        notifyDataSetChanged();
    }

    public void setItemListener(ItemListener listener) {
        mItemListener = listener;
    }


    interface ItemListener {
        void onEditIconClicked(AsignaturaForList Asignatura);
        void onDeleteIconClicked(AsignaturaForList Asignatura);
    }

    public class AsignaturaViewHolder extends RecyclerView.ViewHolder {
        //variables
        private final TextView Name_asignaturaText;
        private final TextView num_alumnosText;
        private final TextView idText;
        private final ImageView img_dlt, img_edit, img_info;
        //constructor con los elementos de alumno
        public AsignaturaViewHolder(@NonNull View itemView) {
            super(itemView);
            Name_asignaturaText = itemView.findViewById(R.id.name_asignatura);
            idText = itemView.findViewById(R.id.id);
            num_alumnosText = itemView.findViewById(R.id.num_students);
            img_edit = itemView.findViewById(R.id.img_edit);
            img_info = itemView.findViewById(R.id.img_info);
            img_dlt = itemView.findViewById(R.id.img_dlt);


            // Setear eventos
            img_edit.setOnClickListener(this::manageEvents);
            img_dlt.setOnClickListener(this::manageEvents);

            itemView.setOnClickListener(this::manageEvents);


        }

        private void manageEvents(View view) {
            if (mItemListener != null) {
                AsignaturaForList clickedItem = Asignaturas.get(getAdapterPosition());

                   if (view.getId() == R.id.img_edit) {
                       mItemListener.onEditIconClicked(clickedItem);
                   }
                   if (view.getId() == R.id.img_dlt) {
                       mItemListener.onDeleteIconClicked(clickedItem);
                    return;
                }
            }
        }

        //asignamos los datos
        public void bind(AsignaturaForList item) {

            Name_asignaturaText.setText(item.name);
            idText.setText(String.valueOf(item.id));
            num_alumnosText.setText(String.valueOf(item.num_students) + " alumnos");
        }
    }
}