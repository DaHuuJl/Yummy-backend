package com.yummy.restful.dto.request;

import lombok.*;

//отправить запрос на сервер (request)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestRegistrationDTO {
    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;
}