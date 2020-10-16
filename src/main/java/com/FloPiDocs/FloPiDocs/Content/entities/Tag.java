package com.FloPiDocs.FloPiDocs.Content.entities;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@NoArgsConstructor
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

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    @Override
    public String toString() {
        return String.format("Tag[id=%s, userId='%s', name='%s', content='%s', privacy='%s', documentId='%s']", tagId, userId, tagName, documentId);
    }
    

}