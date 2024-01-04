package factory;

import enums.SPLIT_TYPE;
import model.*;

public class SplitFactory {
    public static ExpenseSplit getSplitObject(SPLIT_TYPE splitType) {
        switch (splitType) {
            case EQUAL:
                return new EqualExpenseSplit();
            case UNEQUAL:
                return new UnequalExpenseSplit();
            case PERCENTAGE:
                return new PercentageExpenseSplit();
            default:
                return null;
        }
    }
}
