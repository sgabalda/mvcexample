/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sergigabol.mvcexample.views;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gabalca
 */
public abstract class AbstractViewModelMap implements View{
    
    private Map<String,Object> data = new HashMap<>();

    @Override
    public void addModelData(String code, Object data){
        this.data.put(code, data);
    }
    
    protected Map<String,Object> getData(){
        return data;
    }
    
}
