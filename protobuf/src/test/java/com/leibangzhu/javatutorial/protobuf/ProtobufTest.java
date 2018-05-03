package com.leibangzhu.javatutorial.protobuf;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ProtobufTest {

    private final String fileName = "/Users/leiwei/tmp/person.protobuf";

    @Test
    public void test_write_to_file() throws Exception{
        AddressBookProtos.AddressBook.Builder addressBook = AddressBookProtos.AddressBook.newBuilder();

        AddressBookProtos.Person.Builder tom = AddressBookProtos.Person.newBuilder();
        tom.setId(0);
        tom.setName("tom");
        tom.setEmail("tom@gmail.com");
        AddressBookProtos.Person.PhoneNumber.Builder phoneNumberTom = AddressBookProtos.Person.PhoneNumber.newBuilder();
        phoneNumberTom.setNumber("13588888888");
        phoneNumberTom.setType(AddressBookProtos.Person.PhoneType.MOBILE);
        tom.addPhones(phoneNumberTom);

        AddressBookProtos.Person.Builder jerry = AddressBookProtos.Person.newBuilder();
        jerry.setId(1);
        jerry.setName("jerry");
        jerry.setEmail("jerry@163.com");
        AddressBookProtos.Person.PhoneNumber.Builder phoneNumberJerry = AddressBookProtos.Person.PhoneNumber.newBuilder();
        phoneNumberJerry.setNumber("13581234520");
        phoneNumberJerry.setType(AddressBookProtos.Person.PhoneType.MOBILE);
        jerry.addPhones(phoneNumberJerry);

        addressBook.addPeople(tom);
        addressBook.addPeople(jerry);

        FileOutputStream output = new FileOutputStream(fileName);
        addressBook.build().writeTo(output);
    }

    @Test
    public void test_read_from_file() throws Exception{

        AddressBookProtos.AddressBook addressBook =
                AddressBookProtos.AddressBook.parseFrom(new FileInputStream(fileName));

        for (AddressBookProtos.Person person : addressBook.getPeopleList()){
            System.out.println("========================");
            System.out.println(person.getId());
            System.out.println(person.getName());
            System.out.println(person.getEmail());
            for (AddressBookProtos.Person.PhoneNumber phoneNumber : person.getPhonesList()){
                System.out.println(phoneNumber.getNumber());
                System.out.println(phoneNumber.getType());
            }
        }
    }
}
