import seminars.first.model.Calculator;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    public static void main(String[] args) {
        // Проверка базового функционала с целыми числами:
        if (8 != Calculator.calculation(2, 6, '+')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (0 != Calculator.calculation(2, 2, '-')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (14 != Calculator.calculation(2, 7, '*')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (2 != Calculator.calculation(100, 50, '/')) {
            throw new AssertionError("Ошибка в методе");
        }

        // Случаи с неправильными аргументами
        // аргумент operator типа char, должен вызывать исключение, если он получает не базовые символы (+-*/)
        try {
            Calculator.calculation(8, 4, '_');
        } catch (IllegalStateException e) {
            if (!e.getMessage().equals("Unexpected value operator: _")) {
                throw new AssertionError("Ошибка в методе");
            }
        }

        // Проверка базового функционала с целыми числами, с использованием утверждений:
        assert 8 == Calculator.calculation(2, 6, '+');
        assert 0 == Calculator.calculation(2, 2, '-');
        assert 14 == Calculator.calculation(2, 7, '*');
        assert 2 == Calculator.calculation(100, 50, '/');

        // Проверка базового функционала с целыми числами, с использованием утверждений AssertJ:
        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);

        // Проверка ожидаемого исключения, с использованием утверждений AssertJ:
        assertThatThrownBy(() ->
                Calculator.calculation(8, 4, '_')
        ).isInstanceOf(IllegalStateException.class);

//        System.out.println(Calculator.calculation(2_147_483_647, 1, '+')); // integer overflow
//        System.out.println(Calculator.squareRootExtraction(169));

        // Тесты ДЗ
        // Проверка корректного расчета скидки
        assertThat(Calculator.calculatingDiscount(100.0, 10.0)).isEqualTo(90.0);
        assertThat(Calculator.calculatingDiscount(200.0, 20.0)).isEqualTo(160.0);

        // Проверка исключения при отрицательной сумме покупки
        assertThatThrownBy(() -> Calculator.calculatingDiscount(-100.0, 10.0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Invalid arguments");

        // Проверка исключения при отрицательном проценте скидки
        assertThatThrownBy(() -> Calculator.calculatingDiscount(100.0, -10.0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Invalid arguments");

        // Проверка исключения при проценте скидки больше 100
        assertThatThrownBy(() -> Calculator.calculatingDiscount(100.0, 110.0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Invalid arguments");

        System.out.println(Calculator.calculatingDiscount(-100, 10));
    }
}