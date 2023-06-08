package easy

import kotlin.math.ceil

class BinarySearch {
    //doesn't work for all test cases
    fun search(nums: IntArray, target: Int): Int {
        nums.binarySearch(target)
        val lastIndex = nums.lastIndex //e.g. nums is 1,2, 3 ,4,5, 6 ,7,8, 9 ,10,11
        var index = getMiddle(0, lastIndex)
        log("Last index: $lastIndex, middle=$index, target=$target, index to value: ${nums.withIndex().joinToString("\n", prefix = "\n") { "Index: ${it.index}, value: ${it.value}" }}")
        var prevIndex = 0
        while(true) {
            log("Beggining of loop. index=$index, prevIndex=$prevIndex")
            val found = nums[index]
            log("Found: $found")
            if(found == target) return index
            else if(found < target) {
                log("$found is smaller than $target. index=$index, prevIndex=$prevIndex")
                prevIndex = index
                val middle = getMiddle(index, lastIndex)
                log("Middle: $middle")
                index = middle
                if(middle == lastIndex) {
                    return if (nums[middle] == target) middle else -1
                }
            } else {
                log("$found is greater than $target. index=$index, prevIndex=$prevIndex")
                val middle = getMiddle(prevIndex, index)
                if(middle == index) return -1
                log("Checking middle: $middle")
                index = middle
            }
        }
    }
    companion object {
        private fun getMiddle(start: Int, length: Int): Int {
            log("Get middle between $start and $length")
            val halfOfNext = (length - start) / 2.0
            log("Half of next is $halfOfNext")
            val round = ceil(halfOfNext/*half of the next half*/)
            log("Round is $round")
            val middle = start + round.toInt()
            log("Returning $middle")
            return middle
        }
        fun log(log: String) {
            if (true) println(log)
        }
    }
}