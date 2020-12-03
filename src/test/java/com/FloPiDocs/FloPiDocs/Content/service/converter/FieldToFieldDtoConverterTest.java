package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Field to field dto converter test.
 */
public class FieldToFieldDtoConverterTest {
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
        Field field = new Field();
        field.setFieldName(FIELDNAME);
        field.setId(FIELDID);

        FieldToFieldDtoConverter converter = new FieldToFieldDtoConverter();

        com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDto fieldDTO = converter.convert(field);

        assertEquals(FIELDID, fieldDTO.getId());
        assertEquals(FIELDNAME, fieldDTO.getFieldName());

    }
}
