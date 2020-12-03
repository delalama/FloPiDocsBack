package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.AccountOptions;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * The type Account options to account options dto converter.
 */
@Component
public class AccountOptionsToAccountOptionsDTOConverter implements Converter<AccountOptions, com.FloPiDocs.FloPiDocs.Content.model.dto.AccountOptionsDto> {
    @Override
    public com.FloPiDocs.FloPiDocs.Content.model.dto.AccountOptionsDto convert(AccountOptions accountOptions) {
        return new ModelMapper().map(accountOptions, com.FloPiDocs.FloPiDocs.Content.model.dto.AccountOptionsDto.class);
    }
}
