package com.example.gestion_matricula.AlumnoWithAsignatura;

import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.gestion_matricula.R;
import com.example.gestion_matricula.data.Asignatura.AsignaturaRepository;

import java.util.ArrayList;
import java.util.List;

public class DialogAlumno_Asignatura extends DialogFragment {
    //var
    RadioGroup rg_asignaturas;
    AlumnoAsignaturaViewModel viewModel = new AlumnoAsignaturaViewModel((Application) getContext());
    List<String> list_alu_asig = new ArrayList<>();
    List<String> list_all_asig = new ArrayList<>();
    String dni, name;
    boolean aux = false;

    //constuctor con dni,name de alumno
    public DialogAlumno_Asignatura(String dni, String name) {

        this.dni = dni;
        this.name = name;
    }

    //interfaz
    public interface OnSimpleDialogListener {
        void onPossitiveButtonClick(int id_asig);// Eventos Botón Positivo
    }

    OnSimpleDialogListener listener;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return createSimpleDialog();
    }

    //Creamos diálogo para asignar asignatura a alumno
    public AlertDialog createSimpleDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setTitle("Asigne asignatura a " + name + "\n\n");
        View v = inflater.inflate(R.layout.activity_alu_asig_radio, null);
        builder.setView(v);

        rg_asignaturas = (RadioGroup) v.findViewById(R.id.rg_asignaturas);
        setup_radio();
        try {
            RadioButton primerRadio = (RadioButton) rg_asignaturas.getChildAt(0);
            primerRadio.setChecked(true);
        } catch (NullPointerException e) {

            builder.setTitle(name + " tiene todas las asignaturas asignadas");
            aux = true;

        }
        if (!aux) {
            builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {

                    try {

                        int i = rg_asignaturas.getCheckedRadioButtonId();
                        RadioButton r = (RadioButton) v.findViewById(i);
                        int id_asig = viewModel.id_asignatura(r.getText().toString());
                        listener.onPossitiveButtonClick(id_asig);
                    } catch (NullPointerException e) {


                    }

                }
            })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            dialog.dismiss();
                        }
                    });
        }
        return builder.create();
    }

    //metodo para crear Radiobuttons desde codigo
    private RadioButton crearRadioButton(String respuesta) {
        RadioButton nuevoRadio = new RadioButton(getContext());
        LinearLayout.LayoutParams params = new RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT);
        nuevoRadio.setLayoutParams(params);
        nuevoRadio.setText(respuesta);
        nuevoRadio.setTag(respuesta);
        return nuevoRadio;
    }

    //obtener listado asignaturas en las cuales el alumno no esta
    private void setup_radio() {

        list_all_asig = viewModel.list_all_asig();
        list_alu_asig = viewModel.list_alu_in(dni);

        if (list_alu_asig.isEmpty()) {

            for (int i = 0; i < list_all_asig.size(); i++) {
                rg_asignaturas.addView(crearRadioButton(list_all_asig.get(i).toString()));
            }
        } else {

            for (int i = 0; i < 1; i++) {

                for (int j = 0; j < list_all_asig.size(); j++) {

                    if (!list_alu_asig.contains(list_all_asig.get(j).toString())) {
                        rg_asignaturas.addView(crearRadioButton(list_all_asig.get(j).toString()));
                    }
                }
            }
            list_all_asig.clear();
            list_alu_asig.clear();
        }
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