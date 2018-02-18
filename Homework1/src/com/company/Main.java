package com.company;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Выберите программу: 1-калькулятор, 2-длина слов");
        Scanner scanner = new Scanner(System.in);
        int variety = scanner.nextInt();
        switch (variety) {
            case 1:
                System.out.println("Введите два числа");
                double first = scanner.nextDouble();
                double two = scanner.nextDouble();
                System.out.println("Выберите операцию: Для выбора сложения нажмите 1, Для выбора вычитания нажмите 2, Для выбора деления нажмите 3, для выбора умножениея нажмите 4");   // Выводит в консоль обращение
                int choice;
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        double res = first + two;
                        System.out.printf("Результат сложения = %.4f", res);
                        break;
                    case 2:
                        double res1 = first - two;
                        System.out.printf("Результат вычитания = %.4f", res1);
                        break;
                    case 3:
                        double res2 = first / two;
                        System.out.printf("Результат деления = %.4f", res2);
                        break;
                    case 4:
                        double res3 = first * two;
                        System.out.printf("Результат умножения = %.4f", res3);
                        break;
                    default:
                        System.out.println("Нет такой операции");


                }
            case 2:
                System.out.println("Введите количество слов");
                int size = scanner.nextInt();
                String array [];
                array = new String[size];
                int leng = 0;
                int number = 0;
                for (int i = 0; i < size; i++){
                    System.out.println("Введите слово");
                    array[i] = scanner.next();
                    int length = array[i].length();
                    if (length > leng){
                        leng = length;
                        number = i;
                    }
                }
                System.out.println("Самое длинное слово: " + array[number] + " Количество символов " + leng);
                break;
            default:System.out.println("Неверно введен номер программы");
        }
    }
}