package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Document;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * The type Document to document dto converter.
 */
@Component
public class DocumentToDocumentDtoConverter implements Converter<Document, com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDto> {

    @Override
    public com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDto convert(Document document) {
        return new ModelMapper().map(document, com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDto.class);
    }
}
