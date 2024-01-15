import com.janneri.aoc.Day02
import com.janneri.aoc.util.readInput
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day02Test {
    @Test
    fun part1_test() {
        val result = Day02(readInput("Day02_test")).part1()
        assertEquals(150, result)
    }

    @Test
    fun part1_real() {
        val result = Day02(readInput("Day02")).part1()
        assertEquals(1727835, result)
    }
    
    @Test
    fun part2_test() {
        val result = Day02(readInput("Day02_test")).part2()
        assertEquals(900, result)
    }

    @Test
    fun part2_real() {
        val result = Day02(readInput("Day02")).part2()
        assertEquals(1544000595, result)
    }
}