package com.application.shopapi.ExtraModel;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@RequiredArgsConstructor
public class APIResponse {
    HttpStatus status;
    int code;
    String message;
    LocalDateTime timeStamp;
    //Object data;

}
