package com.FloPiDocs.FloPiDocs.Content.model.persistence;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * The type Tag.
 */
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

    /**
     * Instantiates a new Tag.
     *
     * @param userId     the user id
     * @param documentId the document id
     * @param tagName    the tag name
     */
    public Tag(String userId, String documentId, String tagName) {
        this.userId = userId;
        this.documentId = documentId;
        this.tagName = tagName;
    }
}
