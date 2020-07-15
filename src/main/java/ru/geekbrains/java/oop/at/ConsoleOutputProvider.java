package ru.geekbrains.java.oop.at;

public class ConsoleOutputProvider implements IOutputProvider{
    //Вывод информации в консоль
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
