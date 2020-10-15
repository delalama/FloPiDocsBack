package com.FloPiDocs.FloPiDocs.Content.service.impl;

import com.FloPiDocs.FloPiDocs.Content.entities.Document;
import com.FloPiDocs.FloPiDocs.Content.entities.User;
import com.FloPiDocs.FloPiDocs.Content.repository.DocumentRepository;
import com.FloPiDocs.FloPiDocs.Content.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    DocumentRepository documentRepository;

    @Override
    public void createDocument(Document document) {
        documentRepository.save(document);
    }

    @Override
    public void deleteDocument(Long id) {

    }

    @Override
    public Document findByAuthor(String s) {
        return null;
    }

    @Override
    public List<Document> findByTitle(String title) {
        return documentRepository.findByTitle(title);
    }

    @Override
    public List<Document> findByPurpose(String purpose) {
        return documentRepository.findByPurpose(purpose);
    }

    @Override
    public List<Document> findAll() {
        return null;
    }

    @Override
    public List<Document> findByUserId(Long userId) {
        return documentRepository.findByUserId(userId);

    }

    @Override
    public boolean emailExists(String email) {
        return false;
    }

    @Override
    public void deleteByUserId(Long userId) {
        documentRepository.deleteByUserId(userId);
    }

    @Override
    public void deleteByTitle(String title) {
        documentRepository.deleteByTitle(title);
    }

    @Override
    public void deleteAll() {
        documentRepository.deleteAll();
    }

    @Override
    public void save(Document document) {
        documentRepository.save(document);
    }

}
