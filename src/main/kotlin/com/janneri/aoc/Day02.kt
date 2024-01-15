// See puzzle in https://adventofcode.com/2021/day/2
package com.janneri.aoc

class Day02(private val inputLines: List<String>) {
    fun part1(): Int {
        val (finalPos, finalDept) = inputLines.fold(0 to 0) {acc, cmd ->
            val (pos, dept) = acc
            val amount = cmd.substringAfter(' ').toInt()
            when {
                cmd.startsWith("forward") -> pos + amount to dept
                cmd.startsWith("down") -> pos to dept + amount
                cmd.startsWith("up") -> pos to dept - amount
                else -> error("zzz")
            }
        }
        return finalPos * finalDept
    }
    
    fun part2(): Int {
        val (finalPos, finalDept) = inputLines.fold(Triple(0, 0, 0)) {acc, cmd ->
            val (pos, dept, aim) = acc
            val amount = cmd.substringAfter(' ').toInt()
            when {
                cmd.startsWith("forward") -> Triple(pos + amount, dept + aim * amount, aim)
                cmd.startsWith("down") -> Triple(pos, dept, aim + amount)
                cmd.startsWith("up") -> Triple(pos, dept, aim - amount)
                else -> error("zzz")
            }
        }
        return finalPos * finalDept
    }
}