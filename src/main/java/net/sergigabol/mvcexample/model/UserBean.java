/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sergigabol.mvcexample.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author gabalca
 */
@Stateless
@Local(UserLocal.class)
public class UserBean implements UserLocal {
    
    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @Override
    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        User u1 = new User();
        u1.setId(1L);
        u1.setUsername("user 1");
        result.add(u1);
        u1 = new User();
        u1.setId(2L);
        u1.setUsername("user 2");
        result.add(u1);
        
        return result;
    }
    
    @Override
    public void deleteUser(Long userId) throws UserNotfoundException {
        if(userId>2 || userId<1){
            throw new UserNotfoundException();
        }
        LOG.info("hem eliminat l'usuari "+userId);
    }
    
}
