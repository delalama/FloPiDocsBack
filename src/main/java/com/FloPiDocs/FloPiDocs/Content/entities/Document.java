package com.FloPiDocs.FloPiDocs.Content.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Document {
    @Id
    private String id;
    private Long userId;
    private String title;
    private String purpose;
    private String date;
    private String content;

    public Document(Long userId, String title, String purpose, String date) {
        this.userId = userId;
        this.title = title;
        this.purpose = purpose;
        this.date = date;
    }

    public Document(Long documentId, String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("Document[id=%s, userId='%s', title='%s', purpose='%s', date='%s']", id, userId, title, purpose, date);
    }

}