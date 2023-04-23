class SolutionValidParentheses {

    /**

    if its a closing one and the last one wasnt its opening one, then invalid. if last was opening, remove last. if opening, add. if none removed, false. if chars remaining, false.

    */

    fun isValid(s: String): Boolean {

        val stack = StringBuilder(s.length) // can also use ArrayDeque

        var atLeastOnePairFound = false

        for(char in s) {

           if(char == '(' || char == '{' || char == '[') stack.append(char) 

            else {

                val last = stack.lastOrNull()

            if(

                (char == ')' && last != '(') ||

                (char == '}' && last != '{') || (char == ']' && last != '[')     

            ) return false else {

                //stack.removeLastOrNull()

                if (stack.isEmpty()) null else stack.deleteCharAt(stack.lastIndex)

                atLeastOnePairFound = true

                }

           }

            }

        return atLeastOnePairFound && stack.isEmpty()

    }

    //public fun <T> MutableList<T>.removeLastOrNull(): T? = if (isEmpty()) null else removeAt(lastIndex)

}
