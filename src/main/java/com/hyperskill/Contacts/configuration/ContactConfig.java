package com.hyperskill.Contacts.configuration;

import com.hyperskill.Contacts.models.Contact;
import com.hyperskill.Contacts.repositories.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Scanner;

@Configuration
public class ContactConfig {

    Scanner scanner = new Scanner(System.in);

    @Bean
    CommandLineRunner commandLineRunner(ContactRepository repository) {
        return args -> {
            System.out.println("Enter the name:");
            String name = scanner.next();
            System.out.println("Enter the phone number");
            String number = scanner.next();
            Contact contact = new Contact(name, number);
            repository.save(contact);
            System.out.println("A record created!");
        };
    }
}
