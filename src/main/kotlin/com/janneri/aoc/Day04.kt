// See puzzle in https://adventofcode.com/2021/day/4
package com.janneri.aoc

import com.janneri.aoc.util.parseInts
import com.janneri.aoc.util.parseParagraphs

class Day04(inputLines: List<String>) {
    private val numbers = parseInts(inputLines.first())

    private val boards = inputLines.drop(2).parseParagraphs()
        .map { Board(it) }

    data class Board(val boardLines: List<String>) {
        private val rows = boardLines.map { parseInts(it) }.toSet()

        private fun cols(): List<Set<Int>> =
            rows.indices.map { col ->
                rows.map {it[col] }.toSet()
            }

        private fun isWin(nums: Set<Int>) =
            rows.any { row -> row.all { nums.contains(it) } } ||
            cols().any { col -> col.all { nums.contains(it) } }

        private val boardNums = rows.flatten().toSet()

        private fun getUnmarked(drawnNums: Set<Int>) = boardNums.filter { it !in drawnNums }

        private lateinit var winningNums: Set<Int>

        fun finalScore() = getUnmarked(winningNums).sum() * winningNums.last()

        fun winningRound() = winningNums.size

        fun setWinningNums(allDrawnNums: List<Int>): Board {
            (5 .. allDrawnNums.lastIndex).forEach { numberIdx ->
                val drawnNums = allDrawnNums.subList(0, numberIdx).toSet()
                if (isWin(drawnNums)) {
                    winningNums = drawnNums
                    return this
                }
            }
            error("Winning row not found")
        }
    }

    fun part1(): Int =
        boards.map { it.setWinningNums(numbers) }
            .minByOrNull { it.winningRound() }!!
            .finalScore()
    
    fun part2(): Int =
        boards.map { it.setWinningNums(numbers) }
            .maxByOrNull { it.winningRound() }!!
            .finalScore()
}