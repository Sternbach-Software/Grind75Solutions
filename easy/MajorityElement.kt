package easy

import kotlin.random.Random

class MajorityElement {
    fun majorityElementBruteForce(nums: IntArray): Int {
        for(num in nums) {
            var count = 0
            for(j in nums) {
                if(j == num) count++
                if(count > nums.size / 2) return num
            }
        }
        return nums.firstOrNull() ?: -1 //can never happen
    }
    fun majorityElementFrequencyHashMap(nums: IntArray): Int {
        val freqMap = mutableMapOf<Int, Int>()
        for(num in nums) freqMap[num] = freqMap.getOrDefault(num, 0) + 1
        return freqMap.maxBy { it.value }.key
    }
    fun majorityElementSorting(nums: IntArray): Int {
        return nums.sorted()[nums.size / 2]
    }

    fun majorityElementBitManipulation(nums: IntArray): Int {
//        For each bit position in Int.SIZE_BITS, determine what the most common value for that bit position is in nums (viz. 0 or 1).
//        Building an int like this for all bit positions will yield the most common/majority int itself. Kind of like a convolution.
        return -1
    }

    fun majorityElementRandom(nums: IntArray): Int {
        while(true) {
            val rand = Random.nextInt(0, nums.size)
            val candidate = nums[rand]
            var count = 0
            val halfOfPopulation = nums.size / 2

            for(i in nums) {
                if(i == candidate && ++count > halfOfPopulation) return candidate
            }
        }
    }

    fun majorityElementBoyerMoore(nums: IntArray): Int {
        var count = 0
        var majorityNum = 0
        for(num in nums) {
            if(count == 0) majorityNum = num
            if(num == majorityNum) count++ else count--
        }
        return majorityNum
    }
}