package com.FloPiDocs.FloPiDocs.dbUtils;

import com.FloPiDocs.FloPiDocs.Content.repository.DocumentRepository;
import com.FloPiDocs.FloPiDocs.Content.entities.Document;
import com.FloPiDocs.FloPiDocs.Content.entities.Tag;
import com.FloPiDocs.FloPiDocs.Content.entities.User;
import com.FloPiDocs.FloPiDocs.Content.repository.TagRepository;
import com.FloPiDocs.FloPiDocs.Content.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Calendar;

public class DbUtils implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private static DocumentRepository documentRepository;

    //Guille sigue sin funcionar
    @Override
    public void run(String... args) throws Exception {
		userRepositoryCode();
        documentRepositoryCode();
		tagRepositoryCode();
    }

    private void userRepositoryCode() {
        userRepository.deleteAll();
        userRepository.save(new User("Jesus2", "DeLaLama", "elaltas2@gmail.com"));
    }

    private static void documentRepositoryCode() {
		documentRepository.deleteAll();
//        documentRepository.save(new Document( "5f85ae58f6f324720441a6c9", "titulo de documento", "propósito", Calendar.getInstance().getTime().toString()));
    }

    private void tagRepositoryCode() {
        tagRepository.deleteAll();
//        tagRepository.save(new Tag("5f84689dfe31712cf8a87d97","nombretag", "5f846dbf32b25b03865a570d" ));
    }


}
