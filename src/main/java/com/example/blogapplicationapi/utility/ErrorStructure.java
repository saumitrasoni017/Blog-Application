package com.example.blogapplicationapi.utility;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErrorStructure {
    private int errorCode;
    private String errorMessage;
}
