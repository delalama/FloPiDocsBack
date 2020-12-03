package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Field;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * The type Field to field dto converter.
 */
@Component
public class FieldToFieldDtoConverter implements Converter<Field, com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto> {

    @Override
    public com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto convert(Field field) {
        return new ModelMapper().map(field, com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto.class);
    }
}
