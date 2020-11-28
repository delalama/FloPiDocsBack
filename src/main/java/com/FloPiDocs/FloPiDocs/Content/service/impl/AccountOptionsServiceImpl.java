package com.FloPiDocs.FloPiDocs.Content.service.impl;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.AccountOptions;
import com.FloPiDocs.FloPiDocs.Content.model.dto.AccountOptionsDTO;
import com.FloPiDocs.FloPiDocs.Content.repository.AccountOptionsRepository;
import com.FloPiDocs.FloPiDocs.Content.service.AccountOptionsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class AccountOptionsServiceImpl implements AccountOptionsService {
    @Autowired
    AccountOptionsRepository accountOptionsRepository;

    @Autowired
    private ConversionService conversionService;

    @Override
    public void save(AccountOptionsDTO accountOptionsDTO) {
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
    public AccountOptionsDTO findByUserId(String userId) {
        return conversionService.convert(accountOptionsRepository.findByUserId(userId).get(0),AccountOptionsDTO.class);
    }
}
