public class Main {
    public static void main(String[] args) {
        ShoppingBag myShoppingBag = new ShoppingBag();

        // myShoppingBag.addItem(new Item("ABC010"));
        // myShoppingBag.addItem(new Item("ABC010"));
        // myShoppingBag.addItem(new Item("DEF020"));

        myShoppingBag.addDiscount(DiscountFactory.createDiscount("ABC2P50"));
        myShoppingBag.addDiscount(DiscountFactory.createDiscount("DEF1C05"));

        System.out.println("Total cost: £" + myShoppingBag.getTotalCost());
    }
}
