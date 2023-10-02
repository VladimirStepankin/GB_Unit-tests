package sixth.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareAverages {
    public static void main(String[] args) {
        // Создаем два списка чисел
        List<Number> list1 = new ArrayList<>(Arrays.asList(10, 20, 30));
        List<Number> list2 = new ArrayList<>(Arrays.asList(40, 50, 60));

        // Рассчитываем средние значения списков
        double average1 = calculateAverage(list1);
        double average2 = calculateAverage(list2);

        String result = compareAverages(average1, average2);

        System.out.println(result);
    }

    public static double calculateAverage(List<Number> list) {
        if (list.size() == 0) {
            return 0;
        }
        double sum = 0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum / list.size();
    }

    public static String compareAverages(double average1, double average2) {
        if (average1 > average2) {
            return "Первый список имеет большее среднее значение";
        } else if (average1 < average2) {
            return "Второй список имеет большее среднее значение";
        } else {
            return "Средние значения равны";
        }
    }
}

