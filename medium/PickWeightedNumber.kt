package medium

class PickWeightedNumber {
    val cumulation = mutableListOf<Int>()
    var total = 0

    constructor(w: IntArray) {
        var sum = 0
        for(num in w) {
            sum += num
            cumulation.add(sum)
        }
        total = sum
    }


    fun pickIndex(): Int {
        val target = total * kotlin.random.Random.nextDouble(1.0)

        var high = cumulation.size
        var low = 0
        while(low < high) {
            val mid = low + (high - low) / 2
            if(target > cumulation[mid]) low = mid + 1
            else high = mid
        }
        return low
    }

}