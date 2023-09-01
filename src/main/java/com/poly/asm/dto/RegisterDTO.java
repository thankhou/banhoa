package com.poly.asm.dto;

import com.poly.asm.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO extends Account {
    private String fullname;
    private String username;
    private String email;
    private String password;
}
