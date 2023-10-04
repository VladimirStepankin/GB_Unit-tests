package sixth.hw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompareAveragesTest {

    @Test
    public void testCalculateAverage() { // Тест для проверки правильности расчета среднего значения
        List<Number> list1 = new ArrayList<>(Arrays.asList(10, 20, 30));
        List<Number> list2 = new ArrayList<>(Arrays.asList(40, 50, 60));

        double average1 = CompareAverages.calculateAverage(list1);
        double average2 = CompareAverages.calculateAverage(list2);

        assertEquals(20.0, average1);
        assertEquals(50.0, average2);
    }

    @Test
    public void testCompareAverages() { // Тесты для сравнения средних значений списков
        List<Number> list1 = new ArrayList<>(Arrays.asList(10, 20, 30));
        List<Number> list2 = new ArrayList<>(Arrays.asList(40, 50, 60));
        List<Number> list3 = new ArrayList<>(Arrays.asList(5, 10, 15, 30, 40));

        double average1 = CompareAverages.calculateAverage(list1);
        double average2 = CompareAverages.calculateAverage(list2);
        double average3 = CompareAverages.calculateAverage(list3);

        // Первый список имеет большее среднее значение
        String result1 = CompareAverages.compareAverages(average2, average1);
        assertEquals("Первый список имеет большее среднее значение", result1);

        // Второй список имеет большее среднее значение
        String result2 = CompareAverages.compareAverages(average1, average2);
        assertEquals("Второй список имеет большее среднее значение", result2);

        // Средние значения равны
        String result3 = CompareAverages.compareAverages(average1, average3);
        assertEquals("Средние значения равны", result3);

    }


    @Test
    public void testEmptyList() { // Тест для случая пустых списков
        List<Number> list1 = new ArrayList<>();
        List<Number> list2 = new ArrayList<>();

        double average1 = CompareAverages.calculateAverage(list1);
        double average2 = CompareAverages.calculateAverage(list2);

        String result = CompareAverages.compareAverages(average1, average2);
        assertEquals("Средние значения равны", result);
    }

    @Test
    public void testOneEmptyList() { // Тест для случая одного пустого списка
        List<Number> list1 = new ArrayList<>();
        List<Number> list2 = new ArrayList<>(Arrays.asList(40, 50, 60));

        double average1 = CompareAverages.calculateAverage(list1);
        double average2 = CompareAverages.calculateAverage(list2);

        String result = CompareAverages.compareAverages(average1, average2);
        assertEquals("Второй список имеет большее среднее значение", result);
    }

    @Test
    public void testNegativeNumbers() { // Тест для случая отрицательных значений в списках
        List<Number> list1 = new ArrayList<>(Arrays.asList(-10, -20, -30));
        List<Number> list2 = new ArrayList<>(Arrays.asList(-40, -50, -60));

        double average1 = CompareAverages.calculateAverage(list1);
        double average2 = CompareAverages.calculateAverage(list2);

        String result = CompareAverages.compareAverages(average1, average2);
        assertEquals("Первый список имеет большее среднее значение", result);
    }
}