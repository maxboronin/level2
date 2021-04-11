package ru.geekbrains.impl;

import ru.geekbrains.interfaces.RunAndJump;

public class RunAndJumpImpl implements RunAndJump {
    private String name;
    private int height;
    private int length;

    public RunAndJumpImpl(String name, int height, int length) {
        this.name = name;
        this.height = height;
        this.length = length;
    }

    @Override
    public boolean jump(int height) {
        if(height <= this.height){
            System.out.println(name + ": jumping " + height);
        }else {
            System.out.println(name + ": can't jumping " + height);
        }
        return false;
    }

    @Override
    public boolean run(int length) {
        if(length <= this.length){
            System.out.println(name + ": running " + length);
        }else {
            System.out.println(name + ": can't running " + length);
        }
        return false;
    }
}
