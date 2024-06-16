package org.service.microserviceuser.Requests_Responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.service.microserviceuser.entities.UserEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreatedResponse {
    private String message;
    private UserEntity user;
}
