import com.janneri.aoc.Day05
import com.janneri.aoc.util.readInput
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day05Test {
    @Test
    fun part1_test() {
        val result = Day05(readInput("Day05_test")).part1()
        assertEquals(5, result)
    }

    @Test
    fun part1_real() {
        val result = Day05(readInput("Day05")).part1()
        assertEquals(7085, result)
    }
    
    @Test
    fun part2_test() {
        val result = Day05(readInput("Day05_test")).part2()
        assertEquals(12, result)
    }

    @Test
    fun part2_real() {
        val result = Day05(readInput("Day05")).part2()
        assertEquals(20271, result)
    }
}