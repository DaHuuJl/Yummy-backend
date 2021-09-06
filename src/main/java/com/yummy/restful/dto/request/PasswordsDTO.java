package com.yummy.restful.dto.request;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PasswordsDTO {
    private String token;
    private String oldPassword;
    private String newPassword;
}
