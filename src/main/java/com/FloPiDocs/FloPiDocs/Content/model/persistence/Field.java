package com.FloPiDocs.FloPiDocs.Content.model.persistence;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Field {
    @Indexed(unique = true)
    @Id
    private String id;
    private String documentId;
    private String fieldName;
    private String fieldValue;
    /**
     * position indica la posición del field.
     *         cuando lo creamos....
     *             es el primero ? 0 : fields.size;
     *         posteriormente se puede añadir un evento en el front, si un field se mueve se le asigna
     *         la nueva posición y a los fields posteriores se les añade 1
     */
    private int position;

    public Field( String documentId, String fieldName, String fieldValue) {
        this.documentId = documentId;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}