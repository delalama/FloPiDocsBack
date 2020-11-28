package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.dto.TagDTO;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TagDtoToTagConverterTest {
    public final String TAGNAME = "TAGNAME";
    public final String TAGID = "123456";
    @Test
    void convertShouldConvert(){
        TagDTO tagDto = new TagDTO();
        tagDto.setTagName(TAGNAME);
        tagDto.setTagId(TAGID);

        TagDtoToTagConverter converter = new TagDtoToTagConverter();

        Tag tag = converter.convert(tagDto);

        assertEquals(TAGID, tag.getTagId());
        assertEquals(TAGNAME, tag.getTagName());

    }
}
