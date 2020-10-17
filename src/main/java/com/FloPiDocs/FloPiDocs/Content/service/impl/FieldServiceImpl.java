package com.FloPiDocs.FloPiDocs.Content.service.impl;

import com.FloPiDocs.FloPiDocs.Content.entities.Field;
import com.FloPiDocs.FloPiDocs.Content.repository.FieldRepository;
import com.FloPiDocs.FloPiDocs.Content.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldServiceImpl implements FieldService {
    @Autowired
    FieldRepository fieldRepository;

    @Override
    public Field findById(String id) {
        return fieldRepository.findById(id).get();
    }

    @Override
    public List<Field> findByDocumentId(String documentId) {
        return fieldRepository.findByDocumentId(documentId);
    }

    @Override
    public void deleteById(String id) {
        fieldRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        fieldRepository.deleteAll();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Field save(Field field) {
        return fieldRepository.save(field);
    }

    @Override
    public void deleteByDocumentId(String id) {
        fieldRepository.deleteByDocumentId(id);
    }
}
