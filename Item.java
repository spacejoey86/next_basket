public class Item {
    private static final String WRONG_FORMAT_ERROR = "Shopping bag items will be passed in the format ABC123";
    private static final String MALFORMED_PRICE_ERROR = "123 (3 characters) is the cost of the item";

    private String code;
    private int price;

    public Item(String specifier) {
        if (specifier.length() != 6) {
            throw new Error(WRONG_FORMAT_ERROR);
        }
        this.code = specifier.substring(0, 3);
        try {
            this.price = Integer.parseInt(specifier.substring(3,6));
        } catch (NumberFormatException e) {
            throw new Error(MALFORMED_PRICE_ERROR);
        }
    }

    public String getCode() {
        return this.code;
    }

    public int getPrice() {
        return this.price;
    }
}
