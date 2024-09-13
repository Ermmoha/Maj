import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ввод длины массива
        System.out.println("Введите длину массива: ");
        int size = input.nextInt();

        // Создание массива и его заполнение
        int[] array = new int[size];
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }

        System.out.println("Введите коэффициент мажоритарности : ");
        double ratio = input.nextDouble();

        // Подсчет вхождений элементов в массиве
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int el : array) {
            hashMap.put(el, hashMap.getOrDefault(el, 0) + 1); // Увеличиваем счетчик для каждого элемента
        }

        // Рассчитываем порог для мажоритарных элементов
        double majority = size * ratio;

        // Поиск и вывод мажоритарных элементов
        System.out.println("Мажоритарные элементы: ");
        boolean hasMajority = false;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() >= Math.ceil(majority)) { // Проверяем, превышает ли число вхождений порог
                System.out.println(entry.getKey());
                hasMajority = true;
            }
        }

        if (!hasMajority) {
            System.out.println("Нет мажоритарных элементов.");
        }
    }
}
