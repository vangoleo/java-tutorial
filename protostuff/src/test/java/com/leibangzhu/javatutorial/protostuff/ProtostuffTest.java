package com.leibangzhu.javatutorial.protostuff;

import com.leibangzhu.javatutorial.protobuf.AddressBookProtos;
import com.leibangzhu.javatutorial.protobuf.StudentModel;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.junit.Test;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

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

    @Test
    public void test2(){

        Person person = new Person("tom",20);
        LinkedBuffer buffer = LinkedBuffer.allocate();
        Schema<Person> schema = RuntimeSchema.getSchema(Person.class);
        byte[] bytes = ProtostuffIOUtil.toByteArray(person,schema,buffer);

        Objenesis objenesis = new ObjenesisStd(true);
        Person message = objenesis.newInstance(Person.class);
        ProtostuffIOUtil.mergeFrom(bytes,message,schema);

        System.out.println(message.getName() + message.getAge());
    }

    // 测试protostuff生成的protobuff格式的数据能被protobuf根据proto文件生成的类解析
    @Test
    public void test3() throws Exception{
        // 生成一个pojo类
        Student tom = new Student("tom",10,"tom@gmail.com");

        // 使用protostuff生成protobuff格式的字节数组
        LinkedBuffer buffer = LinkedBuffer.allocate();
        Schema<Student> schema = RuntimeSchema.getSchema(Student.class);
        byte[] bytes = ProtobufIOUtil.toByteArray(tom,schema,buffer);

        // 将字节数组反序列化成protobuff自动生成的类
        StudentModel.Student student = StudentModel.Student.parseFrom(bytes);

        System.out.println(student.getName());
        System.out.println(student.getId());
        System.out.println(student.getEmail());
        // 注意，这里有两个student类。一个是根据student.proto文件自动生成的，是Protobuff官方提供的方式
        // 另一个是我们根据student.proto文件，自己写的POJO类。POJO类的字段和student.proto中的字段是一一对应的
    }
}
