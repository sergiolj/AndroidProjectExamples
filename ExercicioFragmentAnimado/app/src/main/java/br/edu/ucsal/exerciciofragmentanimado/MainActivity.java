package br.edu.ucsal.exerciciofragmentanimado;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import br.edu.ucsal.exerciciofragmentanimado.fragment.ColorChanger;

public class MainActivity extends AppCompatActivity implements ColorChanger.ColorChangerListener {

    private TextView textView;
    private BottomSheetBehavior<View> bottomSheetBehaviour;
    private Boolean onOffSwitch = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView = findViewById(R.id.tv_activity);

        //slideFromBottom();
        bottomGoneVisible();


    }

    private void bottomGoneVisible() {
        Button onOffSettings = findViewById(R.id.btn_onOff);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_fragment, new ColorChanger())
                .commit();

        View fragment_container = findViewById(R.id.container_fragment);
        onOffSettings.setOnClickListener(v -> {
            if(onOffSwitch){
                fragment_container.setVisibility(View.GONE);
            }else{
                fragment_container.setVisibility(View.VISIBLE);
            }
        });

    }

    private void slideFromBottom() {
        //Define o espaço container especificado no XML da Activity
        View bottomSheet = findViewById(R.id.container_fragment);

        //Define as características do container
        bottomSheetBehaviour = BottomSheetBehavior.from(bottomSheet);
        bottomSheetBehaviour.setState(BottomSheetBehavior.STATE_COLLAPSED);
        bottomSheetBehaviour.setPeekHeight(100);

        //
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_fragment, new ColorChanger())
                .commit();
    }

    @Override
    public void onClickChangeTextValues(int color, int stringId) {
        textView.setTextColor(color);
        textView.setText(getString(stringId));
    }
}