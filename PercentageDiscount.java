public class PercentageDiscount extends Discount {
    private int discount;
    private static final String INVALID_PERCENT_ERROR = "Percentage discount not in range [0,100]";

    public int discountedPrice(Item item) {
        if (item.getCode().equals(this.getItemCode())) {
            return item.getPrice() * this.discount / 100;
        } else {
            return item.getPrice();
        }
    }

    public PercentageDiscount(String itemCode, int minItems, int discount) {
        super(itemCode, minItems);
        if (discount > 100 || discount < 0) {
            throw new Error(INVALID_PERCENT_ERROR);
        }
        this.discount = discount;
    }
}
