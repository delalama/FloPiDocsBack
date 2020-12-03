package com.FloPiDocs.FloPiDocs.Content.service.converter.UserService;

import com.FloPiDocs.FloPiDocs.Content.repository.UserRepository;
import com.FloPiDocs.FloPiDocs.Content.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

/**
 * The type User service test.
 */
public class UserServiceTest {

    /**
     * The User repository.
     */
    @Mock
    UserRepository userRepository;

    /**
     * The User service.
     */
    @InjectMocks
    UserService userService;

    /**
     * When find all users it should return list user.
     */
    @Test
    public void when_find_all_users_it_should_return_list_user(){
    //GUILLE, no podría probar que el repositorio me devolviese un List<UserDto>??
        //        when(userService.findAll()). ;
    }
}
