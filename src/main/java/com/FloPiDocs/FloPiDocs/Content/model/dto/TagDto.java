package com.FloPiDocs.FloPiDocs.Content.model.dto;

import lombok.*;

/**
 * The type Tag dto.
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class TagDto {
    private String tagId;
    private String userId;
    private String tagName;
    private String documentId;

    /**
     * Instantiates a new Tag dto.
     *
     * @param userId     the user id
     * @param tagName    the tag name
     * @param documentId the document id
     */
    public TagDto(String userId, String tagName, String documentId) {
        this.userId = userId;
        this.tagName = tagName;
        this.documentId = documentId;
    }
}
