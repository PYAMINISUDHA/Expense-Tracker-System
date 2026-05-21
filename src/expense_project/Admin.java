package expense_project;

public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
    }

    public void adminMessage() {
        System.out.println("Admin Login Successful");
    }
}

