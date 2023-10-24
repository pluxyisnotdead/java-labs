package lab1;
import java.util.Scanner;

// Шахматная ладья ходит по горизонтали или вертикали. Даны две различные клетки
// шахматной доски, определите, может ли ладья попасть с первой клетки на вторую
// одним ходом. Программа должна вывести YES, если из первой клетки ходом ладьи
// можно попасть во вторую или NO в противном случае. (if, ?, switch, Math)

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1, x2, y1, y2;
        String str = "NO";

        System.out.println("Введите координаты первой клетки: ");
        x1 = in.nextInt();
        y1 = in.nextInt();

        System.out.println("Введите координаты второй клетки: ");
        x2 = in.nextInt();
        y2 = in.nextInt();

        if(((x1 != x2) && (y1 == y2)) || ((x1 == x2) && (y1 != y2))){
            str = "YES";
        }

        System.out.println(str);
    }
}
