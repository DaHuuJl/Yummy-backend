package com.yummy.restful.dto.general;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginHistoryDTO {
    private String browser;
    private String date;
}
