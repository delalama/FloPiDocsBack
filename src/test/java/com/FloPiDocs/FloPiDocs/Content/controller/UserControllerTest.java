package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.model.dto.UserDTO;
import com.FloPiDocs.FloPiDocs.Content.service.DocumentService;
import com.FloPiDocs.FloPiDocs.Content.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Test
    void testController() {
        UserService userService = Mockito.mock(UserService.class);
        DocumentService documentService = Mockito.mock(DocumentService.class);

        UserController controller = new UserController(userService, documentService);

        ResponseEntity<List<UserDTO>> userList = controller.getAllUsers();

        assertEquals(userList.getStatusCode().value(), 200);
    }

}