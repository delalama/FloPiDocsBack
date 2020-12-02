package com.FloPiDocs.FloPiDocs.Content.service;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Document;
import com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDTO;
import com.itextpdf.text.DocumentException;
import org.springframework.data.domain.Pageable;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.List;

@SuppressWarnings("UnnecessaryInterfaceModifier")
public interface DocumentService {
    public abstract void save(Document document);
    public abstract DocumentDTO createDocument(DocumentDTO documentDTO);

    public ByteArrayInputStream exportDocument(String documentId) throws FileNotFoundException, DocumentException;

    public abstract List<DocumentDTO> findByTitle(String title);
    public abstract DocumentDTO findById(String documentId) throws Exception;
    public abstract List<DocumentDTO> findByPurpose(String purpose);
    public abstract List<Document> findAll();
    public abstract List<Document> findByUserId(String userId, Pageable pageable);
    public abstract boolean emailExists(String email);
    public DocumentDTO deleteById(DocumentDTO documentDTO) throws Exception;
    public abstract void deleteByUserId (String userId);
    public abstract void deleteByTitle (String title);
    public abstract void deleteAll ();
    public abstract void deleteAllByUserId(String userId);

    abstract List<DocumentDTO> findAllByUserId(String userId);
    public abstract Long countByUserId(String userId);
    public abstract List<DocumentDTO> findByUserIdAndTitle(String userId, String title);
    public abstract List<DocumentDTO> findByUserIdAndPurpose(String userId, String title);

    void update(DocumentDTO documentDTO) throws Exception;

    List<DocumentDTO> findByUserIdAndTag(String userId, String key) throws Exception;
}
