package controller;

import enums.SPLIT_TYPE;
import factory.SplitFactory;
import model.Expense;
import model.ExpenseSplit;
import model.Split;
import model.User;

import java.util.List;

public class ExpenseController {
    BalanceSheetController balanceSheetController;

    public ExpenseController() {
        balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount, List<Split> splitDetails, SPLIT_TYPE splitType, User paidBy) {
        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(splitType);
        expenseSplit.validateSplitRequest(splitDetails, expenseAmount);
        Expense expense = new Expense(expenseId,description, expenseAmount, paidBy, splitType, splitDetails);
        balanceSheetController.updateuserExpenseBalanceSheet(paidBy, splitDetails, expenseAmount);
        return expense;
    }

}
