package com.leibangzhu.javatutorial.protobuf;

import org.junit.Ignore;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

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

}
