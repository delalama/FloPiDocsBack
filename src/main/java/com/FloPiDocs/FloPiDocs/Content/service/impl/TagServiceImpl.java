package com.FloPiDocs.FloPiDocs.Content.service.impl;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Tag;
import com.FloPiDocs.FloPiDocs.Content.repository.TagRepository;
import com.FloPiDocs.FloPiDocs.Content.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Tag service.
 */
@Service
public class TagServiceImpl implements TagService {
    /**
     * The Tag repository.
     */
    @Autowired
    TagRepository tagRepository;

    @Autowired
    private ConversionService conversionService;


    @Override
    public Tag findByTagId(String id) {
        return tagRepository.findByTagId(id);
    }

    @Override
    public List<com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto> findByDocumentId(String documentId) {
        return tagRepository.findByDocumentId(documentId).stream().map( tag -> conversionService.convert(tag, com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto> findByTagName(String tagName) {
        List<Tag> tagList = tagRepository.findByDocumentId(tagName);
        return tagList.stream().map(v -> conversionService.convert(v, com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto> findByUserIdAndTagName(String userId, String tagName) {
        List<Tag> tagList = tagRepository.findByUserIdAndTagNameIgnoreCaseContains(userId,tagName);
        return tagList.stream().map(tag -> conversionService.convert(tag, com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto.class)).collect(Collectors.toList());
    }


    @Override
    public void deleteById() {
    }

    @Override
    public void deleteByDocumentId(String documentId) {
        tagRepository.deleteByDocumentId(documentId);
    }

    @Override
    public void deleteAll() {
        tagRepository.deleteAll();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto save(com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto tagDTO) {

        Tag tag = tagRepository.save(conversionService.convert(tagDTO, Tag.class));

        return  conversionService.convert(tag, com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto.class);
    }

    @Override
    public com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto deleteByTagId(String tagId) {
        com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto tagToDelete = conversionService.convert(findByTagId(tagId), com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto.class);
        tagRepository.deleteByTagId(tagId);
        return tagToDelete;
    }
}
