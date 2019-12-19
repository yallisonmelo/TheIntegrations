package com.yfsmsystem.theintegrations.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Error {

    
    private String code;
    private String type;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> descriptions;

}