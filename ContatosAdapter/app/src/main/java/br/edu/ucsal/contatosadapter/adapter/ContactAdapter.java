package br.edu.ucsal.contatosadapter.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.edu.ucsal.contatosadapter.R;
import br.edu.ucsal.contatosadapter.dto.ContactDto;
import br.edu.ucsal.contatosadapter.service.ContactService;

/*
    1 - Crie a classe adapter e extenda a classe abstrata RecyclerView.Adapter<Essa classe espera
    receber como parâmetro um RecyclerViewHolder>, mas essa classe ainda não existe!

    public class ContactAdapter extends RecyclerView.Adapter<>

    Por isso, o próximo passo é a criação personalizada dessa classe aninhada ContactViewHolder que
    estende RecyclerView.ViewHolder
 */

/*
    3- Com a classe criada pode-se agora adicionar a informação à assinatura da classe principal

    public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>

 */
/*
    4- Em seguida se solita à IDE a implementação dos métodos da classe RecyclerView.ViewHolder
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    /*
    2 - Criar a classe aninhada que foi passada como parâmetro para o Adapter
 */
    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        /*
            O construtor da classe ViewHolder pode ser chamado pela IDE para definir
            o que vai ser segurado.
         */
        TextView name;
        TextView email;
        TextView phone;
        TextView id;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.tv_name);
            this.email = itemView.findViewById(R.id.tv_email);
            this.phone = itemView.findViewById(R.id.tv_phone);
            this.id = itemView.findViewById(R.id.tv_id);
        }
    }
        public interface ContactAdapterListener {
            void onContactClick(ContactDto contactDto, int position);
        }

        private final ContactService service = new ContactService();
        private ArrayList<ContactDto> dtoContacts;
        private ContactAdapterListener listener;

        public ContactAdapter(ArrayList<ContactDto> dtoContacts, ContactAdapterListener listener) {
            this.listener = listener;
            this.dtoContacts = dtoContacts;
        }

        @NonNull
        @Override
        public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.contatos_card, parent, false);

            return new ContactViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
            ContactDto currentContact = dtoContacts.get(position);

            holder.name.setText(currentContact.getName());
            holder.email.setText(currentContact.getEmail());
            holder.phone.setText(currentContact.getPhone());
            holder.id.setText(String.valueOf(currentContact.getId()));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        listener.onContactClick(currentContact, holder.getBindingAdapterPosition());
                    }
                }
            });
        }

        public void setContacts(ArrayList<ContactDto> updatedContacts) {
            this.dtoContacts = updatedContacts;
            notifyDataSetChanged();
        }

        @Override
        public int getItemCount() {
            return service.getSize();
        }
    }


