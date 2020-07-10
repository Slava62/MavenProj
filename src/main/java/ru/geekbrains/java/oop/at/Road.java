package ru.geekbrains.java.oop.at;

// Создает дорожку
public class Road {
    private int length;
    Road(int length){
        this.length=length;
    }
    // Возвращает длину дорожки
    public int getLength() {
        return length;
    }
}
