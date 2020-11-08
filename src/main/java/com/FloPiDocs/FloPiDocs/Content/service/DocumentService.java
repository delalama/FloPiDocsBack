package com.FloPiDocs.FloPiDocs.Content.service;

import com.FloPiDocs.FloPiDocs.Content.entities.Document;
import com.FloPiDocs.FloPiDocs.Content.entities.dto.DocumentDTO;
import org.springframework.data.domain.Pageable;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

public interface DocumentService {
    public abstract void save(Document document);
    public abstract Document createDocument(Document document);
    public abstract List<Document> findByTitle(String title);
    public abstract DocumentDTO findById(String documentId) throws Exception;
    public abstract List<Document> findByPurpose(String purpose);
    public abstract List<Document> findAll();
    public abstract List<Document> findByUserId(String userId, Pageable pageable);
    public abstract boolean emailExists(String email);
    public abstract void deleteById(String documentId);
    public abstract void deleteByUserId (String userId);
    public abstract void deleteByTitle (String title);
    public abstract void deleteAll ();
    public abstract void deleteAllByUserId(String userId);
    public abstract List<Document>findAllByUserId(String userId);
    public abstract Long countByUserId(String userId);
    public abstract List<Document> findByTitleAndPurposeContains(String title);
}
