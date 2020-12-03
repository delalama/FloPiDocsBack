package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Field;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * The type Field dto to field converter.
 */
@Component
public class FieldDtoToFieldConverter implements Converter<com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto, Field> {

    @Override
    public Field convert(com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto fieldDTO) {
        return new ModelMapper().map(fieldDTO, Field.class);
    }
}
