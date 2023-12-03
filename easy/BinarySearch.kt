package easy

import kotlin.math.ceil

class BinarySearch {

    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1 // Adjusted to avoid ArrayIndexOutOfBoundsException
        while (left <= right) {
            val mid = left + ((right - left) shr 1)
            val numAtMid = nums[mid]
            if (numAtMid == target) return mid
            else if (numAtMid < target) left = mid + 1
            else right = mid - 1
        }
        return -1
    }
}