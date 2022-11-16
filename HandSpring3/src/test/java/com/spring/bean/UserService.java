package com.spring.bean;

/**
 * @Author: 周 杰
 * @Date: 2022/11/14/下午9:49
 * @Description:
 */
public class UserService {

    private String name;


    public UserService(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                '}';
    }

    public void queryUserInfo(){
        System.out.println("查询用户信息: " + name);
    }
}
