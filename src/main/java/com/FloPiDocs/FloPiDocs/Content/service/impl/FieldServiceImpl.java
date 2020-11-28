package com.FloPiDocs.FloPiDocs.Content.service.impl;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Field;
import com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDTO;
import com.FloPiDocs.FloPiDocs.Content.repository.FieldRepository;
import com.FloPiDocs.FloPiDocs.Content.service.FieldService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FieldServiceImpl implements FieldService {
    @Autowired
    FieldRepository fieldRepository;

    final ModelMapper modelMapper = new ModelMapper();

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
        FieldDTO fieldDTO = modelMapper.map(field, FieldDTO.class);
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
    public ResponseEntity<FieldDTO> save (FieldDTO fieldDTO) {
        Field field = modelMapper.map(fieldDTO, Field.class);
        FieldDTO savedFieldDTO = modelMapper.map(fieldRepository.save(field), FieldDTO.class);
        return new ResponseEntity<>(savedFieldDTO, HttpStatus.OK);
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
