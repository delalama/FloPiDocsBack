package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Document;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * The type Document dto to document converter.
 */
@Component
public class DocumentDtoToDocumentConverter implements Converter<com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDto, Document> {
    @Override
    public Document convert(com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDto documentDTO) {
        return new ModelMapper().map(documentDTO, Document.class);
    }
}
