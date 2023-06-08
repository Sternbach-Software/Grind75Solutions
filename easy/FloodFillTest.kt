package easy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class FloodFillTest {
    val test = FloodFill()

    @Test
    fun assertRegularCase() {
        assertArrayEquals(
            arrayOf(
                intArrayOf(2,2,2),
                intArrayOf(2,2,0),
                intArrayOf(2,0,1),
            ),
            test.floodFill(
                arrayOf(
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 1, 0),
                    intArrayOf(1, 0, 1)
                ),
                1,
                1,
                2
            )
        )
    }

    @Test
    fun assertZeroes() {
        val array = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )
        assertArrayEquals(
            array,
            test.floodFill(
                array,
                0,
                0,
                0
            )
        )
    }
}