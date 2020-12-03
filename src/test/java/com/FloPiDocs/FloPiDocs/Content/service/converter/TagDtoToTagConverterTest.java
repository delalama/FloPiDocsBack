package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Tag dto to tag converter test.
 */
public class TagDtoToTagConverterTest {
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
        com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto tagDto = new com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto();
        tagDto.setTagName(TAGNAME);
        tagDto.setTagId(TAGID);

        TagDtoToTagConverter converter = new TagDtoToTagConverter();

        Tag tag = converter.convert(tagDto);

        assertEquals(TAGID, tag.getTagId());
        assertEquals(TAGNAME, tag.getTagName());

    }
}
