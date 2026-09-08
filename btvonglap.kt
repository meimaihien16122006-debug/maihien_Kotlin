package com.example.btvonglapkotlin

fun main() {

    // Bai 1
    println("Bai 1:")
    for (i in 1..10) {
        print("$i ")
    }

    // Bai 2
    println("\n\nBai 2:")
    var sum = 0

    for (i in 1..100) {
        sum += i
    }

    println("Tong = $sum")

    // Bai 3
    println("\nBai 3:")
    for (i in 1..20) {
        if (i % 2 == 0) {
            print("$i ")
        }
    }
}