import java.util.Scanner;

public class Exam {
    private Question[] questions;
    private int score = 0;

    public Exam() {
        questions = new Question[] {
            new Question("Java is ?", new String[]{"OS", "Language", "Browser", "Editor"}, 2),
            new Question("JVM stands for?", new String[]{"Java Virtual Machine", "Java Visual Model", "Joint VM", "None"}, 1),
            new Question("Which is not OOP concept?", new String[]{"Encapsulation", "Inheritance", "Compilation", "Polymorphism"}, 3)
        };
    }

    public void startExam() {
        Scanner sc = new Scanner(System.in);
        long startTime = System.currentTimeMillis();
        long duration = 60 * 1000; // 1 minute timer

        for (int i = 0; i < questions.length; i++) {
            if (System.currentTimeMillis() - startTime > duration) {
                System.out.println("\n⏰ Time Over! Auto Submitting Exam...");
                break;
            }

            System.out.println("\nQ" + (i + 1) + ": " + questions[i].question);
            for (int j = 0; j < 4; j++) {
                System.out.println((j + 1) + ". " + questions[i].options[j]);
            }

            System.out.print("Your Answer: ");
            int ans = sc.nextInt();

            if (ans == questions[i].correctAnswer) {
                score++;
            }
        }
        System.out.println("\nExam Submitted Successfully!");
        System.out.println("Your Score: " + score + "/" + questions.length);
    }
}
