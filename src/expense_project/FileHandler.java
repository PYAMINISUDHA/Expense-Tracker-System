package expense_project;
import java.io.*;
import java.util.*;

public class FileHandler {

    public static void saveExpenses(ArrayList<Expense> expenses) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("expenses.txt"));

            for (Expense e : expenses) {
                bw.write(e.getId() + "," + e.getAmount() + "," + e.getCategory() + "," + e.getDescription());
                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {
            System.out.println("Error Saving File");
        }
    }

    public static ArrayList<Expense> loadExpenses() {

        ArrayList<Expense> list = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("expenses.txt"));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                double amount = Double.parseDouble(data[1]);
                String category = data[2];
                String description = data[3];

                list.add(new Expense(id, amount, category, description));
            }

            br.close();

        } catch (IOException e) {
            System.out.println("No Previous Expense Data Found");
        }

        return list;
    }
}