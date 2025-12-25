import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        User user = new User("student", "1234", "Student One");
        ExamOperations examOps = new ExamOperations(user);

        System.out.println("===== ONLINE EXAMINATION SYSTEM =====");

        System.out.print("Username: ");
        String uname = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        if (examOps.login(uname, pass)) {
            examOps.menu();
        } else {
            System.out.println("Invalid Login Credentials.");
        }
        sc.close();
    }
}
