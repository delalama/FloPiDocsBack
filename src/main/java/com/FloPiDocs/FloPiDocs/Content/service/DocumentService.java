package com.FloPiDocs.FloPiDocs.Content.service;

import com.FloPiDocs.FloPiDocs.Content.entities.Document;

import java.util.List;

public interface DocumentService {
    public abstract void createDocument(Document document);
    public abstract void deleteDocument(String id);
    public abstract Document findByAuthor(String author);
    public abstract List<Document> findByTitle(String title);
    public abstract List<Document> findByPurpose(String purpose);
    public abstract List<Document> findAll();
    public abstract List<Document> findByUserId(String userId);
    public abstract boolean emailExists(String email);
    public void deleteByUserId (String userId);
    public void deleteByTitle (String title);
}
