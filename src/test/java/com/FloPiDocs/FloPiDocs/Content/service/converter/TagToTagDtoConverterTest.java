package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.dto.TagDTO;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TagToTagDtoConverterTest {
    public final String TAGNAME = "TAGNAME";
    public final String TAGID = "123456";
    @Test
    void convertShouldConvert(){
        Tag tag = new Tag();
        tag.setTagName(TAGNAME);
        tag.setTagId(TAGID);

        TagToTagDtoConverter converter = new TagToTagDtoConverter();

        TagDTO tagDTO = converter.convert(tag);

        assertEquals(TAGID, tagDTO.getTagId());
        assertEquals(TAGNAME, tagDTO.getTagName());

    }
}
