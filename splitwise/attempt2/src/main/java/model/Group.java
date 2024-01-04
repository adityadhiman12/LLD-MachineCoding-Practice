package model;

import controller.ExpenseController;
import enums.SPLIT_TYPE;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupId;
    private String groupName;
    private List<User> groupMembers;
    private List<Expense> expenseList;
    private ExpenseController expenseController;

    public Group() {
        groupMembers = new ArrayList<>();
        expenseList = new ArrayList<>();
        expenseController = new ExpenseController();
    }

    public void addMember(User member) {
        groupMembers.add(member);
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount, List<Split>splitDetails, SPLIT_TYPE splitType, User paidBy) {
        Expense expense = expenseController.createExpense(expenseId, description, expenseAmount, splitDetails, splitType, paidBy);
        expenseList.add(expense);
        return expense;
    }
}
