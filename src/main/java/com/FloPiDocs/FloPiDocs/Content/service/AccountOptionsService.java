package com.FloPiDocs.FloPiDocs.Content.service;

/**
 * The interface Account options service.
 */
public interface AccountOptionsService {
    /**
     * Save.
     *
     * @param accountOptionsDTO the account options dto
     */
    void save(com.FloPiDocs.FloPiDocs.Content.model.dto.AccountOptionsDto accountOptionsDTO);

    /**
     * Sets safe delete.
     *
     * @param userId     the user id
     * @param safeDelete the safe delete
     */
    void setSafeDelete(String userId, boolean safeDelete);

    /**
     * Delete all.
     */
    void deleteAll();

    /**
     * Delete by user id.
     *
     * @param id the id
     */
    void deleteByUserId(String id);

    /**
     * Find by user id account options dto.
     *
     * @param userId the user id
     * @return the account options dto
     */
    com.FloPiDocs.FloPiDocs.Content.model.dto.AccountOptionsDto findByUserId(String userId);
}
