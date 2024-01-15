package com.janneri.aoc.util

fun drawGrid(coords: Set<Coord>, tileSymbolAt: (Coord) -> Char) {
    val yRange = coords.minBy { it.y }.y..coords.maxBy { it.y }.y
    val xRange = coords.minBy { it.x }.x..coords.maxBy { it.x }.x

    for (y in yRange) {
        for (x in xRange) {
            val coord = Coord(x, y)
            print(tileSymbolAt(coord))
        }
        println()
    }
}