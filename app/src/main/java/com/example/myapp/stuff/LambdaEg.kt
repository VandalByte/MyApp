package com.example.myapp.stuff

fun main() {
    val multiply: (Int, Int) -> Int = { a, b -> a * b }
    println(multiply(3, 6))
}

fun nullableFunction(): String? {
    // returning null
    return null
}
