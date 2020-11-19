package com.FloPiDocs.FloPiDocs.Content.service.impl;

import com.FloPiDocs.FloPiDocs.Content.model.dto.TagDTO;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.Tag;
import com.FloPiDocs.FloPiDocs.Content.repository.TagRepository;
import com.FloPiDocs.FloPiDocs.Content.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagRepository tagRepository;

    @Autowired
    private ConversionService conversionService;


    @Override
    public Tag findByTagId(String id) {
        return tagRepository.findByTagId(id);
    }

    @Override
    public List<Tag> findByDocumentId(String documentId) {
        return tagRepository.findByDocumentId(documentId);
    }

    @Override
    public List<TagDTO> findByTagName(String tagName) {
        List<Tag> tagList = tagRepository.findByDocumentId(tagName);
        List<TagDTO> tagDTOList = tagList.stream().map(v -> conversionService.convert(v, TagDTO.class)).collect(Collectors.toList());
        return tagDTOList;
//        return conversionService.convert(tagList, TagDTO.class);
    }

    @Override
    public List<TagDTO> findByUserIdAndTagName(String userId, String tagName) {
        List<Tag> tagList = tagRepository.findByUserIdAndTagNameIgnoreCaseContains(userId,tagName);
        List<TagDTO> tagDTOList = tagList.stream().map(tag -> conversionService.convert(tag, TagDTO.class)).collect(Collectors.toList());
        return tagDTOList;
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
    public void save(Tag tag) {
        tagRepository.save(tag);
    }
}
