package com.tgt.testapp.dataoperations;

import com.tgt.testapp.streams.Gender;
import com.tgt.testapp.streams.Person;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class JavaStreamOperations {

    public static void main(String args[]) {

        Person person1 = new Person("Achala,", Gender.FEMALE, 10000);
        Person person2 = new Person("Neha", Gender.FEMALE, 20000);
        Person person3 = new Person("Yagna", Gender.MALE, 23000);
        Person person4 = new Person("Avinash,", Gender.MALE, 30000);
        Person person5 = new Person("Khushboo", Gender.FEMALE, 36000);

        List<Person> personList = new ArrayList<>();

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);

        //Question-2 Given a list of Persons, print all female name starting with 'A'
        // without streams
        for(Person person : personList) {
            if (person.getName().startsWith("A") && person.getGender() == Gender.FEMALE) {
                System.out.println(person.toString());
            } else {
                continue;
            }
        }


        // With streams
        List<Person> femaleAList = personList.stream().filter(person -> person.getGender() == Gender.FEMALE)
               .filter(person -> person.getName().startsWith("A"))
                .collect(Collectors.toList());

        for (Person person: femaleAList) {
            System.out.println(person.toString());
        }


        //Question-3  Given list of Persons, convert the Arraylist to a Hashmap (key:name, value: gender)
        //old way
        Map<String, Gender> personMap = new HashMap<>();
        for (Person person : personList) {
            personMap.put(person.getName(), person.getGender());
        }

        //new way
        Map<String, Gender> newPersonMap = personList.stream().collect(Collectors.toMap(Person::getName, Person::getGender));


        //Question-4 Find the name of the female Person getting the highest salary.
        //old way
        int highestSalary = 0;
        String femaleWithHighestSalary = "";

        for (Person person : personList) {
            if (person.getSalary() > highestSalary) {
                highestSalary = person.getSalary();
                femaleWithHighestSalary = person.getName();
            }
        }

        System.out.println("Female person with highest salary(old): " + femaleWithHighestSalary);

        //new way
        Comparator<Person> comparison = Comparator.comparing(Person::getSalary);
        Person femaleWithHighestSal = personList.stream().filter(person -> person.getGender() == Gender.FEMALE).max(comparison).get();

        System.out.println("Female person with highest salary(new): " + femaleWithHighestSal.getName());

        // Q5 Print the total salary of all male Persons.
        // old way
        int totalMaleSalary = 0;
        for (Person person : personList) {
            if (person.getGender() == Gender.MALE) {
                totalMaleSalary += person.getSalary();
            }
        }

        System.out.println("total salary of all male persons(old): " + totalMaleSalary);

        // new way
        int totalMSalary = 0;
        totalMSalary = personList.stream().filter(person -> person.getGender() == Gender.MALE)
                .map(Person::getSalary).reduce(0, (x, y) -> x + y);

        System.out.println("total salary of all male persons(new): " + totalMSalary);
    }
}
