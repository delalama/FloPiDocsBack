package com.FloPiDocs.FloPiDocs.dbUtils;

import com.FloPiDocs.FloPiDocs.Content.repository.DocumentRepository;
import com.FloPiDocs.FloPiDocs.Content.entities.Document;
import com.FloPiDocs.FloPiDocs.Content.entities.Tag;
import com.FloPiDocs.FloPiDocs.Content.entities.User;
import com.FloPiDocs.FloPiDocs.Content.repository.TagRepository;
import com.FloPiDocs.FloPiDocs.Content.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;

public class DbUtils {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private static DocumentRepository documentRepository;

    public DbUtils(){
    }

    public static void actions(){
        //		customerRepositoryCode();
//		userRepositoryCode();
        documentRepositoryCode();
//		tagRepositoryCode();
    }

    private static void documentRepositoryCode() {
//		documentRepository.deleteAll();
        System.out.println(documentRepository.findAll());
        documentRepository.save(new Document( "5f85ae58f6f324720441a6c9", "titulo de documento", "propósito", Calendar.getInstance().getTime().toString()));
    }

    private void tagRepositoryCode() {
        tagRepository.save(new Tag("5f84689dfe31712cf8a87d97","nombretag", "5f846dbf32b25b03865a570d" ));
    }

    private void userRepositoryCode() {
        userRepository.deleteAll();
        userRepository.save(new User("Jesus", "DeLaLama", "elaltas@gmail.com"));
    }

}
