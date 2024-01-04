package model;

import enums.SPLIT_TYPE;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    private String id;
    private String description;
    private double amount;
    private User paidBy;
    SPLIT_TYPE splitType;
    List<Split> splits = new ArrayList<>();

    public Expense(String id, String description, double amount, User paidBy, SPLIT_TYPE splitType, List<Split> splits) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splitType = splitType;
        this.splits.addAll(splits);
    }
}
