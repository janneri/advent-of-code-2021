// See puzzle in https://adventofcode.com/2021/day/5
package com.janneri.aoc

import com.janneri.aoc.util.Coord
import com.janneri.aoc.util.countDuplicates

class Day05(inputLines: List<String>) {
    private val lines = inputLines.map { line ->
        val (p1, p2) = line.split(" -> ")
        Line(Coord.from(p1), Coord.from(p2))
    }

    data class Line(val start: Coord, val end: Coord) {
        fun isHorizontal() = start.y == end.y
        fun isVertical() = start.x == end.x

        fun points(): Set<Coord> {
            val direction = start.iDirectionTo(end)
            val coords = mutableSetOf(start)
            do {
                coords += coords.last().move(direction)
            } while (coords.last() != end)

            return coords
        }
    }

    fun part1() = lines
            .filter { it.isVertical() || it.isHorizontal() }
            .flatMap { it.points() }
            .countDuplicates()

    fun part2(): Int = lines
        .flatMap { it.points() }
        .countDuplicates()
}