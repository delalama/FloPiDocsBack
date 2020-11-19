package com.FloPiDocs.FloPiDocs.Content.service;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Document;
import com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SuppressWarnings("UnnecessaryInterfaceModifier")
public interface DocumentService {
    public abstract void save(Document document);
    public abstract Document createDocument(Document document);
    public abstract List<Document> findByTitle(String title);
    public abstract DocumentDTO findById(String documentId) throws Exception;
    public abstract List<Document> findByPurpose(String purpose);
    public abstract List<Document> findAll();
    public abstract List<Document> findByUserId(String userId, Pageable pageable);
    public abstract boolean emailExists(String email);
    public DocumentDTO deleteById(DocumentDTO documentDTO) throws Exception;
    public abstract void deleteByUserId (String userId);
    public abstract void deleteByTitle (String title);
    public abstract void deleteAll ();
    public abstract void deleteAllByUserId(String userId);
    public abstract List<Document>findAllByUserId(String userId);
    public abstract Long countByUserId(String userId);
    public abstract List<Document> findByUserIdAndTitle(String userId, String title);
    public abstract List<Document> findByUserIdAndPurpose(String userId, String title);

    void update(DocumentDTO documentDTO) throws Exception;

    List<DocumentDTO> findByUserIdAndTag(String userId, String key) throws Exception;
}
