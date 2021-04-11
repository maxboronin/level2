package ru.geekbrains;

import ru.geekbrains.interfaces.RunAndJump;

public class Road extends Interference{
    private int length;

    public Road(int length) {
        super("Road");
        this.length = length;
    }

    @Override
    protected boolean cross(RunAndJump runnerJumper) {
        System.out.println(this);
        if(runnerJumper.run(length)){
            System.out.println("Success!");
        }else{
            System.out.println("Unsuccess!");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getType() + ", length: " + length;
    }
}
