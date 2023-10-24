package lab7;

import java.util.Scanner;



public class Main2 {
    public static String capitalizeWords(String text) {
        String[] words = text.split("[ ]");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.matches("^[a-zA-Zа-яА-яёЁ]+[^a-zA-Zа-яА-яёЁ]*$")) {
                result.append(Character.toUpperCase(word.charAt(0))).append(word, 1, word.length())
                        .append(" ");
            } else {
                result.append(word).append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String text = """
            Вот мысль, кото!рой весьЁ я предан,
            Итог всего,      что умё скопил.
            Лишь тот, кем?! бой за жи,знь изведан,
            Жизнь и свободу заслужил.
        """;

        System.out.println();
        System.out.println(capitalizeWords(text));
    }
}
