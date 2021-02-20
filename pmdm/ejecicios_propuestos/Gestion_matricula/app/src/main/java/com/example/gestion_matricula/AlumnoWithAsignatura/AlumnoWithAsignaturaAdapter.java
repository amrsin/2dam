package com.example.gestion_matricula.AlumnoWithAsignatura;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestion_matricula.R;
import com.example.gestion_matricula.data.Asignatura.Asignatura;

import java.util.List;

public class AlumnoWithAsignaturaAdapter
        extends RecyclerView.Adapter<AlumnoWithAsignaturaAdapter.AlumnoWithAsignaturaViewHolder> {
    //variables
    private List<Asignatura> Asignaturas;
    private ItemListener mItemListener;


    @NonNull
    @Override
    public AlumnoWithAsignaturaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AlumnoWithAsignaturaViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.alumno_with_asignatura_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoWithAsignaturaViewHolder holder, int position) {
        Asignatura item = Asignaturas.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return Asignaturas == null ? 0 : Asignaturas.size();
    }

    public void setItems(List<Asignatura> items) {
        Asignaturas = items;
        notifyDataSetChanged();
    }

    public void setItemListener(ItemListener listener) {
        mItemListener = listener;
    }


    interface ItemListener {
        void onDeleteIconClicked(Asignatura Asignatura);
    }

    public class AlumnoWithAsignaturaViewHolder extends RecyclerView.ViewHolder {
        //variables
        private final TextView Name_asignaturaText;
        private final TextView idText;
        private final ImageView img_dlt;

        //constructor con los elementos de alumno
        public AlumnoWithAsignaturaViewHolder(@NonNull View itemView) {
            super(itemView);
            Name_asignaturaText = itemView.findViewById(R.id.name_asignatura);
            idText = itemView.findViewById(R.id.id);
            img_dlt = itemView.findViewById(R.id.img_dlt);

            // Setear eventos
            img_dlt.setOnClickListener(this::manageEvents);
            itemView.setOnClickListener(this::manageEvents);
        }

        //metodo para manejar eventos
        private void manageEvents(View view) {
            if (mItemListener != null) {
                Asignatura clickedItem = Asignaturas.get(getAdapterPosition());

                if (view.getId() == R.id.img_dlt) {
                    mItemListener.onDeleteIconClicked(clickedItem);
                    return;
                }
            }
        }

        //asignamos los datos
        public void bind(Asignatura item) {

            Name_asignaturaText.setText(item.getName());
            idText.setText(String.valueOf(item.getId()));
        }
    }
}