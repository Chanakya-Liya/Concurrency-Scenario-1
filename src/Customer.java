import java.util.concurrent.BlockingQueue;

public class Customer implements Runnable {
    private final int customerId;
    private final BlockingQueue<Order> orderQueue;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String PURPLE_BOLD = "\033[1;35m";

    public Customer(int customerId, BlockingQueue<Order> orderQueue) {
        this.customerId = customerId;
        this.orderQueue = orderQueue;
    }



    @Override
    public void run() {
        try {
            while (true) {
                Order order = new Order();
                System.out.println(PURPLE_BOLD + "Customer " + ANSI_RESET + ANSI_YELLOW + customerId + " is placing an order." + ANSI_RESET);
                orderQueue.put(order);
                System.out.println(PURPLE_BOLD + "Customer " + ANSI_RESET + ANSI_GREEN + customerId + " has placed order: " + order.getOrderId() + ANSI_RESET);
                Thread.sleep((long) (Math.random() * 3000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(PURPLE_BOLD +  "Customer "+ ANSI_RESET + ANSI_RED + customerId + " interrupted." + ANSI_RESET);
        }
    }
}
