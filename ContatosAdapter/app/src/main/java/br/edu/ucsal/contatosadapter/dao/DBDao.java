package br.edu.ucsal.contatosadapter.dao;

import java.util.ArrayList;

import br.edu.ucsal.contatosadapter.model.Contact;

public class DBDao {
    private static DBDao instance = null;
    private final ArrayList<Contact> contacts;

    private DBDao() {
        this.contacts = new ArrayList<>();
        createMockedContacts();
    }

    public static DBDao getInstance() {
        if(instance == null){
            instance = new DBDao();
        }
        return instance;
    }

    public ArrayList<Contact> getContacts(){
        return this.contacts;
    }

    public void reset(){
        contacts.clear();
        createMockedContacts();
    }

    public void createMockedContacts(){
        contacts.add(new Contact(
                "Meryl Streep",
                "meryl.streep@hollywood.com",
                "(55) 555 10001",
                "123 Oscar Lane, New York, NY",
                "111-22-3344"));

        contacts.add(new Contact(
                "Scarlett Johansson",
                "scarlett.j@avengers.com",
                "(55) 555 20002",
                "890 Marvel Blvd, Los Angeles, CA",
                "222-33-4455"));

        contacts.add(new Contact(
                "Viola Davis",
                "viola.davis@oscar.com",
                "(55) 555 30003",
                "456 Drama Queen Ct, Beverly Hills, CA",
                "333-44-5566"));

        contacts.add(new Contact(
                "Jennifer Lawrence",
                "jlaw@mockingjay.com",
                "(55) 555 40004",
                "78 District 12 Rd, Louisville, KY",
                "444-55-6677"));

        contacts.add(new Contact(
                "Emma Stone",
                "emma.stone@lalaland.com",
                "(55) 555 50005",
                "321 City of Stars Ave, Los Angeles, CA",
                "555-66-7788"));

        contacts.add(new Contact(
                "Angelina Jolie",
                "angelina.jolie@eternals.com",
                "(55) 555 60006",
                "654 Tomb Raider St, Malibu, CA",
                "666-77-8899"));

        contacts.add(new Contact(
                "Margot Robbie",
                "margot.robbie@barbie.com",
                "(55) 555 70007",
                "99 Dreamhouse Drive, Malibu, CA",
                "777-88-9900"));

        contacts.add(new Contact(
                "Natalie Portman",
                "natalie.portman@thor.com",
                "(55) 555 80008",
                "12 Galaxy Way, Syosset, NY",
                "888-99-0011"));

        contacts.add(new Contact(
                "Anne Hathaway",
                "anne.hathaway@genovia.com", "(55) 555 90009",
                "77 Princess Diaries Ln, Millburn, NJ",
                "999-00-1122"));

        contacts.add(new Contact(
                "Julia Roberts", "julia.roberts@nottinghill.com",
                "(55) 555 01010",
                "55 Pretty Woman Blvd, Smyrna, GA",
                "000-11-2233"));
    }

}
