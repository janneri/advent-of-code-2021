// See puzzle in https://adventofcode.com/2021/day/3
package com.janneri.aoc

import java.lang.Integer.parseInt

class Day03(private val inputLines: List<String>) {

    private fun String.binaryToDecimal() = parseInt(this, 2)

    fun part1(): Int {
        val (gammaStr, epsilonStr) = inputLines.first().indices.fold("" to "") {acc, idx ->
            val oneCount = inputLines.map { it[idx] }.count { it == '1' }
            val zeroCount = inputLines.count() - oneCount
            val (gammaBit, epsilonBit) = if (oneCount > zeroCount) "1" to "0" else "0" to "1"

            acc.first + gammaBit to acc.second + epsilonBit
        }
        return gammaStr.binaryToDecimal() * epsilonStr.binaryToDecimal()
    }
    
    fun part2(): Int {
        fun next(bitPos: Int, numbers: List<String>, bitFun: (Int, Int) -> Char): List<String> {
            if (numbers.size == 1) return numbers

            val oneCount = numbers.map { it[bitPos] }.count { it == '1' }
            val zeroCount = numbers.count() - oneCount

            val bit = bitFun(oneCount, zeroCount)

            val nextNumbers = numbers.filter { it[bitPos] == bit }
            return next(bitPos + 1, nextNumbers, bitFun)
        }

        val oxygenBit: (Int, Int) -> Char = { oneCount, zeroCount ->
            if (oneCount >= zeroCount) '1' else '0'
        }

        val co2Bit: (Int, Int) -> Char = { oneCount, zeroCount ->
            if (oneCount >= zeroCount) '0' else '1'
        }

        val oxygenRating = next(0, inputLines, oxygenBit).first().binaryToDecimal()
        val co2Rating = next(0, inputLines, co2Bit).first().binaryToDecimal()

        return oxygenRating * co2Rating
    }
}