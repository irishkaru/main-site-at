package ru.geekbrains.examples.collections;

import java.util.Objects;

public class Start {
    public static void main(String[] args) {
        //Сравнение объектов
        //equals()
        Object object1 = new Object();
        Object object2 = object1;
        Object object3 = object2;

        System.out.println(object1.equals(object3));

        Car car1 = new Car("vaz-2106");
        Car car2 = new Car("vaz-2106");

        System.out.println(car1.equals(car2));

        //переопределяем логику равенства
        CarModel carModel1 = new CarModel("vaz-2106");
        CarModel carModel2 = new CarModel("vaz-2106");
        CarModel carModel3 = null;
        CarEngineType carEngineType1 = new CarEngineType("V8");

        System.out.println(carModel1.equals(carModel2));
        System.out.println(carModel1.equals(carEngineType1));
        System.out.println(carModel1.equals(carModel3));

        System.out.println(carModel1.hashCode());
        System.out.println(carModel2.hashCode());
    }
}

class Car {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                '}';
    }
}

class CarEngineType {
    private String type;

    public CarEngineType(String type) {
        this.type = type;
    }
}

class CarModel {
    private String model;
    private int year;

    public CarModel(String model) {
        this.model = model;
        year = 0;
    }

    public CarModel(String model, int year) {
        this.model = model;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarModel carModel = (CarModel) o;
        return year == carModel.year &&
                model.equals(carModel.model);
    }

    @Override
    public int hashCode() {

        return Objects.hash(model, year);
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "model='" + model + '\'' +
                ", year=" + year +
                '}';
    }

}

