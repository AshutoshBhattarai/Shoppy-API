package com.application.shopapi.User.RequestHandler;

import com.application.shopapi.Admin.AdminModel;
import com.application.shopapi.User.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminRequest {
    UserModel user;
    AdminModel admin;
}
