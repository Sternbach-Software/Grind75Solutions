package medium

class MinimumRemoveToValidParantheses {
    fun minRemoveToMakeValid(s: String): String {
        val indicesToRemove = ArrayDeque<Pair<Char, Int>>()

        for((index, char) in s.withIndex())
            if(char == ')' && indicesToRemove.lastOrNull()?.first == '(') indicesToRemove.removeLastOrNull()
            else if(char == '(' || char == ')') indicesToRemove.addLast(char to index)

        val string = StringBuilder(s)
        for(index in indicesToRemove.reversed()) string.deleteCharAt(index.second)
        return string.toString()
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MinimumRemoveToValidParantheses().minRemoveToMakeValid("lee(t(c)o)de)") == "lee(t(c)o)de")
            println(MinimumRemoveToValidParantheses().minRemoveToMakeValid("a)b(c)d") == "ab(c)d")
            println(MinimumRemoveToValidParantheses().minRemoveToMakeValid("))((") == "")
        }
    }
}