package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDTO;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FieldToFieldDtoConverterTest {
    public final String FIELDNAME = "FIELDNAME";
    public final String FIELDID = "123456";
    @Test
    void convertShouldConvert(){
        Field field = new Field();
        field.setFieldName(FIELDNAME);
        field.setId(FIELDID);

        FieldToFieldDtoConverter converter = new FieldToFieldDtoConverter();

        FieldDTO fieldDTO = converter.convert(field);

        assertEquals(FIELDID, fieldDTO.getId());
        assertEquals(FIELDNAME, fieldDTO.getFieldName());

    }
}
