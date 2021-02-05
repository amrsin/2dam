package com.example.gestion_matricula.Alumno;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.example.gestion_matricula.R;

public class DialogAlumno extends DialogFragment {

    EditText editText_name;
    EditText editText_surname;
    EditText editText_DNI;


    public DialogAlumno() {


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


    //Creamos un diálogo

    public AlertDialog createSimpleDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        final LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setMessage(Html.fromHtml("<b>"+"Introduzca alumno"+"</b>"));
        builder.setView(inflater.inflate(R.layout.activity_add_alumno,null))
                // Add action buttons
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        editText_DNI = (EditText) getDialog().findViewById(R.id.et_dni);
                        editText_name = (EditText) getDialog().findViewById(R.id.et_name);
                        editText_surname = (EditText) getDialog().findViewById(R.id.et_surname);

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
