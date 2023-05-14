package easy

/*121. */
class BestTimeToBuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {
        var bestProfit = 0
        var lowestPrice = Int.MAX_VALUE
        for(price in prices) {
            if(price < lowestPrice) {
                lowestPrice = price
            } else {
                val diff = price - lowestPrice
                if(diff > bestProfit) bestProfit = diff
            }
        }
        return bestProfit
    }
}