package ru.geekbrains.examples.collections;

import java.util.*;

public class ListStart {
    public static void main(String[] args) {
        List<CarModel> carModelList = new ArrayList<>();

        CarModel m1 = new CarModel("1234");

        carModelList.add(new CarModel("123"));
        carModelList.add(new CarModel("12365"));
        carModelList.add(new CarModel("12343"));
        carModelList.add(m1);

        System.out.println(carModelList.indexOf(m1));
        System.out.println(carModelList.contains(m1));
        System.out.println(carModelList.remove(m1));
        System.out.println(carModelList.contains(m1));

        Iterator<CarModel> iterator = carModelList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }

        System.out.println(carModelList.size());

        System.out.println("_______________");

        List<Car> carList = new ArrayList<>();

        carList.add(new Car("volga"));
        carList.add(new Car("mazda"));
        carList.add(new Car("mersedes"));
        carList.add(new Car("audi"));
        carList.add(new Car("vaz"));

        System.out.println("don't sort");
        System.out.println(carList);

        Comparator<Car> SORT_BY_MODEL = new Comparator<Car>() {
            @Override
            public int compare(Car w1, Car w2) {
                return w1.getModel().compareTo(w2.getModel());
            }
        };

        Collections.sort(carList, SORT_BY_MODEL);
        System.out.println("sort by model");
        System.out.println(carList);

    }
}
