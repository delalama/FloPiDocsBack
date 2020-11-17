package com.FloPiDocs.FloPiDocs.Content.model.dto;

import lombok.*;

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
    private String date;
    private String content;


    public DocumentDTO(String id, String userId) {
        this.id = id;
        this.userId = userId;
    }

    public DocumentDTO(String userId, String title, String purpose, String content, String date) {
        this.userId = userId;
        this.title = title;
        this.purpose = purpose;
        this.content = content;
        this.date = date;
    }

}