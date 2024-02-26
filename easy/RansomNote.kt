package easy

class RansomNote {

    fun <T> Iterable<T>.toFrequencyMap(): Map<T, Int> {
        val frequencies: MutableMap<T, Int> = mutableMapOf()
        this.forEach { frequencies[it] = frequencies.getOrDefault(it, 0) + 1 }
        return frequencies
    }
    fun String.toFrequencyMap(): MutableMap<Char, Int> {
        val frequencies: MutableMap<Char, Int> = mutableMapOf()
        this.forEach { frequencies[it] = frequencies.getOrDefault(it, 0) + 1 }
        return frequencies
    }
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val freqSet = magazine.toFrequencyMap()
        return ransomNote.all {
            val value = freqSet[it]
            if (value != null) freqSet[it] = value - 1
            value != null && value >= 1
        }
    }
}