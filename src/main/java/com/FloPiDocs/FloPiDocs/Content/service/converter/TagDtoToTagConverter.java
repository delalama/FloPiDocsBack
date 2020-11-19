package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.dto.TagDTO;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TagDtoToTagConverter implements Converter<TagDTO, Tag> {

    @Override
    public Tag convert(TagDTO tagDTO) {
        return new ModelMapper().map(tagDTO, Tag.class);
    }
}
