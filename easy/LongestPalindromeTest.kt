package easy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LongestPalindromeTest {
    @Test
    fun test() {
//        Assertions.assertEquals(7, LongestPalindrome().longestPalindrome("abccccdd"))
        Assertions.assertEquals(3, LongestPalindrome().longestPalindrome("ccc"))
    }
}