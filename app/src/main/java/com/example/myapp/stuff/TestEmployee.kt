package com.example.myapp.stuff

class TestEmployee(name: String, age: Int, postalAddress: String) {
    var name: String
    var age: Int
    var postalAddress: String

    init {
        val s1 = Employee("Henry", 20, "Cape Town")
        println("Employee is getting Created: " + s1.name)
        this.name = name
        this.age = age
        this.postalAddress = postalAddress
    }
}

