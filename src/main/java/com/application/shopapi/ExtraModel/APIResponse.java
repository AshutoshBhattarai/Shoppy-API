package com.application.shopapi.ExtraModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class APIResponse {
    HttpStatus status;
    int code;
    String message;
    LocalDateTime timeStamp;
    //Object data;

}
