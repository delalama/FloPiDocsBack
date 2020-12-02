package com.FloPiDocs.FloPiDocs.Content.model.persistence;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * The type Document.
 */
@NoArgsConstructor
@AllArgsConstructor
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


    /**
     * Instantiates a new Document.
     *
     * @param userId  the user id
     * @param title   the title
     * @param purpose the purpose
     * @param date    the date
     */
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