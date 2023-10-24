package lab1;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите x: ");
        double x = in.nextDouble();
        double a, b, p;


        a = 0.5; b = 1.5; p = -4.0;
        if (Math.abs(x) > 0.2){
            System.out.println(Math.pow(a, 2) * Math.pow(x, 3) + Math.pow((Math.pow(b, 4) + 1.7), 0.25));
        }
        else {
            if (Math.abs(x) == 0.2) {
                System.out.println(Math.atan(Math.pow(2, x) - Math.abs(p)));
            }
            else {
                System.out.println(Math.pow(Math.log(Math.abs(a)) + 4.3, 1/3) + x);
            }
        }


        a = -1.0; b = 0.5;
        if (Math.abs(x) > 0.2){
            System.out.println(Math.pow(a, 2) * Math.pow(x, 3) + Math.pow((Math.pow(b, 4) + 1.7), 0.25));
        }
        else {
            if (Math.abs(x) == 0.2) {
                System.out.println(Math.atan(Math.pow(2, x) - Math.abs(p)));
            }
            else {
                System.out.println(Math.pow(Math.log(Math.abs(a)) + 4.3, 1/3) + x);
            }
        }

        a = 2.0; b = 0.0;
        if (Math.abs(x) > 0.2){
            System.out.println(Math.pow(a, 2) * Math.pow(x, 3) + Math.pow((Math.pow(b, 4) + 1.7), 0.25));
        }
        else {
            if (Math.abs(x) == 0.2) {
                System.out.println(Math.atan(Math.pow(2, x) - Math.abs(p)));
            }
            else {
                System.out.println(Math.pow(Math.log(Math.abs(a)) + 4.3, 1/3) + x);
            }
        }
    }
}
