public abstract class Discount {
    private String itemCode;
    private int minItems;

    public abstract int discountedPrice(Item item);

    public Discount(String itemCode, int minItems) {
        this.itemCode = itemCode;
        this.minItems = minItems;
    }

    public int getMinItems() {
        return this.minItems;
    }

    public String getItemCode() {
        return this.itemCode;
    }
}

