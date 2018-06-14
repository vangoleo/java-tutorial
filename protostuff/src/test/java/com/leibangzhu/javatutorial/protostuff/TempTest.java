package com.leibangzhu.javatutorial.protostuff;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.junit.Test;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.HashMap;

public class TempTest {

    @Test
    public void test() throws Exception{

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

        // write 10
        dataOutputStream.writeInt(10);

        // write HashMap bytes
        byte[] bytes = get_bytes();
        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(bytes);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);

        int i = dataInputStream.readInt();

        int length = dataInputStream.readInt();
        byte[] bytes2 = new byte[length];
        dataInputStream.read(bytes2,0,length);

        Schema<HashMap> schema = RuntimeSchema.getSchema(HashMap.class);

        HashMap<String,String> map2 = schema.newMessage();

        ProtobufIOUtil.mergeFrom(bytes2,map2,schema);
    }

    private HashMap<String,String> create_map(){
        HashMap<String,String> map = new HashMap<>();
        map.put("hello","world");
        map.put("foo","bar");
        return map;
    }

    private byte[] get_bytes(){
        HashMap<String,String> map = create_map();
        LinkedBuffer buffer = LinkedBuffer.allocate();
        Schema<HashMap> schema = RuntimeSchema.getSchema(HashMap.class);

        byte[] bytes = ProtobufIOUtil.toByteArray(map,schema,buffer);
        return bytes;
    }
}
