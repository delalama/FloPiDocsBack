package com.FloPiDocs.FloPiDocs.Content.service;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Tag;

import java.util.List;

/**
 * The interface Tag service.
 */
@SuppressWarnings("ALL")
public interface TagService {
    /**
     * Find by tag id tag.
     *
     * @param id the id
     * @return the tag
     */
    public abstract Tag findByTagId(String id);

    /**
     * Find by document id list.
     *
     * @param documentId the document id
     * @return the list
     */
    public abstract List<com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto> findByDocumentId(String documentId);

    /**
     * Find by tag name list.
     *
     * @param tagName the tag name
     * @return the list
     */
    List<com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto> findByTagName(String tagName);

    /**
     * Find by user id and tag name list.
     *
     * @param userId  the user id
     * @param tagName the tag name
     * @return the list
     */
    List<com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto> findByUserIdAndTagName(String userId, String tagName);

    /**
     * Delete by id.
     */
    public abstract void deleteById();

    /**
     * Delete by document id.
     *
     * @param documentId the document id
     */
    public abstract void deleteByDocumentId(String documentId);

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
     * Save tag dto.
     *
     * @param tagDTO the tag dto
     * @return the tag dto
     */
    com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto save(com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto tagDTO);

    /**
     * Delete by tag id tag dto.
     *
     * @param tagId the tag id
     * @return the tag dto
     */
    com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto deleteByTagId(String tagId);
}
