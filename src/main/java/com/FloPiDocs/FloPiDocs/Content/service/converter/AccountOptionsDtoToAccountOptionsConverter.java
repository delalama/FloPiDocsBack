package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.dto.AccountOptionsDTO;
import com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDTO;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.AccountOptions;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.Document;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccountOptionsDtoToAccountOptionsConverter implements Converter<AccountOptionsDTO, AccountOptions> {
    @Override
    public AccountOptions convert(AccountOptionsDTO accountOptionsDTO) {
        return new ModelMapper().map(accountOptionsDTO, AccountOptions.class);
    }
}
