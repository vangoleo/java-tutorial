package com.leibangzhu.javatutorial.protostuff;

import java.util.Map;

public class ProtobufMapWrapper {
    private Map<String,String> map;

    public ProtobufMapWrapper(Map<String, String> map) {
        this.map = map;
    }

    public Map<String, String> getMap() {
        return map;
    }
}
