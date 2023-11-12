package easy

class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        val sanitized = Regex("[^a-zA-Z0-9]").replace(s.toLowerCase(), "")
        if(sanitized.isEmpty()) return true
        val chars = sanitized.toCharArray()
        var startIndex = 0
        var endIndex = chars.size - 1
        while(startIndex < endIndex) {
            val startChar = chars[startIndex]
            val endChar = chars[endIndex]
            println("Comparing $startChar and $endChar at $startIndex and $endIndex")
            if(startChar != endChar) return false
            startIndex++
            endIndex--
        }
        return true
    }
    fun isPalindromeRecursiveHelper(s: String): Boolean {
        val sanitized = Regex("[^a-zA-Z0-9]").replace(s.toLowerCase(), "")
        return isPalindromeRecursive(sanitized)
    }
    fun isPalindromeRecursive(s: String): Boolean {
        if(s.isEmpty()) return true
        val chars = s.toCharArray()
        val startChar = chars[0]
        val endChar = chars[chars.size - 1]
        if(startChar != endChar) return false
        return isPalindromeRecursive(s.substring(1, s.length - 1))
    }
}