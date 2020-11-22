package com.FloPiDocs.FloPiDocs.Content.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class TagDTO {
    private String tagId;
    private String userId;
    private String tagName;
    private String documentId;

    public TagDTO(String userId, String tagName, String documentId) {
        this.userId = userId;
        this.tagName = tagName;
        this.documentId = documentId;
    }
}
