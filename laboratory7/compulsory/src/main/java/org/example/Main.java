package org.example;

import org.example.Exploration;
import org.example.Robot;

public class Main {
    public static void main(String[] args) {

        var explore = new Exploration(4);
        explore.addRobot(new Robot("Robot1"));
        explore.addRobot(new Robot("Robot2"));
        explore.addRobot(new Robot("Robot3"));

        explore.start();
    }
}