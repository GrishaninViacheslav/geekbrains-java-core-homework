package GeekBrians.Slava_5655380.Homework.Lesson11;

import static GeekBrians.Slava_5655380.Utils.*;
import static GeekBrians.Slava_5655380.Homework.Lesson11.ArrayUtils.*;

import java.util.ArrayList;

public class MainDemo {
    public static void main(String[] args) {
        // ЗАДАНИЕ 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        swapElements(arr, 1, 5);
        deepPrint(arr);

        // ЗАДАНИЕ 2. Написать метод, который преобразует массив в ArrayList;
        ArrayList<Integer> arrayList = toArrayList(arr);
        System.out.println("\n");
        System.out.println(arrayList);

        // ЗАДАНИЕ 3.b. Класс Box, в который можно складывать фрукты.
        // Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
        Box<Apple> appleBox = new Box<>();
        for (var i : range(10))
            appleBox.add(new Apple());
        //! appleBox.add(new Orange());

        Box<Orange> orangeBox = new Box<>();
        for (var i : range(10))
            orangeBox.add(new Orange());
        //! orangeBox.add(new Apple());

        // ЗАДАНИЕ 3. d. Сделать метод getWeight(), который высчитывает вес коробки,
        // зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
        System.out.println();
        System.out.println("appleBox weight: " + appleBox.getWeight());
        System.out.println("orangeBox weight: " + orangeBox.getWeight());

        // ЗАДАНИЕ 3.e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
        // которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
        // Можно сравнивать коробки с яблоками и апельсинами;
        Box<Apple> appleBox2 = new Box<>();
        for (var i : range(10))
            appleBox2.add(new Apple());

        Box<Apple> appleBox3 = new Box<>();
        for (var i : range(15))
            appleBox3.add(new Apple());

        System.out.println();
        System.out.println(
                "compare result of appleBox(" + appleBox.getWeight() + ") and appleBox2(" + appleBox2.getWeight() + ") is " +
                appleBox.compare(appleBox2)
        );
        System.out.println(
                "compare result of appleBox(" + appleBox.getWeight() + ") and appleBox3(" + appleBox3.getWeight() + ") is " +
                appleBox.compare(appleBox3)
        );
        System.out.println(
                "compare result of appleBox3(" + appleBox3.getWeight() + ") and orangeBox(" + orangeBox.getWeight() + ") is " +
                appleBox3.compare(orangeBox)
        );

        // ЗАДАНИЕ 3.f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
        // Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
        // Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
        appleBox.moveFrom(appleBox2);
        System.out.println();
        System.out.println("appleBox weight: " + appleBox.getWeight());
        System.out.println("appleBox2 weight: " + appleBox2.getWeight());
        //! orangeBox.moveFrom(appleBox);

        // ЗАДАНИЕ 3.g. Не забываем про метод добавления фрукта в коробку.
        appleBox.add(new Apple());
    }
}
