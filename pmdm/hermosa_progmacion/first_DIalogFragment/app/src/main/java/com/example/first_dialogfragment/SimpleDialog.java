package com.example.first_dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class SimpleDialog extends DialogFragment {

    public SimpleDialog() {


    }
    //interfaz
    public interface OnSimpleDialogListener {
        void onPossitiveButtonClick();// Eventos Botón Positivo
        void onNegativeButtonClick();// Eventos Botón Negativo
    }

    OnSimpleDialogListener listener;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        return createSimpleDialog();
    }


    //Creamos un diálogo

    public AlertDialog createSimpleDialog() {

        //creamos el builder
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //configuramos el dialog
        builder.setTitle("Titulo")
                .setMessage("¿Quiere cambiar el texto?")
                .setPositiveButton("Si",  //btn positivo
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                listener.onPossitiveButtonClick();

                            }
                        })
                .setNegativeButton("No", //btn negatigo
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                listener.onNegativeButtonClick();
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