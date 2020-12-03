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
public class DocumentDto {
    private String id;
    private String userId;
    private String title;
    private String purpose;
    private String date;


    /**
     * Instantiates a new Document dto.
     *
     * @param id     the id
     * @param userId the user id
     */
    public DocumentDto(String id, String userId) {
        this.id = id;
        this.userId = userId;
    }


    /**
     * Instantiates a new Document dto.
     *
     * @param userId  the user id
     * @param title   the title
     * @param purpose the purpose
     * @param date    the date
     */
    public DocumentDto(String userId, String title, String purpose, String date) {
        this.userId = userId;
        this.title = title;
        this.purpose = purpose;
        this.date = date;
    }

    /**
     * Instantiates a new Document dto.
     *
     * @param userId  the user id
     * @param title   the title
     * @param purpose the purpose
     */
    public DocumentDto(String userId, String title, String purpose) {
        this.userId = userId;
        this.title = title;
        this.purpose = purpose;
    }

}