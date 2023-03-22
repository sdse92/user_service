package com.sdse.user_service.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class UserRequest {

    private String name;

    private String login;

    private String password;

    private String email;

    private String phone;

}
