package com.FloPiDocs.FloPiDocs.Content.service;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Document;
import com.itextpdf.text.DocumentException;
import org.springframework.data.domain.Pageable;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * The interface Document service.
 */
@SuppressWarnings("UnnecessaryInterfaceModifier")
public interface DocumentService {
    /**
     * Save.
     *
     * @param document the document
     */
    public abstract void save(Document document);

    /**
     * Create document document dto.
     *
     * @param documentDTO the document dto
     * @return the document dto
     */
    public abstract com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDto createDocument(com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDto documentDTO);

    /**
     * Export document byte array input stream.
     *
     * @param documentId the document id
     * @return the byte array input stream
     * @throws FileNotFoundException the file not found exception
     * @throws DocumentException     the document exception
     */
    public ByteArrayInputStream exportDocument(String documentId) throws FileNotFoundException, DocumentException;

    /**
     * Find by title list.
     *
     * @param title the title
     * @return the list
     */
    public abstract List<com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDto> findByTitle(String title);

    /**
     * Find by id document dto.
     *
     * @param documentId the document id
     * @return the document dto
     * @throws Exception the exception
     */
    public abstract com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDto findById(String documentId) throws Exception;

    /**
     * Find by purpose list.
     *
     * @param purpose the purpose
     * @return the list
     */
    public abstract List<com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDto> findByPurpose(String purpose);

    /**
     * Find all list.
     *
     * @return the list
     */
    public abstract List<Document> findAll();

    /**
     * Find by user id list.
     *
     * @param userId   the user id
     * @param pageable the pageable
     * @return the list
     */
    public abstract List<Document> findByUserId(String userId, Pageable pageable);

    /**
     * Email exists boolean.
     *
     * @param email the email
     * @return the boolean
     */
    public abstract boolean emailExists(String email);

    /**
     * Delete by id document dto.
     *
     * @param documentDTO the document dto
     * @return the document dto
     * @throws Exception the exception
     */
    public com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDto deleteById(com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDto documentDTO) throws Exception;

    /**
     * Delete by user id.
     *
     * @param userId the user id
     */
    public abstract void deleteByUserId (String userId);

    /**
     * Delete by title.
     *
     * @param title the title
     */
    public abstract void deleteByTitle (String title);

    /**
     * Delete all.
     */
    public abstract void deleteAll ();

    /**
     * Delete all by user id.
     *
     * @param userId the user id
     */
    public abstract void deleteAllByUserId(String userId);

    /**
     * Find all by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    abstract List<com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDto> findAllByUserId(String userId);

    /**
     * Count by user id long.
     *
     * @param userId the user id
     * @return the long
     */
    public abstract Long countByUserId(String userId);

    /**
     * Find by user id and title list.
     *
     * @param userId the user id
     * @param title  the title
     * @return the list
     */
    public abstract List<com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDto> findByUserIdAndTitle(String userId, String title);

    /**
     * Find by user id and purpose list.
     *
     * @param userId the user id
     * @param title  the title
     * @return the list
     */
    public abstract List<com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDto> findByUserIdAndPurpose(String userId, String title);

    /**
     * Update.
     *
     * @param documentDTO the document dto
     * @throws Exception the exception
     */
    void update(com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDto documentDTO) throws Exception;

    /**
     * Find by user id and tag list.
     *
     * @param userId the user id
     * @param key    the key
     * @return the list
     * @throws Exception the exception
     */
    List<com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDto> findByUserIdAndTag(String userId, String key) throws Exception;
}
