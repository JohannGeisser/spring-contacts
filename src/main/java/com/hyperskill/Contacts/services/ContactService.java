package com.hyperskill.Contacts.services;

import com.hyperskill.Contacts.models.Contact;
import com.hyperskill.Contacts.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final Scanner scanner = new Scanner(System.in);

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

    public long countRecords() {
        return contactRepository.count();
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

    public void displayRecords() {
        List<Contact> records = contactRepository.findAll();
        for (int i = 0; i < records.size(); i++) {
            System.out.println(records.get(i));
        }
    }

    @Transactional
    public void updateContactById(Long contactId) {
        System.out.println("Select a field (name, number):");
        String field = scanner.next();
        Contact contact = contactRepository.findById(contactId).orElseThrow(() -> new IllegalStateException("contact with id " + contactId + " does not exists"));
        switch (field) {
            case "name":
                System.out.println("Enter the name:");
                String newName = scanner.next();
                contact.setName(newName);
                System.out.println("The record updated!");
                break;
            case "number":
                System.out.println("Enter the number:");
                String newNumber = scanner.next();
                contact.setPhoneNumber(newNumber);
                System.out.println("The record updated!");
                break;
            default:
                System.out.println("No valid option");
        }
    }

}
