package seminar.third.hw;

import seminar.third.hw.hw.evenOddNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EvenOddNumberTest {
    private evenOddNumber evenOddNumber;

    @Test
    public void testEvenNumber() {
        assertTrue(evenOddNumber.evenOddNumber(2)); // Проверяем четное число
        assertTrue(evenOddNumber.evenOddNumber(0)); // Проверяем ноль (тоже четное)
        assertTrue(evenOddNumber.evenOddNumber(-4)); // Проверяем отрицательное четное число
    }

    @Test
    public void testOddNumber() {
        assertFalse(evenOddNumber.evenOddNumber(3)); // Проверяем нечетное число
        assertFalse(evenOddNumber.evenOddNumber(-7)); // Проверяем отрицательное нечетное число
    }

    @Test
    public void testZero() {
        assertTrue(evenOddNumber.evenOddNumber(0)); // Проверяем ноль (число считается четным)
    }
}
