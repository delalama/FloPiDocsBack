package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.User;
import com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type User dto to user converter test.
 */
class UserDtoToUserConverterTest {

    /**
     * The constant ID.
     */
    public static final String ID = "id";
    /**
     * The constant FIRST_NAME.
     */
    public static final String FIRST_NAME = "firstName";

    /**
     * Convert should convert.
     */
    @Test
    void convertShouldConvert() {
        UserDto userDto = new UserDto();

        userDto.setUserId(ID);
        userDto.setFirstName(FIRST_NAME);

        UserDtoToUserConverter converter = new UserDtoToUserConverter();

        User user = converter.convert(userDto);

        assertEquals(ID, user.getUserId());
        assertEquals(FIRST_NAME, user.getFirstName());

    }

}