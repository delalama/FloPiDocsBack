package com.FloPiDocs.FloPiDocs.Content.service.converter;

import com.FloPiDocs.FloPiDocs.Content.model.dto.UserDTO;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.User;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserConverter implements Converter<UserDTO, User> {

    @Override
    public User convert(UserDTO userDTO) { return new ModelMapper().map(userDTO, User.class);
    }
}
