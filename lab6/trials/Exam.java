package lab6.trials;

import java.util.Scanner;

public class Exam extends Trial {
    private String question;
    private String answer;



    public void pass(Scanner scanner){
        double grade = 0.0;

        System.out.print("\nПредставьтесь: ");
        setAuthor(scanner.nextLine());

        System.out.println("\nПриступаем к экзамену, вопрос:\n" + getQuestion());

        System.out.print("Ответ: ");
        setAnswer(scanner.nextLine());

        setGrade(this.check(scanner));
    }

    public int check(Scanner scanner){
        System.out.println("\nПроверяем экзамен.\nВопрос:\n" + getQuestion() + "\nОтвет:\n" + getAnswer());
        System.out.println("\nКакую оценочку ставим? ");

        return scanner.nextInt() * 10;
    }

    public Boolean isPassed(int mark){
        return mark >= 40;
    }

    public Exam(){
        super(0,"");
        setAnswer("");
        setQuestion("");
    }

    public Exam(String question, String answer, String author, int grade){
        super(grade, author);
        setQuestion(question);
        setAnswer(answer);
    }

    private String getQuestion(){ return this.question; }
    private String getAnswer() { return answer; }

    public void setAnswer(String answer) { this.answer = answer; }
    public void setQuestion(String question) { this.question = question; }
}
