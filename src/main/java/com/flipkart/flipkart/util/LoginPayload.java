package com.flipkart.flipkart.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginPayload {
    String username;
    String password;
}
