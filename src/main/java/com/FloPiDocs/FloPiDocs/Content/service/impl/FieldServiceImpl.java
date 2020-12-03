package com.FloPiDocs.FloPiDocs.Content.service.impl;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Field;
import com.FloPiDocs.FloPiDocs.Content.repository.FieldRepository;
import com.FloPiDocs.FloPiDocs.Content.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Field service.
 */
@Service
public class FieldServiceImpl implements FieldService {
    /**
     * The Field repository.
     */
    @Autowired
    FieldRepository fieldRepository;

    @Autowired
    private ConversionService conversionService;

    @Override
    public Field findById(String id) {
        return fieldRepository.findById(id).get();
    }

    @Override
    public List<com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto> findByDocumentId(String documentId) {
        List<Field> fieldList = fieldRepository.findByDocumentId(documentId);
        return fieldList.stream().map( field -> conversionService.convert(field, com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto.class)).collect(Collectors.toList());
    }

    @Override
    public com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto deleteById(String id) {
        Field field = fieldRepository.findById(id).orElseThrow() ;
        com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto fieldDTO = conversionService.convert(field, com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto.class);
        fieldRepository.deleteById(id);
        return fieldDTO;
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
    public com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto save (com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto fieldDTO) {
        Field field = conversionService.convert(fieldDTO, Field.class);
        com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto savedFieldDTO = conversionService.convert(fieldRepository.save(field), com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto.class);
        return savedFieldDTO;
    }

    @Override
    public void deleteByDocumentId(String id) {
        fieldRepository.deleteByDocumentId(id);
    }

    @Override
    public com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto update(com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto fieldDTO) {
        Field field = fieldRepository.findById(fieldDTO.getId()).get();

        field.setFieldName(fieldDTO.getFieldName());
        field.setFieldValue(fieldDTO.getFieldValue());

        Field field1 = fieldRepository.save(field);
        return conversionService.convert(field1, com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto.class);
    }
}
