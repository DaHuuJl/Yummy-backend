package com.yummy.restful.dto.general;

import lombok.*;

import java.io.File;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ImageDTO {
    private String token;
    private String image;
}
