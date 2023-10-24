package lab5;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Country country = Country.get(scanner);

        while (true) {
            System.out.println(
                    "\nВыберете пункт меню:\n" +
                            "0. Выход\n" +
                            "1. Узнать столицу\n" +
                            "2. Узнать количество областей\n" +
                            "3. Узнать площадь государства\n" +
                            "4. Узнать областные центры\n"
            );
            int choice = scanner.nextInt();
            if (choice == 0)
                break;
            if (choice < 1 || choice > 4) {
                System.out.println("Выбран неправильный пункт меню, повторите ввод.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println(country.capital.getName());
                    break;
                case 2:
                    System.out.println(country.amountOfRegions());
                    break;
                case 3:
                    System.out.println(country.getArea());
                    break;
                case 4:
                    for (var region: country.getRegions()) {
                        System.out.println(region.getName() + " ");
                    }
                    break;
            }
        }
    }
}
