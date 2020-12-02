package com.FloPiDocs.FloPiDocs.Content.model.dto;

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
    private String fieldPicture;

    //   TODO  private int position;

}