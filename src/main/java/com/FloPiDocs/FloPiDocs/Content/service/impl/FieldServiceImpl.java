package com.FloPiDocs.FloPiDocs.Content.service.impl;

import com.FloPiDocs.FloPiDocs.Content.entities.Field;
import com.FloPiDocs.FloPiDocs.Content.entities.dto.FieldDTO;
import com.FloPiDocs.FloPiDocs.Content.repository.FieldRepository;
import com.FloPiDocs.FloPiDocs.Content.service.FieldService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldServiceImpl implements FieldService {
    @Autowired
    FieldRepository fieldRepository;
    @Autowired
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public Field findById(String id) {
        return fieldRepository.findById(id).get();
    }

    @Override
    public List<Field> findByDocumentId(String documentId) {
        return fieldRepository.findByDocumentId(documentId);
    }

    @Override
    public FieldDTO deleteById(String id) {
        // GUILLE, esto debe ser una ñapa.....no? molaría que el deleteById(id) devolviese el que ha borrado.......debe existir algo como custom query....
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
    public Field save(Field field) {
        return fieldRepository.save(field);
    }

    @Override
    public void deleteByDocumentId(String id) {
        fieldRepository.deleteByDocumentId(id);
    }
}
