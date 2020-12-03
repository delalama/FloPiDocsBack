package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Document;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Document to document dto converter test.
 */
class DocumentToDocumentDtoConverterTest {
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
        Document document = new Document();

        document.setId(ID);
        document.setTitle(TITLE);

        DocumentToDocumentDtoConverter converter = new DocumentToDocumentDtoConverter();

        com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDto documentDTO = converter.convert(document);

        assertEquals(ID, document.getId());
        assertEquals(TITLE, document.getTitle());

    }
}
