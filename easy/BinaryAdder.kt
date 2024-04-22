package easy

class BinaryAdder {
    /***
     * not working
     * @param a string of binary digits
     * @param b string of binary digits
     * */
    fun add(a: String, b: String): String {
        var indexA = a.length - 1
        var indexB = b.length - 1
        val finalString = StringBuilder(maxOf(a.length, b.length))
        while (indexA != 0 || indexB != 0) {
            val digitA = a.getOrNull(indexA)
            val digitB = b.getOrNull(indexB)
            val aIsZero = digitA == '0'
            val aIsOne = digitA == '1'
            val bIsZero = digitB == '0'
            val bIsOne = digitB == '1'

            /*if (finalString.length >= maxOf(
                    indexA,
                    indexB
                )
            ) { //there was a carry because the number of digits is greater than the number of digits we already saw
                val needToCarryAgainIfOverflow = finalString[0] == '1'
                if (digitA == null && digitB != null && bIsOne && needToCarryAgainIfOverflow) { //if bIsZero, just leave the 1, no overflow
                    //set the head/most significant bit to 0 and carry the 1
                    finalString.deleteAt(0)
                    finalString.insert(0, '0')

                    finalString.insert(0, digitB*//*1*//*)
                }
                else if (digitA != null && digitB == null && aIsOne && needToCarryAgainIfOverflow) { //if aIsZero, just leave the 1, no overflow
                    //set the head/most significant bit to 0 and carry the 1
                    finalString.deleteAt(0)
                    finalString.insert(0, '0')

                    finalString.insert(0, digitA*//*1*//*)
                }
            } else {*/
                if (digitA == null && digitB != null) finalString.insert(0, digitB)
                else if (digitA != null && digitB == null) finalString.insert(0, digitA)
                else { //both non-null
                    if ((aIsZero && bIsOne) || (aIsOne && bIsZero)) finalString.insert(0, '1')
                    else if (aIsZero && bIsZero) finalString.insert(0, '0')
                    else { //both 1: carry
                        finalString.insert(0, '0')
                        finalString.insert(0,'1')
                    }
                }
//            }
            indexA--
            indexB--
        }
        return finalString.toString()
    }
}