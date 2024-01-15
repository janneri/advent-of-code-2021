package com.janneri.aoc.util

fun IntRange.intersectRange(other: IntRange) = (maxOf(first, other.first)..minOf(last, other.last))

fun LongRange.intersectRange(other: LongRange) = (maxOf(first, other.first)..minOf(last, other.last))

fun LongRange.overLaps(other: LongRange) = when {
    this.first <= other.first -> this.last >= other.first
    else -> this.first <= other.last
}