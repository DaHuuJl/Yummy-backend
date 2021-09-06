package com.yummy.restful.dto.request;

import lombok.*;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumberDTO {
    private String token;
    private String phoneNumber;
}