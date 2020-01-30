package Lesson_1.DZ;

import java.util.ArrayList;

/**
 * b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 */
public class Box<T extends Fruit> {
    private ArrayList<T> arrayList; //c. Для хранения фруктов внутри коробки можете использовать ArrayList;

    public Box() { //ArrayList<T> arrayList
        this.arrayList = new ArrayList<>(); //arrayList
    }

    /**
     * d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
     * @return
     */
    public float getWeight(){
        float amountFruitInBox = this.arrayList.size();
        float weightOneFruit = this.arrayList.get(0).getWeightOneFruit();
        return weightOneFruit * amountFruitInBox;
    }

    /**
     * e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
     * которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае
     * (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
     */
    public boolean compare(Box<? super Fruit> another) { //ограничения снизу накладываем в методе
        return Math.abs(this.getWeight() - another.getWeight()) < 0.0001;
    }

    /**
     * f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку
     * (помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
     * соответственно в текущей коробке фруктов не остается,
     * а в другую перекидываются объекты, которые были в этой коробке;
     */
    public Box<T> changeBox() {
        Box<T> newBox = new Box<T>();
        newBox.arrayList.addAll(this.arrayList);
        //newBox.arrayList = (ArrayList<T>) this.arrayList.clone();
        this.arrayList.clear();
        return newBox;
    }

    /**
     *g. Не забываем про метод добавления фрукта в коробку.
     */
    public void addFruit(int num) {
        for (int i = 0; i < num; i++) {

            new Apple();

            T newFruit = new Fruit(T);
            this.arrayList.add(newFruit);
        }

    }
}
