import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        User user = new User("101", "1234");
        Account account = new Account(5000);
        ATMOperations atm = new ATMOperations(user, account);

        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        if (atm.authenticate(userId, pin)) {
            atm.showMenu();
        } else {
            System.out.println("Invalid Credentials. Access Denied.");
        }
        sc.close();
    }
}
