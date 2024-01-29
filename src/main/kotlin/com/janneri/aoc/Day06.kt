// See puzzle in https://adventofcode.com/2021/day/6
package com.janneri.aoc

import com.janneri.aoc.util.parseInts

class Day06(inputLines: List<String>) {
    private val inputFishes: Map<Int, Long> = parseInts(inputLines.first())
        .groupingBy { it }
        .eachCount()
        .mapValues { it.value.toLong() }

    private fun getNewFish(fish: Map<Int, Long>): Map<Int, Long> {
        return mapOf(
            0 to (fish[1] ?: 0),
            1 to (fish[2] ?: 0),
            2 to (fish[3] ?: 0),
            3 to (fish[4] ?: 0),
            4 to (fish[5] ?: 0),
            5 to (fish[6] ?: 0),
            6 to ((fish[0] ?: 0) + (fish[7] ?: 0)),
            7 to (fish[8] ?: 0),
            8 to (fish[0] ?: 0),
        )
    }

    private fun simulate(fish: Map<Int, Long>, days: Int): Long {
        var newFish = fish
        repeat(days) {
            newFish = getNewFish(newFish)
        }
        return newFish.values.sum()
    }

    fun part1(days: Int): Long = simulate(inputFishes, days)

    fun part2(days: Int): Long = simulate(inputFishes, days)
}