/**
 * Copyright (c) 2010 laomie <laomie@msn.com>
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * # Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 *
 * # Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 */

package org.laomie.shop.web.login;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import org.laomie.shop.entity.User;
import org.laomie.shop.service.common.UserService;

/**
 *
 * @author laomie
 */
public class LoginAction implements Serializable {
    private int userId;
    private String userName;
    private LoginForm loginForm;
    private UserService userService;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }

    public void setLoginForm(LoginForm loginForm) {
        this.loginForm = loginForm;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void initLogin(ActionEvent event) throws IOException {
        System.out.println("============= initLogin");
        List<User> users = userService.getUsers();
        for (User user : users) {
            System.out.println("============ user:" + user.getUserName());
        }
        System.out.println("============loginForm: " + loginForm);
        this.loginForm.setUsers(users);
        //return "step1";
    }

    public void loadUsers(PhaseEvent event) throws IOException {
        System.out.println("============= beforephrase");
        List<User> users = userService.getUsers();
        this.loginForm.setUsers(users);
        for (User user : loginForm.getUsers()) {
            System.out.println("============ " + user.getUserName());
        }
    }
    
}
