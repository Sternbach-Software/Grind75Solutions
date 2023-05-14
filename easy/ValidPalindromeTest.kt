package easy

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ValidPalindromeTest {

    @Test
    fun isPalindrome() {
        val valid = ValidPalindrome()
        assertTrue(valid.isPalindrome("ab_a"))
        assertTrue(valid.isPalindrome("A man, a plan, a canal: Panama"))
        assertFalse(valid.isPalindrome("race a car"))
        assertTrue(valid.isPalindrome(" "))
        assertFalse(valid.isPalindrome("0P"))
    }
}