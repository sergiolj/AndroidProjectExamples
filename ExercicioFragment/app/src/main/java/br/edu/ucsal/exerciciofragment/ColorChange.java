package br.edu.ucsal.exerciciofragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ColorChange extends Fragment {

    private ColorChangeListener listener;

    public interface ColorChangeListener{
        void onButtonSelected(int color, int stringId);
    }

    public ColorChange() {
        // Required empty public constructor
    }

    /**
     * IMPLEMENTA A COMUNICAÇÃO COM A ACTIVITY
     * @param context
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ColorChangeListener) {
            listener = (ColorChangeListener) context;
        } else {
            throw new RuntimeException(context.toString() +
                    "Activity deve implementar ColorChangeListener");
        }
    }


    /**
     * Método onCreate() usado para instanciar variáveis lógicas, recuperar argumentos, configurar ViewModels
     * NÃO É ESSENCIAL
     * @param savedInstanceState If the fragment is being re-created from
     * a previous saved state, this is the state.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    /**
     * USE ESSE APENAS PARA INFLAR A FRAGMENT
     * @return view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_color_change, container, false);
    }

    /**
     * Método onViewCreated()  usado após a criação da View pelo onCreateView() para configurar elementos de tela como botões
     * e listeners em uma fragment
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnRed = view.findViewById(R.id.btn_red);
        Button btnGreen = view.findViewById(R.id.btn_green);
        Button btnBlue = view.findViewById(R.id.btn_blue);

        // Forma usando lambda onde View é a referência de objeto que será monitorado, no caso o
        // próprio btnRed
        btnRed.setOnClickListener(v ->
                listener.onButtonSelected(Color.RED, R.string.red));

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonSelected(Color.GREEN,R.string.green);
            }
        });

        btnBlue.setOnClickListener(v ->
                listener.onButtonSelected(Color.BLUE, R.string.blue));
    }
}