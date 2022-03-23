import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WaterCalculatorTest {

    private final WaterCalculator waterCalculator = new WaterCalculator();

    @Test
    void calculateWaterAmountTestEmpty() {
        assertEquals(0, waterCalculator.calculateWaterAmount(new int[0]));
    }

    @Test
    void calculateWaterAmountTestSuccess() {
        assertEquals(35, waterCalculator.calculateWaterAmount(new int[]{2, 8, 5, 0, 6, 0, 2, 0 ,8, 0}));
    }

    @Test
    void calculateWaterAmountTestThrowTooHigh() {
        assertThrows(IllegalArgumentException.class, () -> waterCalculator.calculateWaterAmount(new int[]{32001}));
    }

    @Test
    void calculateWaterAmountTestThrowTooWide() {
        assertThrows(IllegalArgumentException.class, () -> waterCalculator.calculateWaterAmount(new int[32001]));
    }

    @Test
    void calculateWaterAmountTestThrowNegativeHeight() {
        assertThrows(IllegalArgumentException.class, () -> waterCalculator.calculateWaterAmount(new int[]{-1}));
    }


}
