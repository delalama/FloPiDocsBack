package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.User;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * The type User dto to user converter.
 */
@Component
public class UserDtoToUserConverter implements Converter<com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto, User> {

    @Override
    public User convert(com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto userDTO) { return new ModelMapper().map(userDTO, User.class);
    }
}
