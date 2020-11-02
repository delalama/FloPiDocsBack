package com.FloPiDocs.FloPiDocs.Content.entities.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

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

    public TagDTO(String userId, String documentId, String tagName) {
        this.userId = userId;
        this.documentId = documentId;
        this.tagName = tagName;
    }
}
