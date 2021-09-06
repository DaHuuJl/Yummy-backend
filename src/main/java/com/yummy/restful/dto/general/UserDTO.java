package com.yummy.restful.dto.general;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String image;
    private String fullName;
    private String phoneNumber;
}