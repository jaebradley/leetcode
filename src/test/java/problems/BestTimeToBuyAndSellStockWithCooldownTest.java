package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class BestTimeToBuyAndSellStockWithCooldownTest {
    @Test
    public void maxProfitIs3() {
        assertEquals(3, BestTimeToBuyAndSellStockWithCooldown.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}