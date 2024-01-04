package model;

public class User {
    private String userId;
    private String userName;
    UserExpenseBalanceSheet balanceSheet;

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.balanceSheet = new UserExpenseBalanceSheet();
    }

    public String getUserId() {
        return userId;
    }

    public UserExpenseBalanceSheet getBalanceSheet() {
        return balanceSheet;
    }

    public UserExpenseBalanceSheet getUserExpenseBalanceSheet() {
        return balanceSheet;
    }
}
