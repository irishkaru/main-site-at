package ru.geekbrains.examples.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadExamples {
    public static void main(String[] args) {
        //1.
//       File file = new File("/path");
//                try {
//                    System.out.println("Блок try");
//                    new FileReader(file);
//                } catch (FileNotFoundException e) {
//                    System.out.println("Блок catch");
//                    //e.printStackTrace();
//                }catch (IOException exception){
//                    System.out.println("Блок catch IOException");
//                } finally {
//                    System.out.println("Блок finally");}

        //2.
        FileReaderExamples reader = new FileReaderExamples();
        try {
            reader.readFile("/123");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
