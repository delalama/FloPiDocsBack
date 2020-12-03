package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.AccountOptions;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * The type Account options dto to account options converter.
 */
@Component
public class AccountOptionsDtoToAccountOptionsConverter implements Converter<com.FloPiDocs.FloPiDocs.Content.model.dto.AccountOptionsDto, AccountOptions> {
    @Override
    public AccountOptions convert(com.FloPiDocs.FloPiDocs.Content.model.dto.AccountOptionsDto accountOptionsDTO) {
        return new ModelMapper().map(accountOptionsDTO, AccountOptions.class);
    }
}
