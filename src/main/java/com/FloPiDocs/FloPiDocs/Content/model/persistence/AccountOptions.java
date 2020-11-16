package com.FloPiDocs.FloPiDocs.Content.model.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AccountOptions {

    @Id
    private String id;
    private String userId;

    /** Option to avoid fast field delete **/
    private boolean safeDelete = true;


}
