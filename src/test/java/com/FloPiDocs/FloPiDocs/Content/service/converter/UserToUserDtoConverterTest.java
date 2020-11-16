package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.dto.UserDTO;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserToUserDtoConverterTest {

    public static final String ID = "id";
    public static final String FIRST_NAME = "firstName";

    @Test
    void convertShouldConvert() {
        User user = new User();

        user.setUserId(ID);
        user.setFirstName(FIRST_NAME);

        UserToUserDtoConverter converter = new UserToUserDtoConverter();

        UserDTO userDTO = converter.convert(user);

        assertEquals(ID, userDTO.getUserId());
        assertEquals(FIRST_NAME, userDTO.getFirstName());

    }

}