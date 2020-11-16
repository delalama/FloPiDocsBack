package com.FloPiDocs.FloPiDocs.Content.service.impl;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.AccountOptions;
import com.FloPiDocs.FloPiDocs.Content.model.dto.AccountOptionsDTO;
import com.FloPiDocs.FloPiDocs.Content.repository.AccountOptionsRepository;
import com.FloPiDocs.FloPiDocs.Content.service.AccountOptionsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountOptionsServiceImpl implements AccountOptionsService {
    @Autowired
    AccountOptionsRepository accountOptionsRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public void save(AccountOptionsDTO accountOptionsDTO) {
        accountOptionsRepository.save(modelMapper.map(accountOptionsDTO,AccountOptions.class));
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
    public AccountOptionsDTO findByUserId(String userId) {
        AccountOptions accountOptions = accountOptionsRepository.findByUserId(userId).get(0);
        return modelMapper.map(accountOptions,AccountOptionsDTO.class);
    }
}
