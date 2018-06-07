package com.leibangzhu.javatutorial.protostuff;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.junit.Test;

public class ProtostuffTest {

    @Test
    public void test(){
        Person person = new Person("tom",20);

        LinkedBuffer buffer = LinkedBuffer.allocate();
        Schema<Person> schema = RuntimeSchema.getSchema(Person.class);

        byte[] protobufBytes = ProtobufIOUtil.toByteArray(person,schema,buffer);

        Person person2 = schema.newMessage();
        ProtobufIOUtil.mergeFrom(protobufBytes,person2,schema);
        System.out.println(person2.getName() + person2.getAge());
    }
}
