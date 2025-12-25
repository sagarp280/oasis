import java.util.Scanner;

public class ExamOperations {
    private User user;
    private Scanner sc = new Scanner(System.in);

    public ExamOperations(User user) {
        this.user = user;
    }

    public boolean login(String u, String p) {
        return user.authenticate(u, p);
    }

    public void menu() {
        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Update Profile");
            System.out.println("2. Update Password");
            System.out.println("3. Start Exam");
            System.out.println("4. Logout");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter new name: ");
                    String name = sc.nextLine();
                    user.updateProfile(name);
                    System.out.println("Profile Updated!");
                    break;

                case 2:
                    System.out.print("Enter new password: ");
                    String pass = sc.nextLine();
                    user.updatePassword(pass);
                    System.out.println("Password Updated!");
                    break;

                case 3:
                    Exam exam = new Exam();
                    exam.startExam();
                    break;

                case 4:
                    System.out.println("Session Closed. Logged Out Successfully.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }
}
