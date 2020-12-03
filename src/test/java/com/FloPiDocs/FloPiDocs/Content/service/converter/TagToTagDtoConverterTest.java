package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Tag to tag dto converter test.
 */
public class TagToTagDtoConverterTest {
    /**
     * The Tagname.
     */
    public final String TAGNAME = "TAGNAME";
    /**
     * The Tagid.
     */
    public final String TAGID = "123456";

    /**
     * Convert should convert.
     */
    @Test
    void convertShouldConvert(){
        Tag tag = new Tag();
        tag.setTagName(TAGNAME);
        tag.setTagId(TAGID);

        TagToTagDtoConverter converter = new TagToTagDtoConverter();

        com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto tagDTO = converter.convert(tag);

        assertEquals(TAGID, tagDTO.getTagId());
        assertEquals(TAGNAME, tagDTO.getTagName());

    }
}
