package com.company;

import java.io.*;

public class RWPerson {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
write();
read();
    }

    public static void write() throws IOException {
        FileOutputStream file = new FileOutputStream("src/com/company/data/person.bin");
        ObjectOutputStream out = new ObjectOutputStream(file);
        Person person = new Person(1,"Валера");
        person.addEmail("vitstep@mail.com");

        System.out.println(person.toString());
        out.writeObject(person);

        out.close();
        file.close();

    }
    public static void read() throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream("src/com/company/data/person.bin");
        ObjectInputStream in = new ObjectInputStream(file);
        Person person= (Person) in.readObject();

        System.out.println(person.toString());
    }
}
