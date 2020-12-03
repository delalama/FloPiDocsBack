package com.FloPiDocs.FloPiDocs.Content.service.impl;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.AccountOptions;
import com.FloPiDocs.FloPiDocs.Content.model.dto.AccountOptionsDto;
import com.FloPiDocs.FloPiDocs.Content.repository.AccountOptionsRepository;
import com.FloPiDocs.FloPiDocs.Content.service.AccountOptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * The type Account options service.
 */
@Service
public class AccountOptionsServiceImpl implements AccountOptionsService {
    /**
     * The Account options repository.
     */
    @Autowired
    AccountOptionsRepository accountOptionsRepository;

    @Autowired
    private ConversionService conversionService;

    @Override
    public void save(AccountOptionsDto accountOptionsDTO) {
        accountOptionsRepository.save(conversionService.convert(accountOptionsDTO,AccountOptions.class));
    }

    @Override
    public void setSafeDelete(String userId, boolean safeDelete) {
        AccountOptions accountOptions = accountOptionsRepository.findByUserId(userId).get(0);
        accountOptions.setSafeDelete(safeDelete);
        accountOptionsRepository.save(accountOptions);
    }

    @Override
    public void deleteAll() {
        accountOptionsRepository.deleteAll();
    }

    @Override
    public void deleteByUserId(String id) {
        accountOptionsRepository.deleteByUserId(id);
    }

    @Override
    public AccountOptionsDto findByUserId(String userId) {
        return conversionService.convert(accountOptionsRepository.findByUserId(userId).get(0), com.FloPiDocs.FloPiDocs.Content.model.dto.AccountOptionsDto.class);
    }
}
