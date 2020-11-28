package com.FloPiDocs.FloPiDocs.Content.service.converter.UserService;

import com.FloPiDocs.FloPiDocs.Content.model.dto.UserDTO;
import com.FloPiDocs.FloPiDocs.Content.repository.UserRepository;
import com.FloPiDocs.FloPiDocs.Content.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.List;

import static org.mockito.Mockito.when;

public class UserServiceTest {
    
    @Mock
    UserRepository userRepository;
    
    @InjectMocks
    UserService userService;

    @Test
    public void when_find_all_users_it_should_return_list_user(){
    //GUILLE, no podría probar que el repositorio me devolviese un List<UserDto>??
        //        when(userService.findAll()). ;
    }
}
