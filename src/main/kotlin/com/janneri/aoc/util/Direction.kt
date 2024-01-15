package com.janneri.aoc.util

enum class Direction(val dx: Int, val dy: Int, val symbol: Char, val letter: Char) {
    UP(0, -1, '^', 'U') {
        override fun turnLeft() = LEFT
        override fun turnRight() = RIGHT
    },
    RIGHT(1, 0, '>', 'R') {
        override fun turnLeft() = UP
        override fun turnRight() = DOWN
    },
    DOWN(0, 1, 'v', 'D') {
        override fun turnLeft() = RIGHT
        override fun turnRight() = LEFT
    },
    LEFT(-1, 0, '<', 'L') {
        override fun turnLeft() = DOWN
        override fun turnRight() = UP
    };

    abstract fun turnLeft(): Direction
    abstract fun turnRight(): Direction
    fun turnOpposite() = turnLeft().turnLeft()

    companion object {
        fun ofLetter(letter: Char): Direction =
            entries.find { it.letter == letter } ?: error("invalid letter")

        fun ofSymbol(symbol: Char): Direction =
            entries.find { it.symbol == symbol } ?: error("invalid symbol")
    }
}