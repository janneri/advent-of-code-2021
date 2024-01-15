import com.janneri.aoc.Day01
import com.janneri.aoc.util.readInput
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day01Test {
    @Test
    fun part1_test() {
        val result = Day01(readInput("Day01_test")).part1()
        assertEquals(7, result)
    }

    @Test
    fun part1_real() {
        val result = Day01(readInput("Day01")).part1()
        assertEquals(1139, result)
    }
    
    @Test
    fun part2_test() {
        val result = Day01(readInput("Day01_test")).part2()
        assertEquals(5, result)
    }

    @Test
    fun part2_real() {
        val result = Day01(readInput("Day01")).part2()
        assertEquals(1103, result)
    }
}