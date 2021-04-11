package ru.geekbrains;

import ru.geekbrains.interfaces.RunAndJump;

import java.util.Random;

public class Main {
    private final static int bound = 5;

    public static void main(String[] args) {
        Random rnd = new Random();

        RunAndJump[] runnersJumpers = {
            new Human("Bob", rnd.nextInt(bound), rnd.nextInt(bound)),
            new Cat("Tom", rnd.nextInt(bound), rnd.nextInt(bound)),
            new Robot("Bender", rnd.nextInt(bound), rnd.nextInt(bound))
        };

        Team team = new Team(runnersJumpers);
        System.out.println(team);

        int qty = rnd.nextInt(bound);
        Interference[] interferences = new Interference[qty];

        for(int i=0; i < qty; i++){
            Interference interference;
            if(rnd.nextInt() > 2){
                interference = new Wall(rnd.nextInt(bound));
            }else{
                interference = new Road(rnd.nextInt(bound));
            }
            interferences[i] = interference;
        }

        Course course = new Course(interferences);
        System.out.println(course);

        for (RunAndJump runnerJumper:
             runnersJumpers) {
            course.cross(runnerJumper);
        }

    }
}
