package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Mem implements Serializable {
    private String mem_id;
    private String mem_pw;
    private String mem_nm;
    private String mem_cd;
    private Role role;

    public void setMem_cd(String mem_cd) {
        this.mem_cd = mem_cd;

        if (mem_cd.equals("0")) {  // 회원 코드가 0 이면 Role은 User
            this.role = Role.USER;
        } else if (mem_cd.equals("1")) {// 회원 코드가 1 이면 Role은 ADMIN
            this.role = Role.ADMIN;
        }
    }
}
