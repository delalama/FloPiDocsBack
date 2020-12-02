package com.FloPiDocs.FloPiDocs.Content.model.dto;

import lombok.*;

/**
 * The type Document dto.
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class DocumentDTO {
    private String id;
    private String userId;
    private String title;
    private String purpose;
    private String content;
    private String date;


    /**
     * Instantiates a new Document dto.
     *
     * @param id     the id
     * @param userId the user id
     */
    public DocumentDTO(String id, String userId) {
        this.id = id;
        this.userId = userId;
    }


    /**
     * Instantiates a new Document dto.
     *
     * @param userId  the user id
     * @param title   the title
     * @param purpose the purpose
     * @param content the content
     * @param date    the date
     */
    public DocumentDTO(String userId, String title, String purpose, String content, String date) {
        this.userId = userId;
        this.title = title;
        this.purpose = purpose;
        this.content = content;
        this.date = date;
    }

    /**
     * Instantiates a new Document dto.
     *
     * @param userId  the user id
     * @param title   the title
     * @param purpose the purpose
     * @param content the content
     */
    public DocumentDTO(String userId, String title, String purpose, String content) {
        this.userId = userId;
        this.title = title;
        this.purpose = purpose;
        this.content = content;
    }

}