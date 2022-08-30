package com.hyperskill.Contacts.configuration;

import com.hyperskill.Contacts.models.Contact;
import com.hyperskill.Contacts.repositories.ContactRepository;
import com.hyperskill.Contacts.services.ContactService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class ContactConfig {

    Scanner scanner = new Scanner(System.in);
    boolean exit = false;

    @Bean
    CommandLineRunner commandLineRunner(ContactService contactService) {
        return args -> {
            do {
                System.out.println("Enter action (add, remove, edit, count, list, exit):");
                String action = scanner.next();
                switch (action) {
                    case "add":
                        System.out.println("Enter the name:");
                        String name = scanner.next();
                        System.out.println("Enter the number:");
                        String phoneNumber = scanner.next();
                        contactService.addNewContact(new Contact(name, phoneNumber));
                        System.out.println("The record added.");
                        break;
//                    case "remove":
//                        if (repository.count() == 0) {
//                            System.out.println("No records to remove!");
//                        } else {
//                            //phoneBook.displayRecords();
//                            repository.findAll();
//                            System.out.println("Select a record:");
//                            Long recordToRemove = scanner.nextLong();
//                            //phoneBook.removeRecords(recordToRemove);
//                            repository.deleteById(recordToRemove);
//                        }
//                        break;
//                    case "edit":
//                        if (phoneBook.countRecords() == 0) {
//                            System.out.println("No records to edit!");
//                        } else {
//                            phoneBook.displayRecords();
//                            System.out.println("Select a record:");
//                            int record = scanner.nextInt() - 1;
//                            phoneBook.editRecord(record);
//                        }
//                        break;
                    case "count":
                        System.out.println("The Phone Book has " + contactService.countRecords() + " records.");
                        break;
//                    case "list":
//                        phoneBook.displayRecords();
//                        break;
                    case "exit":
                        System.out.println("Exiting");
                        exit = true;
                        break;
                    default:
                        System.out.println("Choose a valid option");
                }
            } while (!exit);
        };
    }
}
