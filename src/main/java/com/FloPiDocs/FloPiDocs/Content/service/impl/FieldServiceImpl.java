package com.FloPiDocs.FloPiDocs.Content.service.impl;

import com.FloPiDocs.FloPiDocs.Content.entities.Tag;
import com.FloPiDocs.FloPiDocs.Content.repository.TagRepository;
import com.FloPiDocs.FloPiDocs.Content.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldServiceImpl implements FieldService {
    @Autowired
    TagRepository tagRepository;

    @Override
    public Tag findByTagId(String id) {
        return tagRepository.findByTagId(id);
    }

    @Override
    public List<Tag> findByDocumentId(String documentId) {
        return tagRepository.findByDocumentId(documentId);
    }

    @Override
    public void deleteById() {

    }

    @Override
    public void deleteAll() {
        tagRepository.deleteAll();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void save(Tag tag) {
        tagRepository.save(tag);
    }
}
