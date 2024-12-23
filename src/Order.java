public class Order {
    private static int id = 1;
    private final int orderId;

    public Order(){
        this.orderId = id++;
    }

    public int getOrderId() {
        return orderId;
    }
}
