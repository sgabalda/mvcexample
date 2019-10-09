/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sergigabol.mvcexample.actions;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author gabalca
 */
public interface ActionFactory {
    Action getAction(HttpServletRequest req);
}
