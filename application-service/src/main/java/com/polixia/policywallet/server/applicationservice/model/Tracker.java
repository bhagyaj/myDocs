package com.polixia.policywallet.server.applicationservice.model;

import java.util.HashMap;

public class Tracker {
    HashMap<String,Integer> map = new HashMap<String, Integer>();
    int count=0;

//    public HashMap<String, Integer> getMap() {
//        return map;
//    }
//
//    public void setMap(HashMap<String, Integer> map) {
//        this.map = map;
//    }

    public void add(String name){
        map.put(name,count);
        count++;
    }

    public boolean check(String name){
        if(map.containsKey(name)){
            return true;
        }
        return false;
    }

    public Integer getId(String name){
        return map.get(name);
    }
}
