package com.FloPiDocs.FloPiDocs.Content.service;

import com.FloPiDocs.FloPiDocs.Content.entities.Tag;
import com.FloPiDocs.FloPiDocs.Content.entities.User;
import com.FloPiDocs.FloPiDocs.Content.entities.dto.AccountOptionsDTO;

import java.util.List;

public interface AccountOptionsService {
    public abstract void save(AccountOptionsDTO accountOptionsDTO);
    public abstract void setSafeDelete(String userId, boolean safeDelete);
    public abstract AccountOptionsDTO findByUserId(String userId);
}
