package br.edu.ucsal.contatosadapter;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.edu.ucsal.contatosadapter.adapter.ContactAdapter;
import br.edu.ucsal.contatosadapter.dao.DBDao;
import br.edu.ucsal.contatosadapter.dto.ContactDto;
import br.edu.ucsal.contatosadapter.model.Contact;
import br.edu.ucsal.contatosadapter.service.ContactService;

public class MainActivity extends AppCompatActivity {

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

        ContactService service = new ContactService();
        ArrayList<ContactDto> contactDtoToAdapter = service.getAllContacts();

        RecyclerView recyclerView = findViewById(R.id.rv_card_contacts_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Cria o adapter passando a lista de contatos já convertida
        ContactAdapter adapter = new ContactAdapter(contactDtoToAdapter);

        recyclerView.setAdapter(adapter);

    }
}