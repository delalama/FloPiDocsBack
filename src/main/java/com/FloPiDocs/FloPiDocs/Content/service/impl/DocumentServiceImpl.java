package com.FloPiDocs.FloPiDocs.Content.service.impl;

import com.FloPiDocs.FloPiDocs.Content.model.dto.TagDTO;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.Document;
import com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDTO;
import com.FloPiDocs.FloPiDocs.Content.repository.DocumentRepository;
import com.FloPiDocs.FloPiDocs.Content.service.DocumentService;
import com.FloPiDocs.FloPiDocs.Content.service.FieldService;
import com.FloPiDocs.FloPiDocs.Content.service.TagService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@SuppressWarnings("UnnecessaryLocalVariable")
@Service
public class DocumentServiceImpl implements DocumentService {
    final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    TagService tagService;

    @Autowired
    FieldService fieldService;

    @Autowired
    private ConversionService conversionService;

    @Override
    public DocumentDTO createDocument(DocumentDTO documentDTO) {
        DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDateTime ldt = LocalDateTime.now();
        String formatedDate = formmat1.format(ldt);
        documentDTO.setDate(formatedDate);
        Document doc = documentRepository.save(conversionService.convert(documentDTO, Document.class));
        return conversionService.convert(doc, DocumentDTO.class);
    }

    @Override
    public List<Document> findByTitle(String title) {
        return documentRepository.findByTitle(title);
    }

    @Override
    public DocumentDTO findById(String documentId) {
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
    public List<DocumentDTO> findAllByUserId(String userId) {
        List<Document> documentList = documentRepository.findAllByUserId(userId);
        return documentList.stream().map(doc -> conversionService.convert(doc, DocumentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public boolean emailExists(String email) {
        return false;
    }

    @Override
    public DocumentDTO deleteById(DocumentDTO documentDTO) {
        DocumentDTO documentDTO1 = findById(documentDTO.getId());
        documentRepository.deleteById(documentDTO1.getId());
        tagService.deleteByDocumentId(documentDTO.getId());
        fieldService.deleteByDocumentId(documentDTO.getId());
        return conversionService.convert(documentDTO1, DocumentDTO.class);
    }

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
        List<DocumentDTO> documentList = findAllByUserId(userId);
        documentList.forEach( documentDTO -> {
            fieldService.deleteByDocumentId(documentDTO.getId());
            tagService.deleteByDocumentId(documentDTO.getId());}
        );
        deleteByUserId(userId);
    }

    @Override
    public Long countByUserId(String userId) {
        return documentRepository.countByUserId(userId);
    }

    @Override
    public List<Document> findByUserIdAndTitle(String userId, String key) {
        List<Document> documentList = documentRepository.findByUserIdAndTitleContainsIgnoreCase(userId, key);
        return documentList;
    }

    @Override
    public List<Document> findByUserIdAndPurpose(String userId, String purpose) {
        List<Document> documentList = documentRepository.findByUserIdAndPurposeContainsIgnoreCase(userId, purpose);
        return documentList;
    }

    @Override
    public void update(DocumentDTO documentDTO) {
        Document document = conversionService.convert(documentDTO, Document.class);
        save(document);
    }

    @Override
    public List<DocumentDTO> findByUserIdAndTag(String userId, String key) {
        List<TagDTO> tagDTO = tagService.findByUserIdAndTagName(userId, key);

        List<Document> documentList = tagDTO.stream().map(tag -> {
                    if (documentRepository.findById(tag.getDocumentId()).isPresent()) {
                        return documentRepository.findById(tag.getDocumentId()).get();
                    } else return new Document();
                }
        ).collect(Collectors.toList());

//        List<Document> documentList = tagDTO.stream().map(tag -> documentRepository.findById(tag.getDocumentId()).get()).collect(Collectors.toList());

        List<DocumentDTO> documentDTOList = documentList.stream().map(document -> conversionService.convert(document, DocumentDTO.class)).collect(Collectors.toList());

        return documentDTOList;
    }

}
