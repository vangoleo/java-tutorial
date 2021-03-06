package com.leibangzhu.javatutorial.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

import com.leibangzhu.javatutorial.protobuf.AddressBookProtos.AddressBook;
import com.leibangzhu.javatutorial.protobuf.AddressBookProtos.Person;

@Ignore
public class ProtobufTest {

    private final String fileName = "/Users/leiwei/tmp/person.protobuf";

    @Test
    public void test_write_to_file() throws Exception{

        AddressBook addressBook = create_address_book();

        FileOutputStream output = new FileOutputStream(fileName);
        addressBook.writeTo(output);
    }

    @Test
    public void test_read_from_file() throws Exception{

        AddressBook addressBook = AddressBook.parseFrom(new FileInputStream(fileName));

        print(addressBook);
    }

    @Test
    public void test_write_to_read_from_bytes() throws Exception {
        AddressBook addressBook = create_address_book();

        byte[] data = addressBook.toByteArray();

        AddressBook addressBook2 = AddressBook.parseFrom(data);
        print(addressBook2);
    }

    @Test
    public void test_write_to_read_from_bytes_student() throws Exception {
        StudentModel.Student student = create_student();

        byte[] data = student.toByteArray();

        StudentModel.Student student2 = StudentModel.Student.parseFrom(data);
        print(student2);
    }

    private StudentModel.Student create_student(){
        StudentModel.Student.Builder student = StudentModel.Student.newBuilder();

        student.setName("tom");
        student.setId(10);
        student.setEmail("tom@gmail.com");

        return student.build();
    }

    private AddressBook create_address_book(){
        AddressBook.Builder addressBook = AddressBook.newBuilder();

        Person.Builder tom = Person.newBuilder();
        tom.setId(0);
        tom.setName("tom");
        tom.setEmail("tom@gmail.com");
        Person.PhoneNumber.Builder phoneNumberTom = Person.PhoneNumber.newBuilder();
        phoneNumberTom.setNumber("13588888888");
        phoneNumberTom.setType(Person.PhoneType.MOBILE);
        tom.addPhones(phoneNumberTom);

        Person.Builder jerry = Person.newBuilder();
        jerry.setId(1);
        jerry.setName("jerry");
        jerry.setEmail("jerry@163.com");
        Person.PhoneNumber.Builder phoneNumberJerry = Person.PhoneNumber.newBuilder();
        phoneNumberJerry.setNumber("13581234520");
        phoneNumberJerry.setType(Person.PhoneType.MOBILE);
        jerry.addPhones(phoneNumberJerry);

        addressBook.addPeople(tom);
        addressBook.addPeople(jerry);

        return addressBook.build();
    }

    private void print(AddressBook addressBook){
        for (Person person : addressBook.getPeopleList()){
            System.out.println("========================");
            System.out.println(person.getId());
            System.out.println(person.getName());
            System.out.println(person.getEmail());
            for (Person.PhoneNumber phoneNumber : person.getPhonesList()){
                System.out.println(phoneNumber.getNumber());
                System.out.println(phoneNumber.getType());
            }
        }
    }

    private void print(StudentModel.Student student){
        System.out.println(student.getName());
        System.out.println(student.getId());
        System.out.println(student.getEmail());
    }

}
