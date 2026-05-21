package expense_project;

import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static HashMap<String, String> users = new HashMap<>();

    public static void main(String[] args) {

        ExpenseService service = new ExpenseService();

        while (true) {

            System.out.println("\n===== Expense Tracker System =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.println("Enter Choice:");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    register();
                    break;

                case 2:
                    if (login()) {
                        expenseMenu(service);
                    }
                    break;

                case 3:
                    System.out.println("Thank You");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    public static void register() {

        System.out.println("Enter Username:");
        String username = sc.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username Already Exists");
            return;
        }

        System.out.println("Enter Password:");
        String password = sc.nextLine();

        users.put(username, password);

        System.out.println("Registration Successful");
    }

    public static boolean login() {

        System.out.println("Enter Username:");
        String username = sc.nextLine();

        System.out.println("Enter Password:");
        String password = sc.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login Successful");
            return true;
        }

        System.out.println("Invalid Username or Password");
        return false;
    }

    public static void expenseMenu(ExpenseService service) {

        while (true) {

            System.out.println("\n===== Expense Menu =====");
            System.out.println("1. Add Expense");
            System.out.println("2. Update Expense");
            System.out.println("3. Delete Expense");
            System.out.println("4. View Expenses");
            System.out.println("5. Search Expense");
            System.out.println("6. Generate Report");
            System.out.println("7. Logout");

            System.out.println("Enter Choice:");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    service.addExpense();
                    break;

                case 2:
                    service.updateExpense();
                    break;

                case 3:
                    service.deleteExpense();
                    break;

                case 4:
                    service.viewExpenses();
                    break;

                case 5:
                    service.searchExpense();
                    break;

                case 6:
                    service.generateReport();
                    break;

                case 7:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
