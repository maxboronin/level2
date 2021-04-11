package ru.geekbrains;

import ru.geekbrains.interfaces.RunAndJump;

import java.util.Random;

public class Course {
    private Interference[] interferences;

    public Course(Interference[] interferences) {
        this.interferences = interferences;
    }

    public boolean cross(RunAndJump runnerJumper){
        System.out.println("=====================================");
        System.out.println("Start cross for " + runnerJumper);
        for (Interference interference:
             interferences) {
            if(!interference.cross(runnerJumper)){
                System.out.println("Cross unsuccess");
                return false;
            }
        }
        System.out.println("Cross success");
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cross: \n");
        for (Interference interference:
                interferences) {
            sb.append(interference);
            sb.append("\n");
        }
        return sb.toString();
    }

}
