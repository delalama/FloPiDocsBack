package com.FloPiDocs.FloPiDocs.Content.model.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * The type Owner.
 */
@NoArgsConstructor
@Getter
@Setter
public class Owner {
    @Id
    private String id;
    private Boolean right;
    private Integer documentId;

    @Override
    public String toString() {
    return String.format("Tag[id=%s, right='%s', documentId='%s']", id, right, documentId);
  }

}