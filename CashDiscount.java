public class CashDiscount extends Discount {
    private int discount;

    public CashDiscount(String itemCode, int minItems, int discount) {
        super(itemCode, minItems);
        this.discount = discount;
    }

    public int discountedPrice(Item item) {
        if (item.getCode().equals(this.getItemCode())) {
            return Math.max(item.getPrice() - this.discount, 0);
        } else {
            return item.getPrice();
        }
    }
}
