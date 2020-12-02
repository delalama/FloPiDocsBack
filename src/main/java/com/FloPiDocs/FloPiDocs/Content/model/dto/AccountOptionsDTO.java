package com.FloPiDocs.FloPiDocs.Content.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The type Account options dto.
 */
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AccountOptionsDTO {
    private String userId;
    private boolean safeDelete = true;

    /**
     * Instantiates a new Account options dto.
     *
     * @param userId the user id
     */
    public AccountOptionsDTO(String userId) {
        this.userId = userId;
    }
}
