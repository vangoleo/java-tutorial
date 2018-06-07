package com.leibangzhu.javatutorial.protostuff;

import com.leibangzhu.javatutorial.protobuf.AddressBookProtos;
import com.leibangzhu.javatutorial.protobuf.RequestModel;
import com.leibangzhu.javatutorial.protobuf.ResponseModel;
import com.leibangzhu.javatutorial.protobuf.StudentModel;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.junit.Test;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import sun.jvm.hotspot.runtime.Bytes;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void test4(){
        Map<String,String> params = new LinkedHashMap<>();
        params.put("hello","world");
        params.put("foo","bar");
        Request request = new Request(10,"haha",params);

        LinkedBuffer buffer = LinkedBuffer.allocate();
        Schema<Request> schema = RuntimeSchema.getSchema(Request.class);
        byte[] bytes = ProtobufIOUtil.toByteArray(request,schema,buffer);

        Request request2 = schema.newMessage();
        ProtobufIOUtil.mergeFrom(bytes,request2,schema);
        System.out.println(request2.getId());
        System.out.println(request2.getName());
        System.out.println(request2.getParams());
    }

    // 测试protostuff生成的protobuff格式的数据能被protobuf根据proto文件生成的类解析
    @Test
    public void test3() throws Exception{
        // 生成一个pojo类
        Student tom = new Student("tom",10,"tom@gmail.com");

        // 使用protostuff生成protobuff格式的字节数组
        LinkedBuffer buffer = LinkedBuffer.allocate();
        Schema<Student> schema = RuntimeSchema.getSchema(Student.class);
        byte[] bytes = ProtostuffIOUtil.toByteArray(tom,schema,buffer);

        // 将字节数组反序列化成protobuff自动生成的类
        StudentModel.Student student = StudentModel.Student.parseFrom(bytes);

        System.out.println(student.getName());
        System.out.println(student.getId());
        System.out.println(student.getEmail());
        // 注意，这里有两个student类。一个是根据student.proto文件自动生成的，是Protobuff官方提供的方式
        // 另一个是我们根据student.proto文件，自己写的POJO类。POJO类的字段和student.proto中的字段是一一对应的
    }

    @Test
    public void test5() throws Exception{
        Request request = create_request();

        LinkedBuffer buffer = LinkedBuffer.allocate();
        Schema<Request> schema = RuntimeSchema.getSchema(Request.class);
        byte[] bytes = ProtobufIOUtil.toByteArray(request,schema,buffer);

        RequestModel.Request request2 = RequestModel.Request.parseFrom(bytes);
        System.out.println(request2.getId());
        System.out.println(request2.getName());
        System.out.println(request2.getParamsMap());    // 这里打印的Map不对。protostuff生成的字节数组和protobuff不一样！！！看来在map的兼容上，还是有问题呀。。
        // map不兼容，只能使用proto2协议中处理map的方式了:
//        message MapFieldEntry {
//            key_type key = 1;
//            value_type value = 2;
//        }
//
//        repeated MapFieldEntry map_field = N;
    }

    @Test
    public void test6() throws Exception {
        Response response = create_response();

        LinkedBuffer buffer = LinkedBuffer.allocate();
        Schema<Response> schema = RuntimeSchema.getSchema(Response.class);
        byte[] bytes = ProtobufIOUtil.toByteArray(response,schema,buffer);

        ResponseModel.Response response2 = ResponseModel.Response.parseFrom(bytes);
        System.out.println(response2.getId());
        System.out.println(response2.getName());
        response2.getParamsList().forEach(s -> System.out.println(s.getKey() + s.getValue()));
    }


    private Request create_request(){
        Map<String,String> params = new LinkedHashMap<>();
        params.put("hello","world");
        params.put("foo","bar");
        Request request = new Request(10,"haha",params);
        return request;
    }

    private Response create_response(){
        List<MapFieldEntry> parames = new ArrayList<>();
        parames.add(new MapFieldEntry("hello","world"));
        parames.add(new MapFieldEntry("foo","bar"));

        Response response = new Response(10,"tom",parames);
        return response;
    }

}
