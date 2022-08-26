package com.hyperskill.Contacts.services;

import com.hyperskill.Contacts.models.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    public List<Contact> getContacts() {
        return List.of(new Contact(1L, "Johann", "75816516"));
    }

}
