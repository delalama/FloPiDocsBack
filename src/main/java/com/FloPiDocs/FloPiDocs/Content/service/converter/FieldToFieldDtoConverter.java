package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDTO;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.Field;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FieldToFieldDtoConverter implements Converter<Field, FieldDTO> {

    @Override
    public FieldDTO convert(Field field) {
        return new ModelMapper().map(field, FieldDTO.class);
    }
}
