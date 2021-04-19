package com.icf.employee.dto;

import java.io.Serializable;


public class AuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 12501650815483573L;

    private final String token;

    public AuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
