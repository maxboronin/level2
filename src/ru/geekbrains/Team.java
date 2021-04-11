package ru.geekbrains;

import ru.geekbrains.interfaces.RunAndJump;

public class Team {
    private RunAndJump[] team;

    public Team(RunAndJump[] team) {
        this.team = team;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Team: \n");
        for (RunAndJump runnerJumper:
                team) {
            sb.append(runnerJumper);
            sb.append("\n");
        }
        return sb.toString();
    }
}
