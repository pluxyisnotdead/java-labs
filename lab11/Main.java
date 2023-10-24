package lab11;

import lab9.Course;
import lab9.NoHeaderObjectOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {




    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String connectionsPath = "src/lab11/connections.bin";
        String servicesPath = "src/lab11/services.bin";


        MainMenu.show(scanner, servicesPath, connectionsPath);
    }
}
