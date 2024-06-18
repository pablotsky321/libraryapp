package org.service.microservicebooking.clients;

import org.service.microservicebooking.DTOs.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "microservice-user",url="${microservices.user}")
public interface UserClient {

    @GetMapping("/api/user/findById/{id_user}")
    Optional<UserDTO> getUserById(@PathVariable("id_user") String id_user);

}
