import java.util.ArrayList;
import java.util.List;

public class ShoppingBag {
    private List<Item> items;
    private List<Discount> discounts;

    public ShoppingBag() {
        this.items = new ArrayList<Item>();
        this.discounts = new ArrayList<Discount>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void addDiscount(Discount discount) {
        this.discounts.add(discount);
    }

    private int countItems(String itemCode) {
        int count = 0;
        for (Item item : items) {
            if (item.getCode().equals(itemCode)) {
                count += 1;
            }
        }
        return count;
    }

    public int getTotalCost() {
        List<Discount> validDiscounts = new ArrayList<Discount>();
        //Filter out dicounts where the minimum amount of matching items is not met
        for (Discount discount : this.discounts) {
            if (this.countItems(discount.getItemCode()) >= discount.getMinItems()) {
                validDiscounts.add(discount);
            }
        }

        int totalCost = 0;
        for (Item item : this.items) {
            int lowestPrice = item.getPrice();
            for (Discount discount : validDiscounts) {
                lowestPrice = Math.min(lowestPrice, discount.discountedPrice(item));
            }
            totalCost += lowestPrice;
        }

        return totalCost;
    }
}
