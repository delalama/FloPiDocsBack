package com.FloPiDocs.FloPiDocs.Content.entities;

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

    //   TODO  private int position;

    public Field( String documentId, String fieldName, String fieldValue) {
        this.documentId = documentId;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}