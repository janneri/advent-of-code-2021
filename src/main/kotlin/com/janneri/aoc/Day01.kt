// See puzzle in https://adventofcode.com/2021/day/1
package com.janneri.aoc

class Day01(inputLines: List<String>) {
    private val depths = inputLines.map { it.toInt() }

    fun part1(): Int = depths.zipWithNext().fold(0) { acc, (d1, d2) ->
        if (d2 > d1) acc + 1 else acc
    }
    
    fun part2(): Int = depths.windowed(3).zipWithNext().fold(0) { acc, (l1, l2) ->
        if (l2.sum() > l1.sum()) acc + 1 else acc
    }
}