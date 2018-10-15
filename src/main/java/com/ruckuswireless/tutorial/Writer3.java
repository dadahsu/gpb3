package com.ruckuswireless.tutorial;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Writer3 {
    public static void main(String[] args) throws IOException {
        AddressBookProtos.Person.Builder builder = AddressBookProtos.Person.newBuilder();
        builder.setId(1).setName("name1").setEmail("email1");
        addPhone(builder, "11111111");
        addPhone(builder, "22222222");
        addPhone(builder, "33333333");
        addPhone(builder, "44444444");
        addPhone(builder, "55555555");
        addPhone(builder, "66666666");
        addPhone(builder, "77777777");
        AddressBookProtos.Person person = builder.build();

        System.out.println(person);
        FileOutputStream output = new FileOutputStream("D:\\tmp\\gpb3.bin");
        person.writeTo(output);
        output.close();
    }

    private static void addPhone(AddressBookProtos.Person.Builder builder, String number) {
        builder.addPhones(AddressBookProtos.Person.PhoneNumber.newBuilder()
                .setNumber(number).build());

    }
}
