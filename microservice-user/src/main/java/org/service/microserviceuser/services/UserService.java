package org.service.microserviceuser.services;

import org.service.microserviceuser.DTOs.UserDTO;
import org.service.microserviceuser.Requests_Responses.UserCreatedResponse;
import org.service.microserviceuser.entities.UserEntity;


import java.util.List;


public interface UserService {

    List<UserEntity> getAllUsers();

    UserDTO findUserByEmail(String email);

    UserDTO findUserByDoc(String doc);

    UserDTO findUserById(String id);

    UserCreatedResponse saveUser(UserEntity user);

    String updateUser(UserEntity user);

    String deleteUser(String id);

}
