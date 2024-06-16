package org.service.microserviceuser.services;

import org.service.microserviceuser.DTOs.UserDTO;
import org.service.microserviceuser.Requests_Responses.UserCreatedResponse;
import org.service.microserviceuser.entities.UserEntity;
import org.service.microserviceuser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;


    @Override
    public List<UserEntity> getAllUsers() {
        if(userRepository.findAll().isEmpty()) {
            return new ArrayList<UserEntity>();
        }else{
            return userRepository.findAll();
        }
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if(email.isEmpty() || email.isBlank() || user.isEmpty()){
            return new UserDTO();
        }else{
            return UserDTO
                    .builder()
                    .id(user.get().getId())
                    .name(user.get().getName())
                    .lastname(user.get().getLastname())
                    .email(user.get().getEmail())
                    .phone(user.get().getPhone())
                    .doc(user.get().getDoc())
                    .build();
        }
    }

    @Override
    public UserDTO findUserByDoc(String doc) {
        Optional<UserEntity> user = userRepository.findByDoc(doc);
        if(doc.isEmpty() || doc.isBlank() || user.isEmpty()){
            return new UserDTO();
        }else{
            return UserDTO
                    .builder()
                    .id(user.get().getId())
                    .name(user.get().getName())
                    .lastname(user.get().getLastname())
                    .email(user.get().getEmail())
                    .phone(user.get().getPhone())
                    .doc(user.get().getDoc())
                    .build();
        }
    }

    @Override
    public UserDTO findUserById(String id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if(id.isEmpty() || id.isBlank() || user.isEmpty()){
            return null;
        }else{
            return UserDTO
                    .builder()
                    .id(user.get().getId())
                    .name(user.get().getName())
                    .lastname(user.get().getLastname())
                    .email(user.get().getEmail())
                    .phone(user.get().getPhone())
                    .doc(user.get().getDoc())
                    .build();
        }
    }

    @Override
    public UserCreatedResponse saveUser(UserEntity user) {
        if(userRepository.findByDoc(user.getDoc()).isPresent() || userRepository.findByEmail(user.getEmail()).isPresent()){
            return new UserCreatedResponse("user already exists",null);
        }else{
            UserEntity savedUser = userRepository.save(user);
            return new UserCreatedResponse("user created",savedUser);
        }
    }

    @Override
    public String updateUser(UserEntity user) {
        if(userRepository.findById(user.getId()).isEmpty()){
            return "user not found";
        }else{
            userRepository.save(user);
            return "user updated";
        }
    }

    @Override
    public String deleteUser(String id) {
        if(id.isEmpty() || id.isBlank() || userRepository.findById(id).isEmpty()){
            return "user not found";
        }else{
            userRepository.deleteById(id);
            return "user deleted";
        }
    }
}
