package com.leibangzhu.javatutorial.protobuf;

import java.io.*;

import com.leibangzhu.javatutorial.protobuf.AddressBookProtos.Person;
import com.leibangzhu.javatutorial.protobuf.AddressBookProtos.AddressBook;


public class AddPerson {

    public static AddressBookProtos.Person PromptForAddress(BufferedReader stdin, PrintStream stdout) throws Exception{
        Person.Builder person = Person.newBuilder();

        stdout.print("Enter person ID:");
        person.setId(Integer.valueOf(stdin.readLine()));

        stdout.println("Enter name:");
        person.setName(stdin.readLine());

        stdout.print("Enter email address (blank for none): ");
        String email = stdin.readLine();
        if (email.length() > 0) {
            person.setEmail(email);
        }

        while (true){
            stdout.print("Enter a phone number (or leave blank to finish): ");
            String number = stdin.readLine();
            if (number.length() == 0){
                break;
            }

            Person.PhoneNumber.Builder phoneNumber = Person.PhoneNumber.newBuilder().setNumber(number);

            stdout.print("Is this a mobile, home, or work phone? ");
            String type = stdin.readLine();
            if (type.equals("mobile")) {
                phoneNumber.setType(Person.PhoneType.MOBILE);
            } else if (type.equals("home")) {
                phoneNumber.setType(Person.PhoneType.HOME);
            } else if (type.equals("work")) {
                phoneNumber.setType(Person.PhoneType.WORK);
            } else {
                stdout.println("Unknown phone type.  Using default.");
            }

            person.addPhones(phoneNumber);
        }

        return person.build();
    }

    public static void main(String[] args) throws Exception {
        String fileName = "/Users/leiwei/tmp/person.protobuf";
//        if (args.length != 1) {
//            System.err.println("Usage:  AddPerson ADDRESS_BOOK_FILE");
//            System.exit(-1);
//        }

        AddressBook.Builder addressBook = AddressBook.newBuilder();

        // Read the existing address book.
        try {
            addressBook.mergeFrom(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            System.out.println(fileName + ": File not found.  Creating a new file.");
        }

        // Add an address.
        addressBook.addPeople(
                PromptForAddress(new BufferedReader(new InputStreamReader(System.in)),
                        System.out));

        // Write the new address book back to disk.
        FileOutputStream output = new FileOutputStream(fileName);
        addressBook.build().writeTo(output);
        output.close();
    }

}
