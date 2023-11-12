package easy

class LongestPalindrome {
    fun longestPalindrome(s: String): Int {
        var sum = 0
        var containsAtLeastOneOdd = false
        val charToCount = mutableMapOf<Char,Int>()
        for(char in s)
            if(charToCount.containsKey(char)) charToCount[char] = charToCount[char]!! + 1
            else charToCount[char] = 1
        for(count in charToCount.values)
            if(count % 2 == 0) sum += count
            else if(count % 2 == 1/* odd */) {
                containsAtLeastOneOdd = true
                sum += count - 1
            }
        return if(containsAtLeastOneOdd) sum + 1 else sum
    }
}