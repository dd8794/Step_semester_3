package week7.assigment_problems;

public class ShoppingCart {

    private final String cartId;
    private final double[] prices;
    private int itemCount;

    public ShoppingCart(
            String cartId,
            int maximumItems) {

        this.cartId = cartId;
        this.prices = new double[maximumItems];
        this.itemCount = 0;
    }

    public void addItem(double price) {

        if (itemCount >= prices.length) {
            System.out.println("Cart is full.");
            return;
        }

        if (price < 0) {
            System.out.println("Invalid price.");
            return;
        }

        prices[itemCount] = price;
        itemCount++;
    }

    public double getTotal() {

        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }

        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public static void main(String[] args) {

        ShoppingCart cart =
                new ShoppingCart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println(
                "Total: " + cart.getTotal()
        );

        System.out.println(
                "Item count: " +
                        cart.getItemCount()
        );
    }
}