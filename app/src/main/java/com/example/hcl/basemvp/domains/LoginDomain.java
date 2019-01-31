package com.example.hcl.basemvp.domains;

/**
 * 登录实体类
 */
public class LoginDomain {
    private String name;
    private String pass;



    public LoginDomain(String name, String pass) {

        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String sayHello() {
        return "Hello "+this.name;
    }
}
