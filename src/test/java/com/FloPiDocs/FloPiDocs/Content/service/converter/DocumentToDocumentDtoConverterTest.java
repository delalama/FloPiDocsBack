package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDTO;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.Document;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DocumentToDocumentDtoConverterTest {
    public static final String ID = "id";
    public static final String TITLE = "content";

    @Test
    void convertShouldConvert() {
        Document document = new Document();

        document.setId(ID);
        document.setTitle(TITLE);

        DocumentToDocumentDtoConverter converter = new DocumentToDocumentDtoConverter();

        DocumentDTO documentDTO = converter.convert(document);

        assertEquals(ID, document.getId());
        assertEquals(TITLE, document.getTitle());

    }
}
