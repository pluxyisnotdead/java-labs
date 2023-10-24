package lab6.trials;

import java.util.Scanner;

public class FinalExam extends Exam {
    @Override
    public Boolean isPassed(int mark) {
        return mark >= 50;
    }

    public FinalExam(){
        super();
    }

    public static FinalExam get(Scanner scanner){
        FinalExam exam = new FinalExam();

        System.out.println("Для начала нужно создать экзамен, приступим.");
        System.out.print("\nВведите билет: ");
        exam.setQuestion(scanner.nextLine());

        return exam;
    }

    public FinalExam(String question, String answer, String author, int grade){
        super(question, answer, author, grade);
    }
}
