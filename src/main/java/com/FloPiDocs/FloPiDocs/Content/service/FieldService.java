package com.FloPiDocs.FloPiDocs.Content.service;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Field;

import java.util.List;

/**
 * The interface Field service.
 */
@SuppressWarnings("ALL")
public interface FieldService {
    /**
     * Find by id field.
     *
     * @param id the id
     * @return the field
     */
    public abstract Field findById(String id);

    /**
     * Find by document id list.
     *
     * @param documentId the document id
     * @return the list
     */
    public abstract List<com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto> findByDocumentId(String documentId);

    /**
     * Delete by id field dto.
     *
     * @param id the id
     * @return the field dto
     */
    public abstract com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto deleteById(String id);

    /**
     * Delete all.
     */
    public abstract void deleteAll();

    /**
     * Count long.
     *
     * @return the long
     */
    public long count();

    /**
     * Save field dto.
     *
     * @param field the field
     * @return the field dto
     */
    public com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto save(com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto field);

    /**
     * Delete by document id.
     *
     * @param id the id
     */
    public abstract void deleteByDocumentId(String id);

    /**
     * Update field dto.
     *
     * @param fieldDTO the field dto
     * @return the field dto
     */
    com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto update(com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto fieldDTO);
}
