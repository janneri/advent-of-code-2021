// See puzzle in https://adventofcode.com/2021/day/7
package com.janneri.aoc

import com.janneri.aoc.util.parseInts
import com.janneri.aoc.util.sumN
import kotlin.math.abs

class Day07(inputLines: List<String>) {
    private val positions = parseInts(inputLines.first()).sorted()

    private fun totalFuel(cost: (Int, Int) -> Int, toCol: Int) =
        positions.fold(0) {acc, fromCol ->
            acc + cost(fromCol, toCol)
        }

    private fun solve(costFunction: (Int, Int) -> Int) = (0..positions.last())
        .map { pos -> pos to totalFuel(costFunction, pos) }
        .minBy { it.second }
        .second

    fun part1(): Int = solve { fromCol: Int, targetCol: Int,  -> abs(targetCol - fromCol) }
    fun part2(): Int = solve { fromCol: Int, targetCol: Int -> abs(targetCol - fromCol).sumN() }
}