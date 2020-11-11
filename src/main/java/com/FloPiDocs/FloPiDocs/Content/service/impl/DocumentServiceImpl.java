package com.FloPiDocs.FloPiDocs.Content.service.impl;

import com.FloPiDocs.FloPiDocs.Content.entities.Document;
import com.FloPiDocs.FloPiDocs.Content.entities.dto.DocumentDTO;
import com.FloPiDocs.FloPiDocs.Content.repository.DocumentRepository;
import com.FloPiDocs.FloPiDocs.Content.service.DocumentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@SuppressWarnings("UnnecessaryLocalVariable")
@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    ModelMapper modelMapper = new ModelMapper();
    
    @Autowired
    DocumentRepository documentRepository;

    @Override
    public Document createDocument(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public List<Document> findByTitle(String title) {
        return documentRepository.findByTitle(title);
    }

    @Override
    public DocumentDTO findById(String documentId) throws Exception {
        Document optDocument = documentRepository.findById(documentId).orElseThrow();
        return modelMapper.map(optDocument, DocumentDTO.class);
    }

    @Override
    public List<Document> findByPurpose(String purpose) {
        return documentRepository.findByPurpose(purpose);
    }

    @Override
    public List<Document> findAll() {
        return null;
    }

    @Override
    public List<Document> findByUserId(String userId, Pageable pageable) {
        return documentRepository.findByUserId(userId, pageable);
    }

    @Override
    public boolean emailExists(String email) {
        return false;
    }

    @Override
    public void deleteById(String id) { documentRepository.deleteById(id);}

    @Override
    public void deleteByUserId(String userId) {
        documentRepository.deleteByUserId(userId);
    }

    @Override
    public void deleteByTitle(String title) {
        documentRepository.deleteByTitle(title);
    }

    @Override
    public void deleteAll() {
        documentRepository.deleteAll();
    }

    @Override
    public void save(Document document) {
        documentRepository.save(document);
    }

    @Override
    public void deleteAllByUserId(String userId) {
        documentRepository.deleteByUserId(userId);
    }

    @Override
    public List<Document> findAllByUserId(String userId) {
        return documentRepository.findAllByUserId(userId);
    }

    @Override
    public Long countByUserId(String userId) {
        return documentRepository.countByUserId(userId);
    }

    //TODO ESTO NO VA COMO QUIERO
    @Override
    public List<Document> findByTitleAndPurposeContains(String userId,String key) {
        List<Document> documentList = documentRepository.findByUserIdAndTitleLikeOrPurposeLike(userId, key, key);
        return documentList;
    }

}
