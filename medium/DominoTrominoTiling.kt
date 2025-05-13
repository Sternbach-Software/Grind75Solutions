package medium

class DominoTrominoTiling {
    fun numTilings(n: Int): Long {
        //For a 2×0(n=0) board, there are 0 ways to tile it.
        //For a 2×1 board, there is 1 way to tile it - a single domino.
        //For a 2×2 board, there's 2 ways: two vertical or two horizontal.
        //For a 2×3 board, there's 5 ways: Two trominos, two trominos flipped, three vertical dominos, one vertical domino and two horizontal dominoes, and two horizontal dominoes and one vertical.
        //For a 2×4 board, there's 11 ways: 5 + one domino at the begging, 5 + one domino at the end (10), and then 4 horizontal dominoes
        //besides for the base cases where certain possibilities aren't possible, the pattern/recurrence is f(n) = 2 * f(n-1) + f(n-3)

        //account for the base case:
        if(n <= 2) return n.toLong()

        var fOfNMinusOne = 5L
        var fOfNMinusTwo = 2L
        var fOfNMinusThree = 1L


        for(k in 3 until n) {
            val temp = fOfNMinusTwo
            fOfNMinusTwo = fOfNMinusOne
            fOfNMinusOne = 2 * fOfNMinusOne + fOfNMinusThree
            fOfNMinusThree = temp
        }
        return fOfNMinusOne
    }
    fun numTilingsJava(n: Int): Int {
        val MOD = 1000000007
        if (n <= 2) {
            return n
        }
        var fMinusOne = 5L
        var fMinusTwo: Long = 2
        var fMinusThree: Long = 1
        for (k in 3 until n) {
            val tmp = fMinusTwo
            fMinusTwo = fMinusOne
            fMinusOne = (2 * fMinusOne + fMinusThree) % MOD
            fMinusThree = tmp
        }
        return (fMinusOne % MOD).toInt()
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("${DominoTrominoTiling().numTilings(3)}, ${DominoTrominoTiling().numTilingsJava(3)}")
            println("${DominoTrominoTiling().numTilings(4)}, ${DominoTrominoTiling().numTilingsJava(4)}")
            println("${DominoTrominoTiling().numTilings(5)}, ${DominoTrominoTiling().numTilingsJava(5)}")
            println("${DominoTrominoTiling().numTilings(6)}, ${DominoTrominoTiling().numTilingsJava(6)}")
            println("${DominoTrominoTiling().numTilings(7)}, ${DominoTrominoTiling().numTilingsJava(7)}")
        }
    }
}