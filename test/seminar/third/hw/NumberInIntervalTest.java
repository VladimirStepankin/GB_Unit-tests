package seminar.third.hw;

import org.junit.jupiter.api.Test;
import seminar.third.hw.hw.NumerInInterval;

import static org.junit.jupiter.api.Assertions.*;

public class NumberInIntervalTest {
    @Test
    public void testNumberInInterval() {
        NumerInInterval checker = new NumerInInterval();

        // Проверка чисел внутри интервала
        assertTrue(checker.numberInInterval(26));
        assertTrue(checker.numberInInterval(50));
        assertTrue(checker.numberInInterval(99));

        // Проверка чисел, граничных с интервалом
        assertFalse(checker.numberInInterval(25));
        assertFalse(checker.numberInInterval(100));

        // Проверка чисел за пределами интервала
        assertFalse(checker.numberInInterval(24));
        assertFalse(checker.numberInInterval(101));
    }
}
