/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sergigabol.mvcexample.model;

import java.util.List;

/**
 *
 * @author gabalca
 */
public interface UserLocal {
    List<User> getAllUsers();
    void deleteUser(Long userId) throws UserNotfoundException;
}
