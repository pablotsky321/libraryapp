package org.service.microservicebooking.clients;

import org.service.microservicebooking.DTOs.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-user",url="http://localhost:8090")
public interface UserClient {

    @GetMapping("/api/v1/user/findById/{id_user}")
    UserDTO getUserById(@PathVariable("id_user") String id_user);

}
