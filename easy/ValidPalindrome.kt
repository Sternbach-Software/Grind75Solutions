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
}