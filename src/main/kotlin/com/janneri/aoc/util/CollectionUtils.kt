package com.janneri.aoc.util

fun <T> List<T>.countDuplicates(): Int =
    this.groupBy { it }.count { it.value.size > 1 }


fun <T> List<T>.distinctPairs() =
    this.dropLast(1).flatMapIndexed { i, item1 ->
        this.drop(i + 1).map { item2 ->
            item1 to item2
        }
    }

infix fun <E> Set<E>.overlaps(otherSet: Set<E>): Boolean =
    this.any { otherSet.contains(it) }