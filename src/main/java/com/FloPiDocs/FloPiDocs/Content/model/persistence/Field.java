package com.FloPiDocs.FloPiDocs.Content.model.persistence;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * The type Field.
 */
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

    /**
     * Instantiates a new Field.
     *
     * @param documentId   the document id
     * @param fieldName    the field name
     * @param fieldValue   the field value
     * @param fieldPicture the field picture
     */
    public Field( String documentId, String fieldName, String fieldValue, String fieldPicture) {
        this.documentId = documentId;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.fieldPicture = fieldPicture;
    }
}