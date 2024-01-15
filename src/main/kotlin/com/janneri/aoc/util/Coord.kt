package com.janneri.aoc.util

import kotlin.math.abs

data class Coord(val x: Long, val y: Long): Comparable<Coord> {
    fun neighbors(): List<Coord> = Direction.entries.map { this.move(it) }
    fun neighborsIncludingDiagonal(): Set<Coord> = IDirection.entries.map { this.move(it) }.toSet()

    fun distanceTo(c: Coord): Long = abs(this.x - c.x) + abs(this.y - c.y)

    fun directionTo(c: Coord): Direction = when {
        x < c.x -> Direction.RIGHT
        x > c.x -> Direction.LEFT
        y < c.y -> Direction.DOWN
        else -> Direction.UP
    }

    fun iDirectionTo(c: Coord): IDirection = when {
        x == c.x && y > c.y -> IDirection.NORTH
        x < c.x && y > c.y -> IDirection.NORTHEAST
        x < c.x && y == c.y -> IDirection.EAST
        x < c.x && y < c.y -> IDirection.SOUTHEAST
        x == c.x && y < c.y -> IDirection.SOUTH
        x > c.x && y < c.y -> IDirection.SOUTHWEST
        x > c.x && y == c.y -> IDirection.WEST
        x > c.x && y > c.y -> IDirection.NORTHWEST
        else -> error("unknown direction")
    }

    fun move(direction: IDirection, amount: Long = 1) =
        Coord(x + amount * direction.dx, y + amount * direction.dy)

    fun move(direction: Direction, amount: Long = 1) =
        Coord(x + amount * direction.dx, y + amount * direction.dy)

    fun moveCollect(direction: Direction, amount: Long = 1): List<Coord> =
        (0 .. amount).map { steps ->
            this.move(direction, steps)
        }

    fun moveUntil(direction: Direction, predicate: (Coord) -> Boolean): Coord {
        val maxMoves = 10000
        var newCoord = this

        for (n in 0 until maxMoves) {
            val potentialNewCoord = newCoord.move(direction)
            if (predicate(potentialNewCoord)) {
                return newCoord
            }
            newCoord = potentialNewCoord
        }

        throw IllegalArgumentException("Too many (> $maxMoves) moves!")
    }

    override fun toString() = "($x, $y)"

    override fun compareTo(other: Coord) = compareValuesBy(this, other,
        { it.y },
        { it.x }
    )

    companion object {
        fun from(str: String): Coord {
            val (xStr, yStr) = str.trim().split(",")
            return Coord(xStr.toLong(), yStr.toLong())
        }
    }
}