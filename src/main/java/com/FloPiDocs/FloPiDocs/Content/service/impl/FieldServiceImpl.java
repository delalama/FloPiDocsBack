package com.FloPiDocs.FloPiDocs.Content.service.impl;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Field;
import com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDTO;
import com.FloPiDocs.FloPiDocs.Content.repository.FieldRepository;
import com.FloPiDocs.FloPiDocs.Content.service.FieldService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FieldServiceImpl implements FieldService {
    @Autowired
    FieldRepository fieldRepository;

    @Autowired
    private ConversionService conversionService;

    @Override
    public Field findById(String id) {
        return fieldRepository.findById(id).get();
    }

    @Override
    public List<FieldDTO> findByDocumentId(String documentId) {
        List<Field> fieldList = fieldRepository.findByDocumentId(documentId);
        return fieldList.stream().map( field -> conversionService.convert(field, FieldDTO.class)).collect(Collectors.toList());
    }

    @Override
    public FieldDTO deleteById(String id) {
        Field field = fieldRepository.findById(id).orElseThrow() ;
        FieldDTO fieldDTO = conversionService.convert(field, FieldDTO.class);
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
    public FieldDTO save (FieldDTO fieldDTO) {
        Field field = conversionService.convert(fieldDTO, Field.class);
        FieldDTO savedFieldDTO = conversionService.convert(fieldRepository.save(field), FieldDTO.class);
        return savedFieldDTO;
    }

    @Override
    public void deleteByDocumentId(String id) {
        fieldRepository.deleteByDocumentId(id);
    }

    @Override
    public FieldDTO update(FieldDTO fieldDTO) {
        Field field = fieldRepository.findById(fieldDTO.getId()).get();

        field.setFieldName(fieldDTO.getFieldName());
        field.setFieldValue(fieldDTO.getFieldValue());

        Field field1 = fieldRepository.save(field);
        return conversionService.convert(field1, FieldDTO.class);
    }
}
