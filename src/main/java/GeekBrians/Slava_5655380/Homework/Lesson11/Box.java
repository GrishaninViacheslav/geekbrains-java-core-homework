package GeekBrians.Slava_5655380.Homework.Lesson11;

import static GeekBrians.Slava_5655380.Utils.*;

import java.util.ArrayList;


/**
 * ЗАДАНИЕ 3.b. Класс Box, в который можно складывать фрукты.
 * Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 */
public class Box<E extends Fruit> {
    /**
     * ЗАДАНИЕ 3.c. Для хранения фруктов внутри коробки можно использовать ArrayList;
     */
    private ArrayList<E> content = new ArrayList<>();
    private final float EPSILON = Math.nextUp(1.0f) - 1.f;

    /**
     * ЗАДАНИЕ 3.g. Не забываем про метод добавления фрукта в коробку.
     */
    public void add(E fruit) {
        content.add(fruit);
    }

    /**
     * ЗАДАНИЕ 3.f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
     * Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
     * Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
     */
    public void moveFrom(Box<E> box) {
        for (var i : range(box.content.size()))
            add(box.pop());
    }

    public E pop() {
        if (content.size() == 0)
            return null;
        return content.remove(content.size() - 1);
    }

    /**
     * ЗАДАНИЕ 3. d. Сделать метод getWeight(), который высчитывает вес коробки,
     * зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
     */
    public float getWeight() {
        float weight = 0.f;
        for (E fruit : content)
            weight = (float) kahanSum(new Double(weight), new Double(fruit.getWeight()));
        return weight;
    }

    /**
     * ЗАДАНИЕ 3.e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
     * которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
     * Можно сравнивать коробки с яблоками и апельсинами;
     */
    public boolean compare(Box<?> box) {
        return absDouble(getWeight() - box.getWeight()) < EPSILON;
    }
}
