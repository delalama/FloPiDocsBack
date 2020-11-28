package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.dto.AccountOptionsDTO;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.AccountOptions;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccountOptionsToAccountOptionsDTOConverter implements Converter<AccountOptions, AccountOptionsDTO> {
    @Override
    public AccountOptionsDTO convert(AccountOptions accountOptions) {
        return new ModelMapper().map(accountOptions, AccountOptionsDTO.class);
    }
}
