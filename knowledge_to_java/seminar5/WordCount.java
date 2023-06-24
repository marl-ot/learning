package knowledge_to_java.seminar5;

import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        String text = "Россия идет вперед всей планеты. Планета — это не Россия.";
        String searchWord = "Россия";

        int count = countWordOccurrences(text, searchWord);
        System.out.println("Ответ: " + searchWord + " - " + count);
    }

    public static int countWordOccurrences(String text, String searchWord) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Используем регулярное выражение для удаления пунктуации
        String cleanedText = text.replaceAll("\\p{Punct}", "");

        String[] words = cleanedText.split(" ");

        for (String word : words) {
            word = word.toLowerCase();

            if (word.equals(searchWord.toLowerCase())) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        // Возвращаем количество вхождений искомого слова
        return wordCountMap.getOrDefault(searchWord.toLowerCase(), 0);
    }
}
