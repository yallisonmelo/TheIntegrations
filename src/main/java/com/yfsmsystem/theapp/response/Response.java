package com.yfsmsystem.theapp.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Response<T> {

    private T data;

    public Response(T data) {
        this.data = data;
    }
}