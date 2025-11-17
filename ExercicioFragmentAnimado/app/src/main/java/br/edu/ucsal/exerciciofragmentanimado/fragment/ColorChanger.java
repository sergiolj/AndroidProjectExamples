package br.edu.ucsal.exerciciofragmentanimado.fragment;

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

import br.edu.ucsal.exerciciofragmentanimado.R;

public class ColorChanger extends Fragment {

    public ColorChangerListener listener;

    public interface ColorChangerListener{
        void onClickChangeTextValues(int color, int stringId);
    }
    public ColorChanger() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof ColorChangerListener){
            listener = (ColorChangerListener) context;
        }else{
            throw new RuntimeException(context.toString() +
            "ColorChangeListener interface methods must be implemented");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color_changer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnRed = view.findViewById(R.id.btn_red);
        Button btnBlue = view.findViewById(R.id.btn_blue);
        Button btnGreen = view.findViewById(R.id.btn_green);


        btnRed.setOnClickListener(v ->
                listener.onClickChangeTextValues(Color.RED, R.string.red));
        btnBlue.setOnClickListener(v ->
                listener.onClickChangeTextValues(Color.BLUE, R.string.blue));

        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickChangeTextValues(Color.GREEN, R.string.green);
            }
        });

    }
}