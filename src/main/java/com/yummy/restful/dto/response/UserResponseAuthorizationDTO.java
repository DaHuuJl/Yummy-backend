package com.yummy.restful.dto.response;

import lombok.*;

//получить ответ от сервера (response)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseAuthorizationDTO {
    private String token;
}