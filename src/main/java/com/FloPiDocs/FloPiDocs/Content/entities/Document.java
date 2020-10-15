package com.FloPiDocs.FloPiDocs.Content.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Document {
    @Indexed(unique = true)
    @Id
    private String id;
    private String userId;
    private String title;
    private String purpose;
    private String date;
    private String content;

    public Document(String userId, String title, String purpose, String date) {
        this.userId = userId;
        this.title = title;
        this.purpose = purpose;
        this.date = date;
    }

    public Document(String id, String userId, String title, String purpose, String date, String content) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.purpose = purpose;
        this.date = date;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Document[id=%s, userId='%s', title='%s', purpose='%s', date='%s']", id, userId, title, purpose, date);
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}