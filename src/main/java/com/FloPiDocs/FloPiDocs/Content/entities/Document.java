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
  
    // UserId must be the ID of the user who creates the document
    private String userId;

    private String title;

    private String purpose;

    // Could be autocompleted
    private String date;

    public Document(String userId, String title, String purpose, String date) {
        this.userId = userId;
        this.title = title;
        this.purpose = purpose;
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("Document[id=%s, userId='%s', title='%s', purpose='%s', date='%s']", id, userId, title, purpose, date);
    }

}