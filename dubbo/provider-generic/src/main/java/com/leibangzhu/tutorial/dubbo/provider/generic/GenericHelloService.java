package com.leibangzhu.tutorial.dubbo.provider.generic;

import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;

public class GenericHelloService implements GenericService {
    @Override
    public Object $invoke(String method, String[] parameterTypes, Object[] args) throws GenericException {
        if ("hello".equals(method)){
            return "Welcome" + args[0];
        }
        return "";
    }
}
