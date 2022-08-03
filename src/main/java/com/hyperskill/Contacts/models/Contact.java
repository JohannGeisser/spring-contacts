package com.hyperskill.Contacts.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contact {
    private Long id;
    private String name;
    private String phoneNumber;

    public Contact() {
    }

    public Contact(Long id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


}
