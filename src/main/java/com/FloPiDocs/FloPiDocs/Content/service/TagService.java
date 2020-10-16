package com.FloPiDocs.FloPiDocs.Content.service;

import com.FloPiDocs.FloPiDocs.Content.entities.Tag;

import java.util.List;

public interface TagService {
    public abstract Tag findByTagId(String id);
    public abstract List<Tag> findByDocumentId(String documentId);
    public abstract void deleteById();
    public long count();
    public abstract void save(Tag tag);

}
