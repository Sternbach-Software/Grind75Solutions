package easy

import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

class ClimbingStairs {
    //better than 94% in runtime
    fun climbStairs(n: Int): Int {
        //calculate nth fibbonaci using closed-form expression/binet's formula
        val asDouble = n.toDouble()
        val sqrt5 = sqrt(5.0)
        val phi = (1.0 + sqrt5) / 2.0
        val psi = (1.0 - sqrt5) / 2.0
        return ((phi.pow(asDouble + 1.0) - psi.pow(asDouble + 1.0)) / sqrt5).toInt()
    }
}