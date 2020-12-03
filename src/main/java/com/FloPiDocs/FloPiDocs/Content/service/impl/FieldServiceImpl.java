package com.FloPiDocs.FloPiDocs.Content.service.impl;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Field;
import com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto;
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
        return fieldRepository.findById(id).orElseThrow();
    }

    @Override
    public List<FieldDto> findByDocumentId(String documentId) {
        List<Field> fieldList = fieldRepository.findByDocumentId(documentId);
        return fieldList.stream().map( field -> conversionService.convert(field, FieldDto.class)).collect(Collectors.toList());
    }

    @Override
    public FieldDto deleteById(String id) {
        Field field = fieldRepository.findById(id).orElseThrow() ;
        FieldDto fieldDTO = conversionService.convert(field, FieldDto.class);
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
    public FieldDto save (FieldDto fieldDTO) {
        Field field = conversionService.convert(fieldDTO, Field.class);
        FieldDto savedFieldDTO = conversionService.convert(fieldRepository.save(field), FieldDto.class);
        return savedFieldDTO;
    }

    @Override
    public void deleteByDocumentId(String id) {
        fieldRepository.deleteByDocumentId(id);
    }

    @Override
    public FieldDto update(FieldDto fieldDTO) {
        Field field = fieldRepository.findById(fieldDTO.getId()).orElseThrow();

        field.setFieldName(fieldDTO.getFieldName());
        field.setFieldValue(fieldDTO.getFieldValue());

        Field field1 = fieldRepository.save(field);
        return conversionService.convert(field1, FieldDto.class);
    }
}
