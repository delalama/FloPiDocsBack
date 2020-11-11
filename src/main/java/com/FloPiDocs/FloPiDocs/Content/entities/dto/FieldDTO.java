package com.FloPiDocs.FloPiDocs.Content.entities.dto;

import lombok.*;

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