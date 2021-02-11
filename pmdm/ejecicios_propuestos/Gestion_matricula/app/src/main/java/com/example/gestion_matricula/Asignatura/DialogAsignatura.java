package com.example.gestion_matricula.Asignatura;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.example.gestion_matricula.R;

import java.util.List;

public class DialogAsignatura extends DialogFragment {

    EditText editText_name_asignatura;
    AsignaturaForList asignatura;
    int id_st;
    int num_students;

    public DialogAsignatura() {


    }

    public DialogAsignatura(AsignaturaForList asignatura) {
        this.asignatura = asignatura;
    }

    //interfaz
    public interface OnSimpleDialogListener {
        void onPossitiveButtonClick(String name_asignatura, int id, int num_students);// Eventos Botón Positivo

    }

    OnSimpleDialogListener listener;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        return createSimpleDialog();
    }


    //Creamos diálogo para insertar alumno

    public AlertDialog createSimpleDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setMessage(Html.fromHtml("<b>" + "Introduzca asignatura" + "</b>"));
        View v = inflater.inflate(R.layout.activity_add_asignatura, null);
        builder.setView(v);

        editText_name_asignatura = (EditText) v.findViewById(R.id.et_name_asignatura);
        if (asignatura != null) { //si es para modificar establece datos del alumno a modificar en los editText
            builder.setMessage(Html.fromHtml("<b>" + "Actualiza asignatura" + "</b>"));
            editText_name_asignatura.setText(asignatura.name);
            id_st = asignatura.id;
            num_students = asignatura.num_students;
        }

        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {

                listener.onPossitiveButtonClick(editText_name_asignatura.getText().toString(), id_st, num_students);
            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();
                    }
                });
        return builder.create();
    }


    //metodo para comprobar si se ha implementado metodo en el contexto
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {

            listener = (OnSimpleDialogListener) context;

        } catch (ClassCastException e) {
            throw new ClassCastException(
                    context.toString() +
                            " no implementó OnSetTitleListener");

        }
    }
}