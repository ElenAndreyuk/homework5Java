import java.util.*;

public class Main {
    public static void main(String[] args) {
//1.Создать словарь HashMap. Обобщение <Integer, String>.
        Map<Integer, String> colors = new HashMap<>();

//2.Заполнить тремя ключами (индекс, цвет), добавить ключ, если не было!)
        colors.put(1, "red");
        colors.put(2, "green");
        colors.put(3, "blue");
        colors.putIfAbsent(4, "yellow");
//3.Изменить значения дописав восклицательные знаки.
// *Создать TreeMap, заполнить аналогично.
        for (int i: colors.keySet()) {
            colors.compute(i,(k, v) -> v = v + "!");
        }
        System.out.println(colors);

        Map<Integer, String> colors2 = new TreeMap<>();
        colors2.put(1, "red");
        colors2.put(2, "green");
        colors2.put(3, "blue");
        colors2.putIfAbsent(4, "yellow");

//4.*Увеличить количество элементов таблиц до 1000 случайными ключами и общей строкой.
        for (int i = 0; i < 1000; i++) {
            int rand = new Random().nextInt(10000);
            colors.put(rand, " ");
        }
        for (int i = 0; i < 1000; i++) {
            int rand = new Random().nextInt(10000);
            colors2.put(rand, " ");
        }
//5.**Сравнить время прямого и случайного перебора тысячи элементов словарей.
        System.out.println("---Timing---");
        long start = System.currentTimeMillis();
        colors.forEach((k,v) -> System.out.print(k + v));
        System.out.println();
        System.out.println("HashMap: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 1001; i++) {
            System.out.printf(colors.get(i) + ", ");
        }
        System.out.println();
        System.out.println("HashMap iterator: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = new Random().nextInt(1000); i < 1001; i++) {
            System.out.print(colors.get(i) +", ");
        }
        System.out.println();
        System.out.println("HashMap Random: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        colors2.forEach((k,v) -> System.out.print(k + v));
        System.out.println();
        System.out.println("TreeMap: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i: colors2.keySet()) {
            System.out.printf(i + ", ");
        }
        System.out.println();
        System.out.println("TreeMap iterator: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = new Random().nextInt(1000); i < 1001; i++) {
            System.out.print(colors2.get(i) +", ");
        }
        System.out.println();
        System.out.println("TreeMap Random: " + (System.currentTimeMillis() - start));







    }
}