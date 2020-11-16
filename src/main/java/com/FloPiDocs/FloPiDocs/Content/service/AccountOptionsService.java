package com.FloPiDocs.FloPiDocs.Content.service;

import com.FloPiDocs.FloPiDocs.Content.model.dto.AccountOptionsDTO;

public interface AccountOptionsService {
    void save(AccountOptionsDTO accountOptionsDTO);
    void setSafeDelete(String userId, boolean safeDelete);
    void deleteAll();
    AccountOptionsDTO findByUserId(String userId);
}
