package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Document;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Document dto to document converter test.
 */
class DocumentDtoToDocumentConverterTest {
    /**
     * The constant ID.
     */
    public static final String ID = "id";
    /**
     * The constant TITLE.
     */
    public static final String TITLE = "content";

    /**
     * Convert should convert.
     */
    @Test
    void convertShouldConvert() {
        com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDto documentDTO = new com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDto();

        documentDTO.setId(ID);
        documentDTO.setTitle(TITLE);

        DocumentDtoToDocumentConverter converter = new DocumentDtoToDocumentConverter();

        Document document = converter.convert(documentDTO);

        assertEquals(ID, document.getId());
        assertEquals(TITLE, document.getTitle());

    }
}
