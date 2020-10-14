package com.FloPiDocs.FloPiDocs.Content.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@Getter
@Setter
public class Tag {
    @Id
    private String id;
    private String userId;
    private String name;
    private String documentId;


    public Tag(String userId, String name, String documentId) {
        this.userId = userId;
        this.name = name;
        this.documentId = documentId;
    }

    @Override
    public String toString() {
        return String.format("Tag[id=%s, userId='%s', name='%s', content='%s', privacy='%s', documentId='%s']", id, userId, name, documentId);
    }
    

}