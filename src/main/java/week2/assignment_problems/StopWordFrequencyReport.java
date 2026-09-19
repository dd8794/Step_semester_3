package week2.assigment_problems;

import java.util.*;

public class StopWordFrequencyReport {

    static void printFilteredWordFrequency(String feedback) {

        String cleanedText = feedback
                .toLowerCase()
                .replace(".", "")
                .replace(",", "");

        String[] words = cleanedText.split("\\s+");

        Set<String> stopWords = new HashSet<>(
                Arrays.asList("the", "was", "and", "a", "is", "of", "in")
        );

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            if (stopWords.contains(word)) {
                continue;
            }

            frequency.put(
                    word,
                    frequency.getOrDefault(word, 0) + 1
            );
        }

        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());

        entries.sort(
                (entry1, entry2) ->
                        entry2.getValue() - entry1.getValue()
        );

        for (Map.Entry<String, Integer> entry : entries) {

            System.out.println(
                    entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback = scanner.nextLine();

        printFilteredWordFrequency(feedback);

        scanner.close();
    }
}
