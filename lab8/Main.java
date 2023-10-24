package lab8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Team eagles = new Team("USA", "Eagles",
                new ArrayList<Player>(List.of(
                        new Player("Marty Boo", 22, 11),
                        new Player("Jimmy Choo", 25, 1),
                        new Player("John Doe", 20, 5),
                        new Player("Fillie Laskin", 21, 6),
                        new Player("Aire Bailey", 23, 78),
                        new Player("Erik Cartman", 20, 75),
                        new Player("Jocelyn Cohle", 24, 45),
                        new Player("Graham Beckett", 24, 22)
                )));

        Team bears = new Team("Russia", "Bears",
                new ArrayList<Player>(List.of(
                        new Player("Sean O'Neill", 18, 9),
                        new Player("Nana Price", 17, 1),
                        new Player("Carty Money", 15, 2),
                        new Player("Ian Richards", 20, 5),
                        new Player("Claire Lange", 44, 6),
                        new Player("Roman Sovin", 30, 100),
                        new Player("George Pickett", 20, 55)
                )));

        Team youngster;

        System.out.println("AVG age of " + bears.getName() + ": " + bears.averageAge());
        System.out.println("AVG age of " + eagles.getName() + ": " + eagles.averageAge());
        if (bears.averageAge() < eagles.averageAge()){
            youngster = bears;
        } else { youngster = eagles; }

        youngster.sortByNum();

        System.out.println("\n" + youngster.getName() + ":");
        for (var player : youngster.getPlayers()) {
            System.out.println("\t" + player.toString());
        }
    }
}
