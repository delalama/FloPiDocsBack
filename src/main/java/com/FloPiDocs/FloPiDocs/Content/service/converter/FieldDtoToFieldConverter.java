package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDTO;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.Field;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FieldDtoToFieldConverter implements Converter<FieldDTO, Field> {

    @Override
    public Field convert(FieldDTO fieldDTO) {
        return new ModelMapper().map(fieldDTO, Field.class);
    }
}
