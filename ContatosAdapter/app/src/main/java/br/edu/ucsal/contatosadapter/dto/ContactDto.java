package br.edu.ucsal.contatosadapter.dto;

import br.edu.ucsal.contatosadapter.model.Contact;

public class ContactDto {
    private final Long id;
    private final String name;
    private final String email;
    private final String phone;

    public ContactDto(Long id, String name, String email, String phone) {
        this.id = id;
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
        this.id = contact.getId();
        this.name = contact.getName();
        this.email = contact.getEmail();
        this.phone = contact.getPhone();
    }

    public ContactDto() {
        this(null,null,null,null);
    }

    /**
     * Crea
     * @return a Contact class from ContactDto class
     */
    public Contact fromDtoToContact(){
        return new Contact(id,name, email, phone,null,null);
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

    public Long getId() {
        return id;
    }
}

