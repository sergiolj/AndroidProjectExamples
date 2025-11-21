package br.edu.ucsal.contatosadapter;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import br.edu.ucsal.contatosadapter.adapter.ContactAdapter;
import br.edu.ucsal.contatosadapter.dto.ContactDto;
import br.edu.ucsal.contatosadapter.service.ContactService;

public class MainActivity extends AppCompatActivity implements ContactAdapter.ContactAdapterListener {

    private ContactService service;
    private ContactAdapter adapter;

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

        service = new ContactService();
        service.reset();

        adapter = new ContactAdapter(service.getAllContacts(), this);

        RecyclerView recyclerView = findViewById(R.id.rv_card_contacts_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);

        Button btnReset = findViewById(R.id.btn_reset);

        btnReset.setOnClickListener(v -> {
            service.reset();
            adapter.setContacts(service.getAllContacts());
            adapter.notifyDataSetChanged();
        });

    }
    public void onContactClick(ContactDto clickedContactDto, int position) {
                if(position == RecyclerView.NO_POSITION) return;

                Long id = clickedContactDto.getId();
                service.remove(id);
                adapter.setContacts(service.getAllContacts());
            }
}