package ru.geekbrains;

import ru.geekbrains.interfaces.RunAndJump;

public abstract class Interference {
    private String type;

    public Interference(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    protected abstract boolean cross(RunAndJump runnerJumper);

    @Override
    public String toString() {
        return type;
    }
}
