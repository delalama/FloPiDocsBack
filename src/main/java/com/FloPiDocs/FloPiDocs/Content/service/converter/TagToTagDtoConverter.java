package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * The type Tag to tag dto converter.
 */
@Component
public class TagToTagDtoConverter implements Converter<Tag, com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto> {

    @Override
    public com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto convert(Tag tag) {
        return new ModelMapper().map(tag, com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto.class);
    }
}
