package com.yummy.restful.dto.request;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestAuthorizationDTO {
    private String phoneNumber;
    private String password;
}