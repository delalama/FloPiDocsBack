package com.FloPiDocs.FloPiDocs.Content.service;

import com.FloPiDocs.FloPiDocs.Content.entities.Field;
import com.FloPiDocs.FloPiDocs.Content.entities.dto.FieldDTO;

import java.util.List;

public interface FieldService {
    public abstract Field findById(String id);
    public abstract List<Field> findByDocumentId(String documentId);
    public abstract FieldDTO deleteById(String id);
    public abstract void deleteAll();
    public long count();
    public abstract Field save(Field field);

    public abstract void deleteByDocumentId(String id);
}
