package com.hyperskill.Contacts.configuration;

import com.hyperskill.Contacts.models.Contact;
import com.hyperskill.Contacts.repositories.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ContactConfig {

    @Bean
    CommandLineRunner commandLineRunner(ContactRepository repository) {
        return args -> {
            Contact johann = new Contact("Johann", "75816516");
            Contact dobid = new Contact("Dobid", "74364534");

            repository.saveAll(List.of(johann, dobid));
        };
    }
}
