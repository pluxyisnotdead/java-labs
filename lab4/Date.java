package lab4;

import java.util.Scanner;

public class Date {
    private int day;
    private int month;
    private int year;

    Date(){
        setDay(0);
        setMonth(0);
        setYear(0);
    }

    Date(int day, int month, int year){
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public static Date get(){
        Scanner scanner = new Scanner(System.in);
        int temp;
        Date object = new Date();
        System.out.println("Определим дату.\n");

        while (true){
            System.out.print("Введите день: ");
            temp = Integer.parseInt(scanner.next());
            if (temp < 31 && temp > 0){
                object.setDay(temp);
                break;

            } else {
                System.out.println("\nНекорретное значение для дня.\n");
            }
        }

        while (true) {
            System.out.print("Введите месяц: ");
            temp = Integer.parseInt(scanner.next());
            if (temp < 13 && temp > 0){
                object.setMonth(temp);
                break;

            } else {
                System.out.println("\nНекорретное значение для месяца.\n");
            }
        }

        while (true) {
            System.out.print("Введите год: ");
            temp = Integer.parseInt(scanner.next());
            if (temp > 0 && temp < 10000){
                object.setYear(temp);
                break;

            } else {
                System.out.println("\nНекорретное значение для года.\n");
            }
        }

        return object;
    }

    public int getDay(){ return this.day; }
    public void setDay(int day){ this.day = day; }
    public int getMonth(){ return this.month; }
    public void setMonth(int month){ this.month = month; }
    public int getYear(){ return this.year; }
    public void setYear(int year){ this.year = year; }

    public String toString(){
        String string = "";

        if (Integer.toString(getDay()).length() == 1){
            string += "0" + getDay() + ".";
        }
        else{
            string += day + ".";
        }

        if (Integer.toString(getMonth()).length() == 1){
            string += "0" + getMonth() + ".";
        }
        else{
            string += month + ".";
        }

        if (Integer.toString(getYear()).length() == 1){
            string += "000" + getYear();
        }

        if (Integer.toString(getYear()).length() == 2){
            string += "00" + getYear();
        }

        if (Integer.toString(getYear()).length() == 3){
            string += "0" + getYear();
        }

        if (Integer.toString(getYear()).length() == 4){
            string += getYear();
        }

        return string;
    }

    private void reload(){
        if (getDay() > 30){
            setDay(1);
            setMonth(getMonth() + 1);
            if (month > 12){
                setMonth(1);
                setYear(getYear() + 1);
            }
        }

        if (getMonth() > 12){
            setMonth(1);
            setYear(getYear() + 1);
        }
    }

    public boolean isMonthEqualsDay(){ return getDay() == getMonth(); }

    public void nextMonth(){
        setMonth(getMonth() + 1);
        reload();
    }
}
