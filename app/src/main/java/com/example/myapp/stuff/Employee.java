package com.example.myapp.stuff;

/**
 * POJO - plain old java object / VO value object / model class -- box with partitionns
 */

public class Employee {
    String name;
    int age;
    String postalAddress;

    public Employee(String name, int age, String postalAddress) {
        Student s1 = new Student("Jake",321,"MIT");
        System.out.println("Employee is getting Created: "+ s1.getName());
        this.name = name;
        this.age = age;
        this.postalAddress = postalAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }
}

