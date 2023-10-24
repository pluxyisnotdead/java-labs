package lab4;

public class Main2 {
    public static void main(String[] args){
        Date date = Date.get();

        System.out.println("\nДата: " + date + "\n");

        System.out.println("Равен ли месяц дню в дате: " + date.isMonthEqualsDay());

        date.nextMonth();

        System.out.println("\nДата через месяц: " + date + "\n");

        System.out.println("Равен ли месяц дню в дате: " + date.isMonthEqualsDay());
    }
}
