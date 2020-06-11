package ru.geekbrains.examples.collections;

import java.util.*;

public class SetStart {
    public static void main(String[] args) {
        Set<CarModel> carModelSet = new HashSet<>();
        Set<CarModel> carModelSet1 = new HashSet<>();

        CarModel[] carModels = {new CarModel("mersedes"), new CarModel("audi")};

        carModelSet.addAll(Arrays.asList(carModels));

        carModelSet1.add(new CarModel("vaz"));
        carModelSet1.add(new CarModel("volga"));

        carModelSet.add(new CarModel("vaz"));
        carModelSet.add(new CarModel("volga"));
        carModelSet.add(new CarModel("kia"));
        carModelSet.add(new CarModel("vaz"));
        carModelSet.add(new CarModel("vaz"));

        //carModelSet.retainAll(carModelSet1); //пересечение

        for (CarModel carModel:carModelSet){
            System.out.println(carModel);
        }

        System.out.println(carModelSet.size());


    }
}
