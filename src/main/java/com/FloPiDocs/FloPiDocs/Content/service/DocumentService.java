package com.FloPiDocs.FloPiDocs.Content.service;

import com.FloPiDocs.FloPiDocs.Content.entities.Document;

import java.util.List;

public interface DocumentService {
    public abstract Document createDocument(Document document);
    public abstract List<Document> findByTitle(String title);
    public abstract Document findById(String documentId);
    public abstract List<Document> findByPurpose(String purpose);
    public abstract List<Document> findAll();
    public abstract List<Document> findByUserId(String userId);
    public abstract boolean emailExists(String email);
    public abstract void deleteById(String documentId);
    public abstract void deleteByUserId (String userId);
    public abstract void deleteByTitle (String title);
    public abstract void deleteAll ();
    public abstract void save(Document document);

    void deleteAllByUserId(String userId);
}
