package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * The type Tag dto to tag converter.
 */
@Component
public class TagDtoToTagConverter implements Converter<com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto, Tag> {

    @Override
    public Tag convert(com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto tagDTO) {
        return new ModelMapper().map(tagDTO, Tag.class);
    }
}
