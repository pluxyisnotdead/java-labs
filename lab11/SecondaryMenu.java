package lab11;

import java.util.ArrayList;
import java.util.Scanner;

public class SecondaryMenu {
    static MobileConnection show(Scanner scanner, MobileConnection connection, String servicesPath){
        while (true) {
            System.out.println(
                    """

                            Выберете пункт меню:
                            0. Выход на главное меню
                            1. Показать все тарифы
                            2. Добавить новый тариф
                            3. Удалить выбранный тариф
                            4. Редактировать выбранный тариф
                            5. Показать всех пользователей
                            6. Добавить нового пользователя
                            7. Удалить выбранного пользователя
                            8. Редактировать выбранного пользователя
                            """);
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0){
                return connection;
            }

            switch (choice) {
                case 1 -> showRates(connection);
                case 2 -> createRate(scanner, connection, servicesPath);
                case 3 -> deleteRate(scanner, connection);
                case 4 -> editRate(scanner, connection, servicesPath);
                case 5 -> showUsers(connection);
                case 6 -> createUser(scanner, connection);
                case 7 -> deleteUser(scanner, connection);
                case 8 -> editUser(scanner, connection);
                case 9 -> amountOfUsers(connection);
                case 10 -> sortRatesByPrice(connection);
                case 11 -> searchRatesByPrice(scanner, connection);
                default -> System.out.println("Выбран неправильный пункт меню, повторите ввод.");
            }
        }
    }

    static void showUsers(MobileConnection mobileConnection){
        mobileConnection.getUsers().forEach(user -> System.out.println(user.toString()));
    }

    static void showRates(MobileConnection mobileConnection){
        mobileConnection.getRates().forEach(rate -> System.out.println(rate.toString()));
    }

    static void createUser(Scanner scanner, MobileConnection mobileConnection){
        System.out.println("Введите имя нового пользователя: ");
        String userName = scanner.nextLine();

        System.out.println("Выберите тариф для нового пользователя: ");
        showRates(mobileConnection);
        var ratesNum = scanner.nextInt();
        scanner.nextLine();

        var userRate = mobileConnection.getRates().get(ratesNum);
        User newUser = new User(userName, userRate);
        var users = mobileConnection.getUsers();
        users.add(newUser);
        mobileConnection.setUsers(users);
    }

    static void createRate(Scanner scanner, MobileConnection mobileConnection, String servicesPath){
        System.out.println("Введите название тарифа: ");
        var rateName = scanner.nextLine();

        var rateServices = new ArrayList<Service>();
        System.out.println("Добавим нужные услуги в тариф.");
        while(true){
            System.out.println("""
                    
                    0. Услуг достаточно
                    1. Добавить услугу в тариф
                    """);
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0){
                break;
            }
            if (choice == 1) {
                System.out.println("Выберите сервис к добавлению: ");
                File.servicesReader(servicesPath).forEach(service -> System.out.println(service.toString()));
                rateServices.add(File.servicesReader(servicesPath).get(scanner.nextInt() - 1));
                scanner.nextLine();
            }
        }

        Rate newRate = new Rate(rateName, rateServices);
        var rates = mobileConnection.getRates();
        rates.add(newRate);
        mobileConnection.setRates(rates);
    }

    static void deleteUser(Scanner scanner, MobileConnection mobileConnection){
        System.out.println("Выберите пользователя к удалению: ");
        showUsers(mobileConnection);
        int deleteNum = scanner.nextInt() - 1;
        scanner.nextLine();

        var users = mobileConnection.getUsers();
        users.remove(deleteNum);
        mobileConnection.setUsers(users);
    }

    static void deleteRate(Scanner scanner, MobileConnection mobileConnection){
        System.out.println("Выберите тариф к удалению: ");
        showUsers(mobileConnection);
        int deleteNum = scanner.nextInt() - 1;
        scanner.nextLine();

        var rates = mobileConnection.getRates();
        rates.remove(deleteNum);
        mobileConnection.setRates(rates);
    }

    static void editUser(Scanner scanner, MobileConnection mobileConnection){
        System.out.println("Выберите пользователя к редактированию: ");
        showUsers(mobileConnection);
        var editNum = scanner.nextInt() - 1;
        scanner.nextLine();

        var user = mobileConnection.getUsers().get(editNum);
        System.out.println("Введите новое имя пользователя: ");
        user.setName(scanner.nextLine());
        System.out.println("Выберите новый тариф пользователя: ");
        showRates(mobileConnection);
        var rateNum = scanner.nextInt() - 1;
        scanner.nextLine();
        user.setRate(mobileConnection.getRates().get(rateNum));

        var users = mobileConnection.getUsers();
        users.set(editNum, user);
        mobileConnection.setUsers(users);
    }

    static void editRate(Scanner scanner, MobileConnection mobileConnection, String servicesPath){
        System.out.println("Выберите тариф к редактированию: ");
        showRates(mobileConnection);
        var editNum = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.println("Введите название тарифа: ");
        var rateName = scanner.nextLine();

        var rateServices = new ArrayList<Service>();
        System.out.println("Добавим нужные услуги в тариф.");
        while(true){
            System.out.println("""
                    
                    0. Услуг достаточно
                    1. Добавить услугу в тариф
                    """);
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0){
                break;
            }
            if (choice == 1) {
                System.out.println("Выберите сервис к добавлению: ");
                File.servicesReader(servicesPath).forEach(service -> System.out.println(service.toString()));
                rateServices.add(File.servicesReader(servicesPath).get(scanner.nextInt()));
                scanner.nextLine();
            }
        }

        Rate newRate = new Rate(rateName, rateServices);

        var rates = mobileConnection.getRates();
        rates.set(editNum, newRate);
        mobileConnection.setRates(rates);
    }

    static void amountOfUsers(MobileConnection mobileConnection){
        System.out.println("Количество пользователей в компании: " + mobileConnection.getUsers().size());
    }

    static void sortRatesByPrice(MobileConnection mobileConnection){
        mobileConnection.sortRatesByPrice();
    }

    static void searchRatesByPrice(Scanner scanner, MobileConnection mobileConnection){
        System.out.println("Введите диапазон цен для поиска: ");
        var firstPrice = scanner.nextInt();
        scanner.nextLine();
        var secondPrice = scanner.nextInt();
        scanner.nextLine();

        mobileConnection.getRates().forEach(rate -> {
            if(rate.getPrice() > firstPrice & rate.getPrice() < secondPrice){
                System.out.println(rate);
            }
        });
    }
}
