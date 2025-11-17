package br.edu.ucsal.gridbuttonsnumered;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TableLayout tableLayout;
    private LayoutInflater inflater;
    private static int btnNumber = 0;
    private ToneGenerator toneGenerator;

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

        tableLayout = findViewById(R.id.lay_table_layout);
        inflater = LayoutInflater.from(this);
        //tableLayout.setStretchAllColumns(true);
        //tableLayout.setScaleY(1.5f);
        tableLayout.setShrinkAllColumns(true);

        toneGenerator =  new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
        createButtonsInTableLayout();

    }

    private void createButtonsInTableLayout() {
        for(int row=0; row <4; row++){
            TableRow tableRow = new TableRow(this);

            for(int col=0; col<4; col++){
                Button btn = (Button) inflater.inflate(R.layout.my_button, tableRow, false);
                btn.setText(String.valueOf(btnNumber));
                btn.setId(btnNumber);
                btn.setOnClickListener(this::soundClick);
                btnNumber++;
                tableRow.addView(btn);
            }
            tableLayout.addView(tableRow);

// O TableLayout ignora as definições de altura e largura dos elementos filhos e se ajusta apenas ao
// seu conteúdo por padrão, por isso esse código é inútil nesse caso. Para burlar esse comportamento
// se usa tableLayout.setStretchAllColumns(true);
//            ViewGroup.LayoutParams params = new TableLayout.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT,
//                    ViewGroup.LayoutParams.WRAP_CONTENT);
//
//            tableRow.setLayoutParams(params);

        }
    }

    private void soundClick(View view) {
        toneGenerator.startTone(
                ToneGenerator.TONE_DTMF_0 + (view.getId() % 10), 150);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(toneGenerator != null){
            toneGenerator.release();
            toneGenerator = null;
        }
    }
}