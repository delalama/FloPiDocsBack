package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.dto.UserDTO;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDtoToUserConverterTest {

    public static final String ID = "id";
    public static final String FIRST_NAME = "firstName";

    @Test
    void convertShouldConvert() {
        UserDTO userDto = new UserDTO();

        userDto.setUserId(ID);
        userDto.setFirstName(FIRST_NAME);

        UserDtoToUserConverter converter = new UserDtoToUserConverter();

        User user = converter.convert(userDto);

        assertEquals(ID, user.getUserId());
        assertEquals(FIRST_NAME, user.getFirstName());

    }

}