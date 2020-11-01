package com.FloPiDocs.FloPiDocs.Content.entities.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class DocumentDTO {
    @Indexed(unique = true)
    @Id
    private String id;
    private String userId;
    private String title;
    private String purpose;
    private String date;
    private String content;

    public DocumentDTO(String userId, String title, String purpose, String content, String date) {
        this.userId = userId;
        this.title = title;
        this.purpose = purpose;
        this.content = content;
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("Document[id=%s, userId='%s', title='%s', purpose='%s', date='%s']", id, userId, title, purpose, date);
    }

}