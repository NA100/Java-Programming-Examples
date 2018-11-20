package com.tgt.testapp.streams;

public class Person {

    private String name;
    private Gender gender;
    private int salary;

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getSalary() {
        return salary;
    }

    public Person(String name, Gender gender, int salary) {
        this.name = name;
        this.gender = gender;
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", salary=" + salary +
                '}';
    }
}
