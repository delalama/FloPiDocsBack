package com.FloPiDocs.FloPiDocs.Content.service;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Field;
import com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDTO;

import java.util.List;

@SuppressWarnings("ALL")
public interface FieldService {
    public abstract Field findById(String id);
    public abstract List<FieldDTO> findByDocumentId(String documentId);
    public abstract FieldDTO deleteById(String id);
    public abstract void deleteAll();
    public long count();
    public FieldDTO save(FieldDTO field);

    public abstract void deleteByDocumentId(String id);

    FieldDTO update(FieldDTO fieldDTO);
}
