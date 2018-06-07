package com.leibangzhu.javatutorial.protostuff;

import java.util.Map;

public class Request {

    private int id;
    private String name;
    private Map<String,String> params;

    public Request(){

    }

    public Request(int id, String name,Map<String,String> params){
        this.id = id;
        this.name = name;
        this.params = params;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getParams() {
        return params;
    }
}
