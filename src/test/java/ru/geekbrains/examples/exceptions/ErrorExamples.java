package ru.geekbrains.examples.exceptions;

import java.util.ArrayList;
import java.util.List;

class ErrorExamples {
    public static List<Object> objectList;

    public static void main(String[] args) {

        //1. рекурсия StackOverflowError - необрабатываемые исключения
        test();

        //2. OutOfMemoryError - необрабатываемые исключения
        objectList = new ArrayList<>();
        while (true){
            objectList.add(new Object[1000000000]);
        }

    }


    public static void test(){
        test();
    }
}

