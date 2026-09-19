package week7.class_problems;

public class QuizScorecard {

    private final boolean[] results;
    private int answerCount;

    public QuizScorecard(int totalQuestions) {

        if (totalQuestions < 0) {
            totalQuestions = 0;
        }

        results = new boolean[totalQuestions];
        answerCount = 0;
    }

    public void recordAnswer(boolean correct) {

        if (answerCount >= results.length) {
            System.out.println("No more answers can be recorded.");
            return;
        }

        results[answerCount] = correct;
        answerCount++;
    }

    public int getScore() {

        int score = 0;

        for (int i = 0; i < answerCount; i++) {

            if (results[i]) {
                score++;
            }
        }

        return score;
    }

    public static void main(String[] args) {

        QuizScorecard sc = new QuizScorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}
