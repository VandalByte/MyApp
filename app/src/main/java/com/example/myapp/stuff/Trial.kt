package com.example.myapp.stuff

fun main() {
    tempToday("Monday", "34 C")

}

fun tempToday(day:String, temp:String){
    println("It's a beautiful $day with temperatures $temp")
}

// compact function
fun double(x:Int):Int = x * 2