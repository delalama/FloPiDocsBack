package com.FloPiDocs.FloPiDocs.Content.service.impl;

import com.FloPiDocs.FloPiDocs.Content.entities.AccountOptions;
import com.FloPiDocs.FloPiDocs.Content.entities.Field;
import com.FloPiDocs.FloPiDocs.Content.entities.dto.AccountOptionsDTO;
import com.FloPiDocs.FloPiDocs.Content.repository.AccountOptionsRepository;
import com.FloPiDocs.FloPiDocs.Content.repository.FieldRepository;
import com.FloPiDocs.FloPiDocs.Content.service.AccountOptionsService;
import com.FloPiDocs.FloPiDocs.Content.service.FieldService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountOptionsServiceImpl implements AccountOptionsService {
    @Autowired
    AccountOptionsRepository accountOptionsRepository;

    @Autowired
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public void save(AccountOptionsDTO accountOptionsDTO) {
        accountOptionsRepository.save(modelMapper.map(accountOptionsDTO,AccountOptions.class));
    }
}
