package com.janneri.aoc.util

import java.io.File
import java.net.CookieHandler
import java.net.CookieManager
import java.net.HttpCookie
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.nio.file.Files
import java.nio.file.Path
import java.time.Duration


object AdventOfCodeTemplateUtil {
    private const val YEAR = 2021

    private fun createDay(dayNum: Int) {
        val dir = Path.of("src", "main", "kotlin", "com", "janneri", "aoc")
        val dayPrefix = String.format("Day%02d", dayNum)
        val mainFile = dir.resolve("${dayPrefix}.kt").toFile()

        Files.writeString(mainFile.toPath(), """
        // See puzzle in https://adventofcode.com/$YEAR/day/$dayNum
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
        Files.writeString(inputTxtFile.toPath(), downloadInput(dayNum))
    }

    fun printlnIndented(str: String, level: Int) {
        println("${"  ".repeat(level)} $str")
    }

    private fun getHttpClient(): HttpClient {
        CookieHandler.setDefault(CookieManager())
        val cookieManager = CookieHandler.getDefault() as CookieManager
        val sessionCookieValue = File(System.getProperty("user.home"),".adventofcode.session").readText().trim()
        val aocSessionCookie = HttpCookie("session", sessionCookieValue).apply {
            path = "/"
            version = 0
        }
        cookieManager.cookieStore.add(URI("https://adventofcode.com"), aocSessionCookie)
        return HttpClient.newBuilder()
            .cookieHandler(cookieManager)
            .connectTimeout(Duration.ofSeconds(10))
            .build()
    }

    private fun downloadInput(dayNum: Int): String {
        val client = getHttpClient()
        val req = HttpRequest.newBuilder()
            .uri(URI.create("https://adventofcode.com/$YEAR/day/$dayNum/input"))
            .GET().build()

        return client.send(req, HttpResponse.BodyHandlers.ofString()).body().trim()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        createDay(4)
    }
}