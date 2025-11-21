package br.edu.ucsal.contatosadapter.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.ucsal.contatosadapter.model.Contact;

public class DBDao {
    private static DBDao instance = null;
    private final ArrayList<Contact> contacts;
    private static Long idGlobal = 0L;

    private DBDao() {
        this.contacts = new ArrayList<>();
    }

    public static DBDao getInstance() {
        if(instance == null){
            instance = new DBDao();
        }
        return instance;
    }

//    /**
//     * Usado para impedir o uso do método add da lista que iria contornar a regra de negócio da
//     * criação do id.
//     * O problema dessa estratégia é que o desenvedor não será avisado que trabalha com uma
//     * cópia da lista do BD e não o original.
//     *
//     * @return Disponibiliza uma nova lista com uma cópia dos dados para que a lista
//     * original não seja modificada usando os métodos de ArrayList
//     */
//    public ArrayList<Contact> getContacts(){
//        return new ArrayList<>(contacts);
//    }

    /**
     * Impede o uso de métodos implementados em ArrayList para modificar a lista, o que poderia
     * causar erros de id nos registros.
     *
     * @return disponibiliza uma lista somente leitura impedindo a modificação da lista sem usar
     * o método DBDao.addContact()
     */
    public List<Contact> getContacts(){
        return Collections.unmodifiableList(contacts);
    }

    public void resetContacts(){
        this.contacts.clear();
    }

    public void addContact(Contact contact){
        generateNewId(contact);
        contacts.add(contact);
    }

    private void generateNewId(Contact contact) {
        if(contact.getId()==null){
            contact.setId(++idGlobal);
        }
    }

    public void removeContact(Long id) {
        contacts.removeIf(user-> user.getId().equals(id));
    }

}
