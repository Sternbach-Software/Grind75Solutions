package easy

class StructyZipUnzip {
    fun decompress(compressed: String): String {
        val result = StringBuilder ()
        var index = 0
        while (index < compressed.length) {
            val char = compressed [index]
            val timesToRepeat = char.digitToIntOrNull()
            if (timesToRepeat != null) {
                val substring = StringBuilder ()
                while (true) {

                    val nextChar = compressed.getOrNull(++index) ?: break
                    if (nextChar.digitToIntOrNull() == null) substring.append(nextChar)
                    else break
                }
                repeat(timesToRepeat) { result.append(substring.toString()) }
            }
        }
        return result.toString()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(StructyZipUnzip().decompress("2abc4c1z"))
        }
    }
}