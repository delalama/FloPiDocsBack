package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDTO;
import com.FloPiDocs.FloPiDocs.Content.model.dto.UserDTO;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.Document;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.User;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DocumentToDocumentDtoConverter implements Converter<Document, DocumentDTO> {

    @Override
    public DocumentDTO convert(Document document) {
        return new ModelMapper().map(document, DocumentDTO.class);
    }
}
