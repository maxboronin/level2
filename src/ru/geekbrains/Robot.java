package ru.geekbrains;

import ru.geekbrains.interfaces.RunAndJump;

public class Robot implements RunAndJump {
    private int height;
    private int length;
    private String name;

    public Robot(String name, int height, int length) {
        this.height = height;
        this.length = length;
        this.name = name;
    }

    @Override
    public boolean jump(int height) {
        System.out.println("Robot " + name + ": try jump " + height);
        return height <= this.height;
    }

    @Override
    public boolean run(int length) {
        System.out.println("Robot " + name + ": try run " + length);
        return length <= this.length;
    }
    @Override
    public String toString() {
        return "Robot " + name + ". Height: " + height + ". Length: " + length;
    }
}
