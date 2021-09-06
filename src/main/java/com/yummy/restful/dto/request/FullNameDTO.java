package com.yummy.restful.dto.request;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FullNameDTO {
    private String token;
    private String fullName;
}
