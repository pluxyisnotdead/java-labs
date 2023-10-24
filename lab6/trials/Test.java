package lab6.trials;


import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Test extends Trial {
    private ArrayList<String> questions;
    private ArrayList<ArrayList<String>> variantsOfAnswers;
    private ArrayList<Integer> answers;
    private ArrayList<Integer> keys;

    public static Test get(Scanner scanner){
        Test test = new Test();

        System.out.println("Для начала нужно создать тест, приступим.");
        System.out.print("\nВведите количество вопросов в тесте: ");
        int amountOfQuestions = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < amountOfQuestions; i++){
            ArrayList<String> tempAnswers = new ArrayList<>();
            System.out.print("\nВопрос " + (i+1) + ": ");

            String tempString = scanner.nextLine();
            test.questions.add(i, tempString);

            System.out.print("Введите количество ответов на этот вопрос: ");
            int amountOfAnswers = Integer.parseInt(scanner.nextLine());

            for (int j = 0; j < amountOfAnswers; j++){
                System.out.print("Ответ " + (j+1) + ": ");
                tempAnswers.add(j, scanner.nextLine());
            }

            test.variantsOfAnswers.add(i, tempAnswers);
        }

        System.out.println("\nТеперь введем правильные ответы для теста.");
        for (var quest : test.questions) {
            System.out.println(quest);
            for (var answer : test.answers) {
                System.out.println(answer);
            }

            System.out.print("Правильный ответ: ");
            test.keys.add(Integer.parseInt(scanner.nextLine()) - 1);
        }

        return test;
    }

    public void pass(Scanner scanner){
        double grade = 0.0;

        System.out.print("\nПредставьтесь: ");
        String author = scanner.nextLine();
        setAuthor(author);

        for (int i = 0; i < getQuestions().size(); i++) {
            int answer = 0;

            System.out.println("\n" + getQuestions().get(i));
            for (int j = 0; j < getVariantsOfAnswers().get(i).size(); j++) {
                System.out.println((j+1) + ". " + getVariantsOfAnswers().get(i).get(j));
            }

            System.out.print("Введите правильный по вашему мнению вариант ответа: ");
            answer = Integer.parseInt(scanner.nextLine());
        }

        grade = check();

        setGrade((int) grade);
    }

    public Test(){
        super(0, "");
        setVariantsOfAnswers(new ArrayList<>());
        setQuestions(new ArrayList<>());
        setAnswers(new ArrayList<>());
        setKeys(new ArrayList<>());
    }

    public Test(ArrayList<ArrayList<String>> variantsOfAnswers, ArrayList<String> questions, ArrayList<Integer> answers, int grade, String author, ArrayList<Integer> keys){
        super(grade, author);
        setVariantsOfAnswers(variantsOfAnswers);
        setQuestions(questions);
        setAnswers(answers);
        setKeys(keys);
    }

    public double check(){
        double rightAnswers = 0;

        for (int i = 0; i < getAnswers().size(); i++){
            if (Objects.equals(getAnswers().get(i), getKeys().get(i))){
                rightAnswers++;
            }
        }

        return (rightAnswers / getAnswers().size()) * 100;
    }

    public ArrayList<ArrayList<String>> getVariantsOfAnswers() { return this.variantsOfAnswers; }
    public ArrayList<String> getQuestions() { return this.questions; }
    public ArrayList<Integer> getAnswers() { return this.answers; }
    public ArrayList<Integer> getKeys() { return this.keys; }

    private void setQuestions(ArrayList<String> questions) { this.questions = questions; }
    private void setVariantsOfAnswers(ArrayList<ArrayList<String>> variantsOfAnswers) { this.variantsOfAnswers = variantsOfAnswers; }
    private void setAnswers(ArrayList<Integer> answers) { this.answers = answers; }
    private void setKeys(ArrayList<Integer> keys) { this.keys = keys; }
}
