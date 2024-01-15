import com.janneri.aoc.Day03
import com.janneri.aoc.util.readInput
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day03Test {
    @Test
    fun part1_test() {
        val result = Day03(readInput("Day03_test")).part1()
        assertEquals(198, result)
    }

    @Test
    fun part1_real() {
        val result = Day03(readInput("Day03")).part1()
        assertEquals(1025636, result)
    }
    
    @Test
    fun part2_test() {
        val result = Day03(readInput("Day03_test")).part2()
        assertEquals(230, result)
    }

    @Test
    fun part2_real() {
        val result = Day03(readInput("Day03")).part2()
        assertEquals(793873, result)
    }
}