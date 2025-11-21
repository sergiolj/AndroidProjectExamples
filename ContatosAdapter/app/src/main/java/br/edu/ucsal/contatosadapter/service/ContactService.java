package br.edu.ucsal.contatosadapter.service;

import java.util.ArrayList;
import java.util.List;

import br.edu.ucsal.contatosadapter.dao.DBDao;
import br.edu.ucsal.contatosadapter.dto.ContactDto;
import br.edu.ucsal.contatosadapter.model.Contact;
import br.edu.ucsal.contatosadapter.util.MockDataFactory;

public class ContactService {

    private final DBDao dao;

    /**
     * Define a connection with the "Simulated DataBase"
     */
    public ContactService(){
        dao = DBDao.getInstance();
    }

    /**
     * Retrieve all contact data from DataBase filtered by Data Transfer Object
     * @return ArrayList DTO from Contacts
     */
    public ArrayList<ContactDto> getAllContacts() {
        List<Contact> rawContactsCopy = dao.getContacts();
        ArrayList<ContactDto> dtoContacts = new ArrayList<>();

        for (Contact contact : rawContactsCopy) {
            ContactDto dto = new ContactDto(contact);
            dtoContacts.add(dto);
        }
        return dtoContacts;
    }

    /**
     * Remove a specific Contact Object by his id.
     * @param id is the DataBase unique identifier.
     */
    public void remove(Long id){
        if(id == null) return;
        dao.removeContact(id);
    }

    /**
     * Reset DataBase with mocked data
     */
    public void reset() {
        dao.resetContacts();
        List<Contact> list = MockDataFactory.createMockedContacts();
        for(Contact contact: list){
            dao.addContact(contact);
        }
    }

    /**
     *
     * @return DataBase number of rows or objects.
     */
    public int getSize(){
        return dao.getContacts().size();
    }
}
