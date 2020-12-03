package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Field dto to field converter test.
 */
public class FieldDtoToFieldConverterTest {
    /**
     * The Fieldname.
     */
    public final String FIELDNAME = "FIELDNAME";
    /**
     * The Fieldid.
     */
    public final String FIELDID = "123456";

    /**
     * Convert should convert.
     */
    @Test
    void convertShouldConvert(){
        com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto fieldDto = new com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto();
        fieldDto.setFieldName(FIELDNAME);
        fieldDto.setId(FIELDID);

        FieldDtoToFieldConverter converter = new FieldDtoToFieldConverter();

        Field field = converter.convert(fieldDto);

        assertEquals(FIELDID, field.getId());
        assertEquals(FIELDNAME, field.getFieldName());

    }
}
