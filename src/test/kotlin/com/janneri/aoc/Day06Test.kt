import com.janneri.aoc.Day06
import com.janneri.aoc.util.readInput
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day06Test {
    @Test
    fun part1_test() {
        val result = Day06(readInput("Day06_test")).part1(80)
        assertEquals(5934, result)
    }

    @Test
    fun part1_real() {
        val result = Day06(readInput("Day06")).part1(80)
        assertEquals(380243, result)
    }
    
    @Test
    fun part2_test() {
        val result = Day06(readInput("Day06_test")).part2(256)
        assertEquals(26984457539, result)
    }

    @Test
    fun part2_real() {
        val result = Day06(readInput("Day06")).part2(256)
        assertEquals(1708791884591, result)
    }
}