package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDTO;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FieldDtoToFieldConverterTest {
    public final String FIELDNAME = "FIELDNAME";
    public final String FIELDID = "123456";
    @Test
    void convertShouldConvert(){
        FieldDTO fieldDto = new FieldDTO();
        fieldDto.setFieldName(FIELDNAME);
        fieldDto.setId(FIELDID);

        FieldDtoToFieldConverter converter = new FieldDtoToFieldConverter();

        Field field = converter.convert(fieldDto);

        assertEquals(FIELDID, field.getId());
        assertEquals(FIELDNAME, field.getFieldName());

    }
}
