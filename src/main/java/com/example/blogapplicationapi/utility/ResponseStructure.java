package com.example.blogapplicationapi.utility;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseStructure<T> {
    int statusCode;
    String message;
    T data;
}
