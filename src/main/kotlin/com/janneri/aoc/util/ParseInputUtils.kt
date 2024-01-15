package com.janneri.aoc.util

import java.nio.file.Path

fun readInput(name: String) =
    Path.of("src", "test", "resources", "$name.txt")
        .toFile()
        .readLines()


fun List<String>.parseParagraphs(): List<List<String>> =
    this.joinToString("\n")
        .split("\n\n")
        .map { it.split("\n") }


private val numPattern = """-?[0-9]+""".toRegex()
fun parseInts(str: String): List<Int> =
    numPattern.findAll(str).map { it.value.toInt() }.toList()

fun parseUlongs(str: String): List<ULong> =
    numPattern.findAll(str).map { it.value.toULong() }.toList()

fun parseLongs(str: String): List<Long> =
    numPattern.findAll(str).map { it.value.toLong() }.toList()
