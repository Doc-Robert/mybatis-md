package com.geek.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Robert
 * @create 2020/12/21 8:48
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String lastName;
    private String email;
    private String gender;
    private String password;

}
