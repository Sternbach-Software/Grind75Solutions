package easy

class FirstBadVersion: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        var left = 1
        var right = n
        var earliestBadVersion = n
        while(left <= right) {
            val mid = left + ((right - left) shr 1)
            val midIsBad = isBadVersion(mid)
            if(midIsBad) {
                earliestBadVersion = mid
                right = mid - 1
            }
            else {
                left = mid + 1
            }
        }
        return earliestBadVersion
    }
}
/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */
abstract class VersionControl {
    fun isBadVersion(version: Int) : Boolean = true
    abstract fun firstBadVersion(n: Int): Int
}