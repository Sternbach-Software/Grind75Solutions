package easy

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BinarySearchTest {

    val finder = BinarySearch()

    @Test
    fun testOddArray() {
        assertSearchFindsAll(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11))
    }

    @Test
    fun testEvenArray() {
        assertSearchFindsAll(intArrayOf(1, 2, 3, 4))
    }
    @Test
    fun testDoesntFindInEvenArray() {
        //out of array bounds
        assertSearchNotFound(intArrayOf(1, 2, 3, 4), 0)
        assertSearchNotFound(intArrayOf(1, 2, 3, 4), 5)

        //within array bounds
        assertSearchNotFound(intArrayOf(1, 2, 3, 6), 5)
        assertSearchNotFound(intArrayOf(1, 2, 5, 6), 3)
        assertSearchNotFound(intArrayOf(1, 4, 5, 6), 2)
    }
    @Test
    fun testDoesntFindInOddArray() {
        //out of array bounds
        assertSearchNotFound(intArrayOf(1, 2, 3, 4, 5), 0)
        assertSearchNotFound(intArrayOf(1, 2, 3, 4, 5), 6)

        //within array bounds
        assertSearchNotFound(intArrayOf(1, 2, 3, 4, 6), 5)
        assertSearchNotFound(intArrayOf(1, 2, 4, 5, 6), 3)
        assertSearchNotFound(intArrayOf(1, 3, 4, 5, 6), 2)
    }

    @Test
    fun testTrickyArray() {
        assertSearchFindsAll(intArrayOf(2, 5))
    }
    fun assertSearchFound(array: IntArray, target: Int) {
        assertEquals(target, array[finder.search(array, target)])
    }
    fun assertSearchNotFound(array: IntArray, target: Int) {
        assertEquals(-1, array.getOrElse(finder.search(array, target)) { -1 })
    }
    private fun assertSearchFindsAll(array: IntArray) {
        for (num in array) assertSearchFound(array, num)
    }
}