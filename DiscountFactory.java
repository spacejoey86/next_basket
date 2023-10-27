public class DiscountFactory {
    private static final String WRONG_SPECIFIER_LENGTH_ERROR = "Specifier must be 7 characters";
    private static final String INVALID_SPECIFIER = "Malformed specifier";

    public static Discount createDiscount(String specifier) {
        if (specifier.length() != 7) {
            throw new Error(WRONG_SPECIFIER_LENGTH_ERROR);
        }

        final String itemCode = specifier.substring(0, 3);

        final int minItems;
        try {
            minItems = Integer.parseInt(specifier.substring(3,4));
        } catch (NumberFormatException e) {
            throw new Error(INVALID_SPECIFIER);
        }

        final int discount;
        try {
            discount = Integer.parseInt(specifier.substring(5,7));
        } catch (NumberFormatException e) {
            throw new Error(INVALID_SPECIFIER);
        }

        if (specifier.charAt(4) == 'P') {
            return new PercentageDiscount(itemCode, minItems, discount);
        } else if (specifier.charAt(4) == 'C') {
            return new CashDiscount(itemCode, minItems, discount);
        } else {
            throw new Error(INVALID_SPECIFIER);
        }
    }
}
