package com.example.myapp.stuff

fun main() {
    var myStudent: Student = Student("Mike",21,"Kansas")
    println(myStudent.name)
    myStudent.name = "Ray"
    println(myStudent.name)

    var myEmployee: Employee = Employee("Blake",23,"New York")
    println(myEmployee.getName())
    println(myEmployee.name)

    var myTestEmployee: TestEmployee = TestEmployee("Micky",31,"Las Vegas")
    println(myTestEmployee.name)
    println(myTestEmployee.age)

}