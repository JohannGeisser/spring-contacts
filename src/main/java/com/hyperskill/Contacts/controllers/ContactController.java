package com.hyperskill.Contacts.controllers;

import com.hyperskill.Contacts.models.Contact;
import com.hyperskill.Contacts.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> getContacts() {
        return contactService.getContacts();
    }

    @PostMapping
    public void registerNewContact(@RequestBody Contact contact) {
        contactService.addNewContact(contact);
    }

    @DeleteMapping(path = "{contactId}")
    public void deleteContact(@PathVariable("contactId") Long contactId) {
        contactService.deleteContact(contactId);
    }

    @PutMapping(path = "{contactId}")
    public void updateContact(
            @PathVariable("contactId") Long contactId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String number) {
        contactService.updateContact(contactId, name, number);

    }
}
