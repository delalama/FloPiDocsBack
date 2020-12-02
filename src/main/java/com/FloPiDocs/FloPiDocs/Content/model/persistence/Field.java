package com.FloPiDocs.FloPiDocs.Content.model.persistence;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Field {
    @Indexed(unique = true)
    @Id
    private String id;
    private String documentId;
    private String fieldName;
    private String fieldValue;
    private String fieldPicture;

    public Field( String documentId, String fieldName, String fieldValue, String fieldPicture) {
        this.documentId = documentId;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.fieldPicture = fieldPicture;
    }
}