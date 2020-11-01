package com.FloPiDocs.FloPiDocs.Content.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Field {
    @Indexed(unique = true)
    @Id
    private String id;
    private String documentId;
    private String fieldName;
    private String fieldValue;

    //   TODO  private int position;

    public Field() {
    }

    public Field( String documentId, String fieldName, String fieldValue) {
        this.documentId = documentId;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public Field( String id,  String documentId, String fieldName, String fieldValue) {
        this.id = id;
        this.documentId = documentId;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

}