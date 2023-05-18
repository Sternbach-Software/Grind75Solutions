package easy

class ValidAnagram {

    companion object {
        /**
         * # Intuition
        Assuming strings are equal length, if you can successfully remove a single instance of a letter `c` from `t` every time you see it in `s` (it is contained in `t`), then the strings have the same letters appearing the same number of times. If the remove was unsuccessful, that means the letter `c` is either not in `t` or not in `t` the number of times it is in `s`.
        # Approach
        If strings are unequal length, they are not anagrams.
        If a character `c` in `s` is also in `t`, remove it from `t`. `t` will get smaller as the loop goes on.
        # Complexity
        - Time complexity:
        Best case: $$O(n)$$ (one iteration).
        Worst case: $$O(n * n?)$$ - slightly better than $$O(n^3)$$ (n? is the Termial function of n, otherwise known as the [nth triangular number](https://en.wikipedia.org/wiki/Triangular_number))
        In the best case, `s` and `t` are identical, so `remove` performs one iteration before removing `c` from `t`. This means that only one operation is performed for every char in `s`. This does not include the iteration neccesary on the JVM for copying the string into a mutable list (because JVM strings are immutable).
        In the worst case, `t` is the reverse of `s`. That means that remove has to iterate over the entire `t` before it can remove `c`. This means that if length ($$n$$) is 5, the first iteration will be 5 operations, the next will be 4, the next 3, etc. This is known by Donald Knuth as the Termial function (The Art of Computer Programming, Vol. 1 page 48) and denoted as $$n?$$ because it is the summation analog to $$n!$$ which uses multiplication.
        Interestingly enough, this only beat 5% of Kotlin solutions.
        - Space complexity: $$O(1)$$ (assuming string mutability)
        Because strings are not mutable in JVM languages, a mutable array needs to be created with the same chars as `t`, so in the below solution, because of implementation details, the space complexity is technically $$O(n)$$, but in languages with string mutability, no new array would need to be created, so the space complexity would be $$O(1)$$.
         * */
        fun isAnagram(s: String, t: String): Boolean {
            if(s.length != t.length) return false
            val charArrayOfT = t.toMutableList()
            for(char in s) {
                if (!charArrayOfT.remove(char)) return false
            }
            return true
        }
        @JvmStatic
        fun main(args: Array<String>) {
            println(isAnagram("cat", "tac"))
            println(isAnagram("anagram", "anagram".reversed()))
        }
    }
}