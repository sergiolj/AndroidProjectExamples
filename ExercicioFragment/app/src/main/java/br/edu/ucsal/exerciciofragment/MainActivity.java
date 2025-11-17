package br.edu.ucsal.exerciciofragment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements ColorChange.ColorChangeListener {

    private TextView textToChange;

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

        textToChange = findViewById(R.id.tv_main_to_change);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_fragment, new ColorChange())
                .commit();
    }

    @Override
    public void onButtonSelected(int color, int stringId) {
        textToChange.setText(getString(stringId));
        textToChange.setTextColor(color);
    }
}