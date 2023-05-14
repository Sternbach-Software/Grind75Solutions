package easy

import org.junit.jupiter.api.Assertions.*

internal class BestTimeToBuyAndSellStockTest {

    @org.junit.jupiter.api.Test
    fun maxProfit() {
        val bestTimeToBuyAndSellStock = BestTimeToBuyAndSellStock()
        assertEquals(2, bestTimeToBuyAndSellStock.maxProfit(intArrayOf(1,2,3)))
        assertEquals(0, bestTimeToBuyAndSellStock.maxProfit(intArrayOf(3,2,1)))
    }
}