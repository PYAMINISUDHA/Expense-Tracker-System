package expense_project;
import java.util.*;
public class ExpenseService implements ExpenseOperations {

    Scanner sc = new Scanner(System.in);

    ArrayList<Expense> expenses = FileHandler.loadExpenses();

    @Override
    public void addExpense() {

        try {

            System.out.println("Enter Expense ID:");
            int id = sc.nextInt();

            for (Expense e : expenses) {
                if (e.getId() == id) {
                    System.out.println("Duplicate ID Not Allowed");
                    return;
                }
            }

            System.out.println("Enter Amount:");
            double amount = sc.nextDouble();
            sc.nextLine();

            System.out.println("Enter Category:");
            String category = sc.nextLine();

            System.out.println("Enter Description:");
            String description = sc.nextLine();

            Expense expense = new Expense(id, amount, category, description);

            expenses.add(expense);

            FileHandler.saveExpenses(expenses);

            System.out.println("Expense Added Successfully");

        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
            sc.nextLine();
        }
    }

    @Override
    public void updateExpense() {

        System.out.println("Enter Expense ID To Update:");
        int id = sc.nextInt();
        sc.nextLine();

        for (Expense e : expenses) {

            if (e.getId() == id) {

                System.out.println("Enter New Amount:");
                double amount = sc.nextDouble();
                sc.nextLine();

                System.out.println("Enter New Category:");
                String category = sc.nextLine();

                System.out.println("Enter New Description:");
                String description = sc.nextLine();

                e.setAmount(amount);
                e.setCategory(category);
                e.setDescription(description);

                FileHandler.saveExpenses(expenses);

                System.out.println("Expense Updated Successfully");
                return;
            }
        }

        System.out.println("Expense Not Found");
    }

    @Override
    public void deleteExpense() {

        System.out.println("Enter Expense ID To Delete:");
        int id = sc.nextInt();

        Iterator<Expense> iterator = expenses.iterator();

        while (iterator.hasNext()) {

            Expense e = iterator.next();

            if (e.getId() == id) {

                iterator.remove();

                FileHandler.saveExpenses(expenses);

                System.out.println("Expense Deleted Successfully");
                return;
            }
        }

        System.out.println("Expense Not Found");
    }

    @Override
    public void viewExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("No Expenses Available");
            return;
        }

        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    @Override
    public void searchExpense() {

        System.out.println("Enter Expense ID To Search:");
        int id = sc.nextInt();

        for (Expense e : expenses) {

            if (e.getId() == id) {
                System.out.println(e);
                return;
            }
        }

        System.out.println("Expense Not Found");
    }

    @Override
    public void generateReport() {

        double total = 0;

        for (Expense e : expenses) {
            total += e.getAmount();
        }

        System.out.println("Total Expense: " + total);
    }

}
