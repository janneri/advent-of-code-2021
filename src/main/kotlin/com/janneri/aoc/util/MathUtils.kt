package com.janneri.aoc.util

import kotlin.math.abs

fun sumN(n: Long): Long = n * (n + 1) / 2
fun Int.sumN() = sumN(this.toLong()).toInt()

fun findLCMOfListOfNumbers(numbers: List<Long>): Long {
    var result = numbers[0]
    for (i in 1 until numbers.size) {
        result = findLCM(result, numbers[i])
    }
    return result
}

fun findLCM(a: Long, b: Long): Long {
    val larger = if (a > b) a else b
    val maxLcm = a * b
    var lcm = larger
    while (lcm <= maxLcm) {
        if (lcm % a == 0L && lcm % b == 0L) {
            return lcm
        }
        lcm += larger
    }
    return maxLcm
}

fun Double.almostEqual(other: Double) = abs(this - other) < 0.0001
