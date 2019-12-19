package com.yfsmsystem.theintegrations.dto;

import com.yfsmsystem.theintegrations.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NumberVerifyDto {

    private Boolean valid;
    private String number;
    private String local_format;
    private String international_format;
    private String country_prefix;
    private String country_code;
    private String country_name;
    private String location;
    private String carrier;
    private String line_type;
}
