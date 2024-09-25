import java.util.Scanner;

/**
 * Клас для роботи з числами Фібоначчі
 */
class Fibonacci {
    private int index;
    private long value;

    /**
     * Конструктор класу Fibonacci
     * @param indexx Номер числа Фібоначчі
     * @param value Значення числа Фібоначчі
     */
    public Fibonacci(int indexx, long value) {
        index = indexx;
        this.value = value;
    }

    /**
     * Отримати номер числа Фібоначчі
     * @return Номер числа
     */
    public int getIndex() {
        return index;
    }

    /**
     * Отримати значення числа Фібоначчі
     * @return Значення числа
     */
    public long getValue() {
        return value;
    }

    /**
     * Перевірити, чи є число на 1 менше ніж певний куб
     * @return true, якщо число на 1 менше куба
     */
    public boolean isOneLessThanCube() {
        double cubeRoot = Math.cbrt(value + 1);
        return Math.round(cubeRoot) * Math.round(cubeRoot) * Math.round(cubeRoot) == (value + 1);
    }
}

public class FibonacciNumbers {

    /**
     * Допоміжний метод для друку числа Фібоначчі і перевірки на куб
     * @param fib об'єкт Fibonacci
     */
    private static void printFibonacci(Fibonacci fib) {
        System.out.printf("F(%d) = %d", fib.getIndex(), fib.getValue());
        if (fib.isOneLessThanCube()) {
            System.out.println(" -> на 1 менше ніж куб якогось числа.");
        } else {
            System.out.println();
        }
    }

    /**
     * Метод для обчислення чисел Фібоначчі і виведення на екран без збереження у список
     * @param n кількість чисел Фібоначчі
     */
    public static void generateAndPrintFibonacci(int n) {
        long a = 0, b = 1;

        // Друкуємо перше число Фібоначчі
        Fibonacci fib = new Fibonacci(1, a);
        printFibonacci(fib);

        if (n > 1) {
            // Друкуємо друге число Фібоначчі
            fib = new Fibonacci(2, b);
            printFibonacci(fib);
        }

        // Генерація і друк наступних чисел Фібоначчі
        for (int i = 3; i <= n; i++) {
            long next = a + b;
            fib = new Fibonacci(i, next);
            printFibonacci(fib);
            a = b;
            b = next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість чисел Фібоначчі (N): ");
        int n = scanner.nextInt();

        System.out.println("Числа Фібоначчі та перевірка на куб:");
        generateAndPrintFibonacci(n);
    }
}