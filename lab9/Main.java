package lab9;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void createDefaultFile(String fileName){
        List<Course> courses = new ArrayList<>(List.of(
                new Course("Основы программирования", 1, 1),
                new Course("Математический анализ", 2, 2),
                new Course("Физика", 2, 3),
                new Course("Химия", 2, 4),
                new Course("Биология", 2, 5),
                new Course("История", 3, 6),
                new Course("Литература", 5, 7),
                new Course("Философия", 1, 8),
                new Course("Психология", 1, 9),
                new Course("Социология", 4, 10),
                new Course("Экономика", 4, 11),
                new Course("Менеджмент", 4, 12),
                new Course("Маркетинг", 3, 13),
                new Course("Право", 2, 14),
                new Course("Политология", 1, 15)
        ));

        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            for (Course course : courses) {
                out.writeObject(course);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void showCourses(String fileName) throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            while (true) {
                try {
                    Course course = (Course) in.readObject();
                    System.out.println(course.getName() + " " + course.getLevel() + " " + course.getHours());
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (StreamCorruptedException ignored) {

                }
            }
        }
    }
    public static void addCourse(String fileName, Scanner scanner) {
        System.out.println("Введите название предмета: ");
        String name = scanner.next();

        System.out.println("Введите номер курса: ");
        int level = scanner.nextInt();

        System.out.println("Введите количество часов: ");
        int hours = scanner.nextInt();

        Course course = new Course(name, level, hours);
        try (NoHeaderObjectOutputStream out = new NoHeaderObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(fileName, true)))) {
            out.writeObject(course);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = "src\\lab9\\courses.bin";

        while (true) {
            System.out.println(
                    """

                            Выберете пункт меню:
                            0. Выход
                            1. Показать все элементы файла
                            2. Добавить элемент в файл
                            3. Создать стандартный файл
                            """
            );
            int choice = scanner.nextInt();
            if (choice == 0)
                break;
            if (choice < 0 || choice > 3) {
                System.out.println("Выбран неправильный пункт меню, повторите ввод.");
                continue;
            }

            switch (choice) {
                case 0:
                    break;
                case 1:
                    showCourses(fileName);
                    break;
                case 2:
                    addCourse(fileName, scanner);
                    break;
                case 3:
                    createDefaultFile(fileName);
                    break;
            }
        }

        scanner.close();
    }
}
