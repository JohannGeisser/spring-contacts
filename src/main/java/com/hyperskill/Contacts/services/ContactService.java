package com.hyperskill.Contacts.services;

import com.hyperskill.Contacts.models.Contact;
import com.hyperskill.Contacts.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    public void addNewContact(Contact contact) {
        Optional<Contact> contactOptional = contactRepository.findContactByPhoneNumber(contact.getPhoneNumber());
        if (contactOptional.isPresent()) {
            throw new IllegalStateException("Phone Number already taken");
        }
        contactRepository.save(contact);
    }

    public void deleteContact(Long contactId) {
        boolean exists = contactRepository.existsById(contactId);
        if (!exists) {
            throw new IllegalStateException("contact with id " + contactId + " does not exists");
        }
        contactRepository.deleteById(contactId);
    }

    @Transactional
    public void updateContact(Long contactId, String name, String number) {

        Contact contact = contactRepository.findById(contactId).orElseThrow(() -> new IllegalStateException("contact with id " + contactId + " does not exists"));

        if (name != null && name.length() > 0 && !Objects.equals(contact.getName(), name)) {
            contact.setName(name);
        }
        if (number != null && number.length() > 0 && !Objects.equals(contact.getPhoneNumber(), number)) {
            contact.setPhoneNumber(number);
        }

    }
}
