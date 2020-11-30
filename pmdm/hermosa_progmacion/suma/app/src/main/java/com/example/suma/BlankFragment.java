package com.example.suma;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText et_num_1;
    private EditText et_num_2;
    private TextView tv_result;
    private Button btn_suma;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        //identificando cada elemento con su id
        et_num_1 = (EditText) view.findViewById(R.id.num_1);
        et_num_2 = (EditText) view.findViewById(R.id.num_2);
        tv_result = (TextView) view.findViewById(R.id.tv_result);
        btn_suma = (Button) view.findViewById(R.id.btn_suma);
        //añadiendo listener al btn_suma
        btn_suma.setOnClickListener(new btn_listener());
        // Inflate the layout for this fragment
        return view;
    }
    //clase para btn_suma
    class btn_listener implements View.OnClickListener {

        int num_1;
        int num_2;
        int suma;

        @Override
        public void onClick(View v) {

            suma();//llamando al metodo suma

        }
        //metodo para realizar la suma
        public void suma() {

            try {

                num_1 = Integer.parseInt(et_num_1.getText().toString());
                num_2 = Integer.parseInt(et_num_2.getText().toString());
                suma = num_1 + num_2;

                tv_result.setText(num_1 + " + " + num_2 + " = " + Integer.toString(suma));

            }catch (Exception e) {

                tv_result.setText("Introduzca numeros");
            }
        }
    }
}