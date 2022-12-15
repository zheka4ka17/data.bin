package com.company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Arrays;

public class WriteXML {
    public static void main(String[] args) {
        writePerson();
        writePersons();


    }
    public static void writePerson(){
        Person person = new Person(1, "Alex");
        person.setEmails(Arrays.asList(" alex@gmail.com ", " alex@rambler.ru "));

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

            //Print XML String to file
            jaxbMarshaller.marshal(person, new File("src/com/company/data/person.xml"));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    public static void writePersons(){
        Person person = new Person(1, "Alex");
        person.addEmail(" alex@gmail.com ");
        person.addEmail(" alex@rambler.ru ");

        Person person2 = new Person(2, "Alex2");
        person2.addEmail(" alex@gmail.com ");
        person2.addEmail(" alex@rambler.ru ");

        Persons persons = new Persons();
        persons.addPerson(person);
        persons.addPerson(person2);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

            //Print XML String to file
            jaxbMarshaller.marshal(persons, new File("src/com/company/data/persons.xml"));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
