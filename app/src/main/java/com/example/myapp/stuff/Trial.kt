package com.example.myapp.stuff



fun tempToday(day:String, temp:String){
    println("It's a beautiful $day with temperatures $temp")
}

// compact function
fun double(x:Int):Int = x * 2

fun String.commaSep(value: String):String{
    val newStr = value.replace(" ", ",")
    return newStr
}