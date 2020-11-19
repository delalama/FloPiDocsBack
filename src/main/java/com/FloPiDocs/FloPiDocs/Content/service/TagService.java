package com.FloPiDocs.FloPiDocs.Content.service;

import com.FloPiDocs.FloPiDocs.Content.model.dto.TagDTO;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.Tag;

import java.util.List;

@SuppressWarnings("ALL")
public interface TagService {
    public abstract Tag findByTagId(String id);
    public abstract List<Tag> findByDocumentId(String documentId);

    List<TagDTO> findByTagName(String tagName);
    List<TagDTO> findByUserIdAndTagName(String userId, String tagName);

    public abstract void deleteById();
    public abstract void deleteByDocumentId(String documentId);
    public abstract void deleteAll();
    public long count();
    public abstract void save(Tag tag);

}
