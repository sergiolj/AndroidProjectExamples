package br.edu.ucsal.contatosadapter.util;

import java.util.ArrayList;
import java.util.List;

import br.edu.ucsal.contatosadapter.model.Contact;

public class MockDataFactory {

    public static List<Contact> createMockedContacts(){
        List<Contact> list = new ArrayList<>();
        list.add(new Contact(null,
                "Meryl Streep",
                "meryl.streep@hollywood.com",
                "(55) 555 10001",
                "123 Oscar Lane, New York, NY",
                "111-22-3344"));

        list.add(new Contact(null,
                "Scarlett Johansson",
                "scarlett.j@avengers.com",
                "(55) 555 20002",
                "890 Marvel Blvd, Los Angeles, CA",
                "222-33-4455"));

        list.add(new Contact(null,
                "Viola Davis",
                "viola.davis@oscar.com",
                "(55) 555 30003",
                "456 Drama Queen Ct, Beverly Hills, CA",
                "333-44-5566"));

        list.add(new Contact(null,
                "Jennifer Lawrence",
                "jlaw@mockingjay.com",
                "(55) 555 40004",
                "78 District 12 Rd, Louisville, KY",
                "444-55-6677"));

        list.add(new Contact(null,
                "Emma Stone",
                "emma.stone@lalaland.com",
                "(55) 555 50005",
                "321 City of Stars Ave, Los Angeles, CA",
                "555-66-7788"));

        list.add(new Contact(null,
                "Angelina Jolie",
                "angelina.jolie@eternals.com",
                "(55) 555 60006",
                "654 Tomb Raider St, Malibu, CA",
                "666-77-8899"));

        list.add(new Contact(null,
                "Margot Robbie",
                "margot.robbie@barbie.com",
                "(55) 555 70007",
                "99 Dreamhouse Drive, Malibu, CA",
                "777-88-9900"));

        list.add(new Contact(null,
                "Natalie Portman",
                "natalie.portman@thor.com",
                "(55) 555 80008",
                "12 Galaxy Way, Syosset, NY",
                "888-99-0011"));

        list.add(new Contact(null,
                "Anne Hathaway",
                "anne.hathaway@genovia.com", "(55) 555 90009",
                "77 Princess Diaries Ln, Millburn, NJ",
                "999-00-1122"));

        list.add(new Contact(null,
                "Julia Roberts", "julia.roberts@nottinghill.com",
                "(55) 555 01010",
                "55 Pretty Woman Blvd, Smyrna, GA",
                "000-11-2233"));

        return list;
    }


}
