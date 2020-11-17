package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDTO;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.Document;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DocumentDtoToDocumentConverter implements Converter<DocumentDTO, Document> {
    @Override
    public Document convert(DocumentDTO documentDTO) {
        return new ModelMapper().map(documentDTO, Document.class);
    }
}
