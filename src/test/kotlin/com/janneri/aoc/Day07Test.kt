import com.janneri.aoc.Day07
import com.janneri.aoc.util.readInput
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day07Test {
    @Test
    fun part1_test() {
        val result = Day07(readInput("Day07_test")).part1()
        assertEquals(37, result)
    }

    @Test
    fun part1_real() {
        val result = Day07(readInput("Day07")).part1()
        assertEquals(341558, result)
    }
    
    @Test
    fun part2_test() {
        val result = Day07(readInput("Day07_test")).part2()
        assertEquals(168, result)
    }

    @Test
    fun part2_real() {
        val result = Day07(readInput("Day07")).part2()
        assertEquals(93214037, result)
    }
}