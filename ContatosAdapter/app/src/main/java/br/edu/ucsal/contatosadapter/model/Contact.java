package br.edu.ucsal.contatosadapter.model;

import br.edu.ucsal.contatosadapter.dto.ContactDto;

public class Contact {

    private String name;
    private String email;
    private String phone;
    private String address;
    private String socialSecurityNumber;

    public Contact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Contact(String name, String email, String phone, String address, String socialSecurityNumber) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this. socialSecurityNumber = socialSecurityNumber;
    }

    public Contact(String name){}


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setCPF(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }
}
