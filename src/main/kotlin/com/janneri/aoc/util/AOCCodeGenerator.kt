package com.janneri.aoc.util

import com.janneri.aoc.util.AOCClient.downloadInput
import java.nio.file.Files
import java.nio.file.Path


/**
 * A helper to create
 * 1) the source file
 * 2) the test source file and
 * 3) input file, which is downloaded from AOC site
 *
 * for a year-day given as a parameter
 */
object AOCCodeGenerator {
    private fun createDay(year: Int, dayNum: Int) {
        val dir = Path.of("src", "main", "kotlin", "com", "janneri", "aoc")
        val dayPrefix = String.format("Day%02d", dayNum)
        val mainFile = dir.resolve("${dayPrefix}.kt").toFile()

        Files.writeString(mainFile.toPath(), """
        // See puzzle in https://adventofcode.com/$year/day/$dayNum
        package com.janneri.aoc
        
        class $dayPrefix(val inputLines: List<String>) {
            fun part1(): Int {
                return 0
            }
            
            fun part2(): Int {
                return 0
            }
        }
        """.trimIndent())

        val testSrcDir = Path.of("src", "test", "kotlin", "com", "janneri", "aoc")
        val mainTestFile = testSrcDir.resolve("${dayPrefix}Test.kt").toFile()
        Files.writeString(mainTestFile.toPath(), """
            import com.janneri.aoc.${dayPrefix}
            import com.janneri.aoc.util.readInput
            import org.junit.jupiter.api.Assertions.assertEquals
            import org.junit.jupiter.api.Test
            
            class ${dayPrefix}Test {
                @Test
                fun part1_test() {
                    val result = ${dayPrefix}(readInput("${dayPrefix}_test")).part1()
                    assertEquals(2, result)
                }

                @Test
                fun part1_real() {
                    val result = ${dayPrefix}(readInput("$dayPrefix")).part1()
                    assertEquals(2, result)
                }
                
                @Test
                fun part2_test() {
                    val result = ${dayPrefix}(readInput("${dayPrefix}_test")).part2()
                    assertEquals(2, result)
                }

                @Test
                fun part2_real() {
                    val result = ${dayPrefix}(readInput("$dayPrefix")).part2()
                    assertEquals(2, result)
                }
            }
        """.trimIndent())

        val testResourcesDir = Path.of("src", "test", "resources")
        testResourcesDir.resolve("${dayPrefix}_test.txt").toFile().createNewFile()
        val inputTxtFile = testResourcesDir.resolve("$dayPrefix.txt").toFile()
        Files.writeString(inputTxtFile.toPath(), downloadInput(year, dayNum))
    }

    @JvmStatic
    fun main(args: Array<String>) {
        createDay(2021, 7)
    }
}