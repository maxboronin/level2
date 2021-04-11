package ru.geekbrains;

import ru.geekbrains.interfaces.RunAndJump;

public class Cat implements RunAndJump {
    private int height;
    private int length;
    private String name;

    public Cat(String name, int height, int length) {
        this.height = height;
        this.length = length;
        this.name = name;
    }

    @Override
    public boolean jump(int height) {
        System.out.println("Cat " + name + ": try jump " + height);
        return height <= this.height;
    }

    @Override
    public boolean run(int length) {
        System.out.println("Cat " + name + ": try run " + length);
        return length <= this.length;
    }

    @Override
    public String toString() {
        return "Cat " + name + ". Height: " + height + ". Length: " + length;
    }
}
