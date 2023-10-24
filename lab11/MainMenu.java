package lab11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    static void show(Scanner scanner, String servicesPath, String connectionsPath){

        while(true){
            System.out.println("""
                    
                    Выберите пункт меню:
                    0. Выход
                    1. Вывести список существующих услуг
                    2. Создать новую услугу
                    3. Удалить выбранную услугу
                    4. Редактировать существующую услугу
                    5. Вывести список существующих мобильных компаний
                    6. Создать новую мобильную компанию
                    7. Удалить существующую мобильную компанию
                    8. Редактировать существующую мобильную компанию
                    9. Обнулить всё до стандартных значений
                    """);
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0){
                break;
            }

            switch (choice) {
                case 1 -> showServices(servicesPath);
                case 2 -> createService(scanner, servicesPath);
                case 3 -> deleteService(scanner, servicesPath);
                case 4 -> editService(scanner, servicesPath);
                case 5 -> showConnections(connectionsPath);
                case 6 -> createConnection(scanner, connectionsPath);
                case 7 -> deleteConnection(scanner, connectionsPath);
                case 8 -> editConnection(scanner, connectionsPath, servicesPath);
                case 9 -> createDefaultFiles(servicesPath, connectionsPath);
                default -> System.out.println("Выбран неправильный пункт меню, повторите ввод.");
            }
        }
    }

    static void showServices(String path){
        List<Service> services = File.servicesReader(path);
        services.forEach(service -> System.out.println(service.toString()));
    }

    static void createService(Scanner scanner, String path){
        String serviceName = "";
        System.out.println("Введите имя услуги: ");
        serviceName = scanner.nextLine();

        int servicePrice = 0;
        System.out.println("Введите цену услуги: ");
        servicePrice = scanner.nextInt();
        scanner.nextLine();

        File.append(new Service(serviceName, servicePrice), path);
    }

    static void deleteService(Scanner scanner, String path){
        MainMenu.showServices(path);
        List<Service> services = File.servicesReader(path);

        System.out.println("Введите номер услуги к удалению: ");
        int deleteNum = scanner.nextInt() - 1;
        scanner.nextLine();

        services.remove(deleteNum);
        File.servicesWriter(services, path);
    }

    static void editService(Scanner scanner, String path){
        MainMenu.showServices(path);
        List<Service> services = File.servicesReader(path);
        System.out.println("Введите номер услуги к редактированию: ");
        int editNum = scanner.nextInt();
        scanner.nextLine();

        Service editedService = services.get(editNum - 1);
        System.out.println("Введите новое имя услуги: ");
        editedService.setName(scanner.nextLine());
        System.out.println("Введите новую цену услуги: ");
        editedService.setPrice(scanner.nextInt());
        services.set(editNum - 1, editedService);

        File.servicesWriter(services, path);
    }

    static void showConnections(String path){
        List<MobileConnection> mobileConnections = File.mobileConnectionsReader(path);
        mobileConnections.forEach(mobileConnection -> System.out.println(mobileConnection.toString()));
    }

    static void createConnection(Scanner scanner, String path){
        System.out.println("Введите имя для новой компании: ");
        String connectionName = scanner.nextLine();

        MobileConnection mobileConnection = new MobileConnection(connectionName,
                new ArrayList<Rate>(),
                new ArrayList<User>());

        File.append(mobileConnection, path);
    }

    static void deleteConnection(Scanner scanner, String path){
        MainMenu.showConnections(path);
        List<MobileConnection> connections = File.mobileConnectionsReader(path);

        System.out.println("Введите номер компании к удалению: ");
        int deleteNum = scanner.nextInt() - 1;
        scanner.nextLine();

        connections.remove(deleteNum);
        File.mobileConnectionsWriter(connections, path);
    }

    static void editConnection(Scanner scanner, String connectionsPath, String servicesPath){
        MainMenu.showConnections(connectionsPath);
        System.out.println("Введите номер компании к редактированию: ");
        var editNum = scanner.nextInt() - 1;
        scanner.nextLine();
        var connections = File.mobileConnectionsReader(connectionsPath);
        var connection = connections.get(editNum);

        connections.set(editNum, SecondaryMenu.show(scanner, connection, servicesPath));
    }

    public static void createDefaultFiles(String servicesPath, String connectionsPath){
        List<Service> services = new ArrayList<>(List.of(
                new Service("Звонки", 5),
                new Service("Интернет", 10),
                new Service("СМС", 20)
        ));

        File.servicesWriter(services, servicesPath);

        List<Rate> rates = new ArrayList<>(List.of(
                new Rate("Бабушкин", List.of(
                        services.get(0),
                        services.get(2)
                )),
                new Rate("Студенческий", List.of(
                        services.get(0),
                        services.get(1)
                ))
        ));

        List<User> users = new ArrayList<>(List.of(
                new User("Наталья Петровна", rates.get(0)),
                new User("Максимка", rates.get(1))
        ));

        List<MobileConnection> mobileConnections = List.of(new MobileConnection("МТС", rates, users));
        File.mobileConnectionsWriter(mobileConnections, connectionsPath);
    }
}
