package ru.geekbrains.examples.collections;

import com.sun.javafx.collections.MappingChange;
import io.qameta.allure.Step;

import java.util.*;

public class MapStart {
    public static void main(String[] args) {

        Map<CarModel, Map<String, Integer>> carModelMapMap = new HashMap<>();
        Map<CarModel, String> carModelMap = new HashMap<>();

        carModelMap.put(new CarModel("vaz"), "bad");
        carModelMap.put(new CarModel("volga"), "bad");
        carModelMap.put(new CarModel("mersedes"), "good");
        carModelMap.put(new CarModel("toyota"), "very good");

        System.out.println(carModelMap.values()); //значение
        System.out.println(carModelMap.get(new CarModel("vaz"))); //получаем по ключу
        System.out.println(carModelMap.containsKey(new CarModel("vaz"))); //содержитт ли ключ
        System.out.println(carModelMap.containsValue("good")); //значение
        System.out.println("___________________________________");

        Map<String, Integer> dnevnik = new HashMap<>();
        dnevnik.put("Sidorov", 5);
        dnevnik.put("Petrov", 2);
        dnevnik.put("Ivanov", 4);
        dnevnik.put("Penkov", 4);
        dnevnik.put("Sharov", 5);
        dnevnik.put("Svistunov", 3);
        dnevnik.put("Semenov", 4);

        System.out.println(dnevnik);
        System.out.println(dnevnik.values());
        System.out.println(dnevnik.keySet());
        System.out.println(dnevnik.get("Petrov")); //5

        for (Map.Entry<String, Integer> entry : dnevnik.entrySet()) {
            if (entry.getValue().equals(5)) {
                System.out.println(entry.getKey());
            }
        }

        System.out.println();

        Iterator<Map.Entry<String, Integer>> entries = dnevnik.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Integer> entry = entries.next();
            System.out.println(entry.getKey() + " Оценка = " + entry.getValue());
        }

        System.out.println();

    }
}
