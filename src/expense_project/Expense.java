package expense_project;
public class Expense {

    private int id;
    private double amount;
    private String category;
    private String description;

    public Expense(int id, double amount, String category, String description) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return id + " | " + amount + " | " + category + " | " + description;
    }
}