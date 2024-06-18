package com.example.myapp

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// Define a suspend function that delays for a specified time
suspend fun doSomeWork() {
    println("Starting work...")
    delay(1000) // Simulate some asynchronous work (e.g., network call, file I/O)
    println("Work complete!")
}

fun main() = runBlocking {
    println("Before calling suspend function")

    // Call the suspend function within a coroutine scope
    doSomeWork()

    println("After calling suspend function")
}
