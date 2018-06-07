package com.leibangzhu.javatutorial.protostuff;

import java.util.List;

public class Response {
    private int id;
    private String name;
    private List<MapFieldEntry> params;

    public Response(int id, String name, List<MapFieldEntry> params){
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

    public List<MapFieldEntry> getParams() {
        return params;
    }
}
