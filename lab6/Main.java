package lab6;
import lab6.trials.Exam;
import lab6.trials.FinalExam;
import lab6.trials.Test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FinalExam finalExam = FinalExam.get(scanner);

        finalExam.pass(scanner);

        System.out.println(finalExam.
                getGrade());
        System.out.println(finalExam.isPassed(finalExam.getGrade()));
    }
}
