package com.hyperskill.Contacts.repositories;

import com.hyperskill.Contacts.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    // SELECT * FROM contact WHERE phoneNumber = ? Se estaría realizando este query por detrás
    Optional<Contact> findContactByPhoneNumber(String number);

}
