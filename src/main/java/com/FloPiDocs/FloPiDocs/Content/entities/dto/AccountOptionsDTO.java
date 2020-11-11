package com.FloPiDocs.FloPiDocs.Content.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AccountOptionsDTO {
    private String userId;
    private boolean safeDelete = true;

    public AccountOptionsDTO(String userId) {
        this.userId = userId;
    }
}
