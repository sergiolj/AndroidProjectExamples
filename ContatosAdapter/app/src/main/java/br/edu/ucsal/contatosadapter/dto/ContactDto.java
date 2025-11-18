package br.edu.ucsal.contatosadapter.dto;

import br.edu.ucsal.contatosadapter.model.Contact;

public class ContactDto {
    private final String name;
    private final String email;
    private final String phone;

    public ContactDto(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    /**
     * Create a Data Transfer Object (DTO) from a given Contact from Database to prevent
     * exposing sensible data like socialSecurityNumber and address.
     * @param contact Class of object with sensible data.
     */
    public ContactDto(Contact contact){
        this.name = contact.getName();
        this.email = contact.getEmail();
        this.phone = contact.getPhone();
    }

    /**
     * Crea
     * @return a Contact class from ContactDto class
     */
    public Contact toContact(){
        return new Contact(
                this.name,
                this.email,
                this.phone,
                null,
                null
        );
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
