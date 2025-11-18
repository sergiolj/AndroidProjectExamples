package br.edu.ucsal.contatosadapter.service;

import java.util.ArrayList;

import br.edu.ucsal.contatosadapter.dao.DBDao;
import br.edu.ucsal.contatosadapter.dto.ContactDto;
import br.edu.ucsal.contatosadapter.model.Contact;

public class ContactService {

    private ArrayList<Contact> rawContactsTable;
    private ArrayList<ContactDto> dtoContacts;

    public ContactService(){
        //Simula conexão com o BD
        DBDao dao = DBDao.getInstance();

        //Simula o acesso à tabela de contatos
        this.rawContactsTable = dao.getContacts();

        this.dtoContacts = new ArrayList<>();
    }

    public ArrayList<ContactDto> getAllContacts() {

        for (Contact contact : rawContactsTable) {
            ContactDto dto = new ContactDto(contact);
            dtoContacts.add(dto);
        }
        return dtoContacts;
    }

}
