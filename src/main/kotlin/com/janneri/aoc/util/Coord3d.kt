package com.janneri.aoc.util

data class Coord3d(val x: Long, val y: Long, val z: Long) {
    fun move(coord3d: Coord3d): Coord3d =
        Coord3d(x + coord3d.x, y + coord3d.y, z + coord3d.z)

    fun minus(coord3d: Coord3d): Coord3d =
        Coord3d(x - coord3d.x, y - coord3d.y, z - coord3d.z)

    companion object {
        val UP: Coord3d = Coord3d(0, 0, 1)
        val DOWN: Coord3d = Coord3d(0, 0, -1)
    }

    override fun toString() = "($x, $y, $z)"
}