package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type User to user dto converter test.
 */
class UserToUserDtoConverterTest {

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
        User user = new User();

        user.setUserId(ID);
        user.setFirstName(FIRST_NAME);

        UserToUserDtoConverter converter = new UserToUserDtoConverter();

        com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto userDTO = converter.convert(user);

        assertEquals(ID, userDTO.getUserId());
        assertEquals(FIRST_NAME, userDTO.getFirstName());

    }

}