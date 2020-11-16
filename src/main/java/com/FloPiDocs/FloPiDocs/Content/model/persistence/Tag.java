package com.FloPiDocs.FloPiDocs.Content.model.persistence;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Tag {
    @Indexed(unique = true)
    @Id
    private String tagId;
    private String userId;
    private String tagName;
    private String documentId;

    public Tag(String userId, String documentId, String tagName) {
        this.userId = userId;
        this.documentId = documentId;
        this.tagName = tagName;
    }
}
