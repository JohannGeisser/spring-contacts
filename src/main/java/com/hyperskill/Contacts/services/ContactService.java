package com.hyperskill.Contacts.services;

import com.hyperskill.Contacts.models.Contact;

import java.util.List;

public class ContactService {

    public List<Contact> getContacts() {
        return List.of(new Contact(1L, "Johann", "75816516"));
    }

}
