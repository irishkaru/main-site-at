package ru.geekbrains.examples.exceptions;

public class RuntimeExceptionsExample {
    public static void main(String[] args) {
        //1.
        try {
            arithmeticsExceptions();
        }catch (ArithmeticException e) {
        e.printStackTrace();
        System.out.println("Делить на ноль нельзя");
        }

        //2.
        int[] arr = {1,2,3};
        try {
            System.out.println(arr[3]);
        }catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Ошибка: несуществующий элемент массива");
        }

        //3.
        Object integer = 1;
        try {
            System.out.println((String) integer);
        }catch (ClassCastException e){
            e.printStackTrace();
            System.out.println("Ошибка: приведения типов");
        }

        //4.
        Object o = null;
        try {
            System.out.println(o.hashCode());
        }catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("Ошибка: Null");
        }

        //5.
        String name = "Бармаглот";
        try {
            System.out.println(name.charAt(10));
        }catch (StringIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("Ошибка: Несуществующий символ строки");
        }







    }
    public static double arithmeticsExceptions(){
        return 5/0;
    }
}
