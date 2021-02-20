package com.example.gestion_matricula.Alumno;

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

public class DialogAlumno extends DialogFragment {
    //variables
    EditText editText_name;
    EditText editText_surname;
    EditText editText_DNI;
    AlumnoForList alumno;

    //constructor por defecto
    public DialogAlumno() {
    }

    //constructor con objeto alumno
    public DialogAlumno(AlumnoForList alumno) {
        this.alumno = alumno;
    }

    //interfaz
    public interface OnSimpleDialogListener {
        void onPossitiveButtonClick(String DNI, String name, String surnames);// Eventos Botón Positivo
    }

    OnSimpleDialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        return createSimpleDialog();
    }


    //Creamos diálogo para insertar/editar alumno
    public AlertDialog createSimpleDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setTitle("Introduzca alumno");
        View v = inflater.inflate(R.layout.activity_add_alumno, null);
        builder.setView(v);


        editText_DNI = (EditText) v.findViewById(R.id.et_dni);
        editText_name = (EditText) v.findViewById(R.id.et_name);
        editText_surname = (EditText) v.findViewById(R.id.et_surname);
        if (alumno != null) { //si es para modificar establece datos del alumno a modificar en los editText
            builder.setTitle(Html.fromHtml("<b>" + "Actualize alumno" + "</b>"));
            editText_DNI.setText(alumno.DNI);
            editText_DNI.setKeyListener(null);
            editText_name.setText(alumno.name);
            editText_surname.setText(alumno.surnames);
        }
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {

                listener.onPossitiveButtonClick(editText_DNI.getText().toString(), editText_name.getText().toString(), editText_surname.getText().toString());
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