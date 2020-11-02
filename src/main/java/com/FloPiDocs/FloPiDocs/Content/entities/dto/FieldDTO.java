package com.FloPiDocs.FloPiDocs.Content.entities.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class FieldDTO {
    private String id;
    private String documentId;
    private String fieldName;
    private String fieldValue;

    //   TODO  private int position;

}