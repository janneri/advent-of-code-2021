import com.janneri.aoc.Day04
import com.janneri.aoc.util.readInput
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day04Test {
    @Test
    fun part1_test() {
        val result = Day04(readInput("Day04_test")).part1()
        assertEquals(4512, result)
    }

    @Test
    fun part1_real() {
        val result = Day04(readInput("Day04")).part1()
        assertEquals(89001, result)
    }
    
    @Test
    fun part2_test() {
        val result = Day04(readInput("Day04_test")).part2()
        assertEquals(1924, result)
    }

    @Test
    fun part2_real() {
        val result = Day04(readInput("Day04")).part2()
        assertEquals(7296, result)
    }
}