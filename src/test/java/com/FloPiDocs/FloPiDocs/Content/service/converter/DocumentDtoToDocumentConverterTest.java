package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDTO;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.Document;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DocumentDtoToDocumentConverterTest {
    public static final String ID = "id";
    public static final String CONTENT = "content";

    @Test
    void convertShouldConvert() {
        DocumentDTO documentDTO = new DocumentDTO();

        documentDTO.setId(ID);
        documentDTO.setContent(CONTENT);

        DocumentDtoToDocumentConverter converter = new DocumentDtoToDocumentConverter();

        Document document = converter.convert(documentDTO);

        assertEquals(ID, document.getId());
        assertEquals(CONTENT, document.getContent());

    }
}
