package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.User;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * The type User to user dto converter.
 */
@Component
public class UserToUserDtoConverter implements Converter<User, com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto> {

    @Override
    public com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto convert(User user) {
        return new ModelMapper().map(user, com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto.class);
    }
}
