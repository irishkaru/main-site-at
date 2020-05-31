package ru.geekbrains.examples.junit;

public class Start {
    public static void main(String[] args) {
        BaseStaticExampleClass child = new ChildStaticExampleClass();
        child.sayHello();       // <- вызвали статический метод у экземпляра дочернего класса
    }
}
