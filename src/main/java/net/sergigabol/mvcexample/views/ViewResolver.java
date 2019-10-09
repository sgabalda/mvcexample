/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sergigabol.mvcexample.views;

/**
 *
 * @author gabalca
 */
public interface ViewResolver {
    View getView(String viewCode);
}
