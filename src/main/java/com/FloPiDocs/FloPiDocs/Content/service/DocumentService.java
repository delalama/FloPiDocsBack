package com.FloPiDocs.FloPiDocs.Content.service;

import com.FloPiDocs.FloPiDocs.Content.entities.Document;

import java.util.List;

public interface DocumentService {
    public abstract void createDocument(Document document);
    public abstract void deleteDocument(Long id);
    public abstract Document findByAuthor(String author);
    public abstract List<Document> findByTitle(String title);
    public abstract List<Document> findByPurpose(String purpose);
    public abstract List<Document> findAll();
    public abstract List<Document> findByUserId(Long userId);
    public abstract boolean emailExists(String email);
    public abstract void deleteByUserId (Long userId);
    public abstract void deleteByTitle (String title);
    public abstract void deleteAll ();
    public abstract void save(Document document);
}
