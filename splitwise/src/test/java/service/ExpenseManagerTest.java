package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dao.SplitWiseDao;
import model.expense.EqualExpense;

import java.util.*;


public class ExpenseManagerTest {
    private SplitWiseDao splitWiseDao;

    private ExpenseManager expenseManager;

    @BeforeEach
    public void setUp() {
        expenseManager = new ExpenseManager(splitWiseDao);
    }

    @Test
    public void testEqualExpense() {
        ArrayList<String> users = new ArrayList<>();
        users.add("u1");
        users.add("u2");
        users.add("u3");
        users.add("u4");
        expenseManager.addExpense("u1", "Meghna", (double)1000, users, new EqualExpense());
        expenseManager.showBalances("u4");
        expenseManager.showBalances("u1");
    }
}
