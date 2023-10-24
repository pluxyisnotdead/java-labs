package lab2;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int i = 1;

        while (i < a){
            i *= 2;
        }

        if (i == a){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
