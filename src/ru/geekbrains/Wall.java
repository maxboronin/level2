package ru.geekbrains;

import ru.geekbrains.interfaces.RunAndJump;

public class Wall extends Interference{
    private int height;

    public Wall(int height) {
        super("Wall");
        this.height = height;
    }

    @Override
    protected boolean cross(RunAndJump runnerJumper) {
        System.out.println(this);
        if(runnerJumper.jump(height)){
            System.out.println("Success!");
        }else{
            System.out.println("Unsuccess!");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getType() + ", height: " + height;
    }
}
