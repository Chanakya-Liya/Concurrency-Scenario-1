import java.util.concurrent.BlockingQueue;

public class Barista implements Runnable{
    private final int baristaId;
    private final BlockingQueue<Order> orderQueue;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String CYAN_BOLD = "\033[1;36m";

    public Barista(int baristaId, BlockingQueue<Order> orderQueue) {
        this.baristaId = baristaId;
        this.orderQueue = orderQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(CYAN_BOLD + "Barista "+ ANSI_RESET+ ANSI_BLUE + baristaId + " is waiting for orders." + ANSI_RESET);
                Order order = orderQueue.take();
                System.out.println(CYAN_BOLD + "Barista "+ ANSI_RESET + ANSI_YELLOW + baristaId + " is preparing order: " + order.getOrderId() + ANSI_RESET);
                Thread.sleep((long) (Math.random() * 5000));
                System.out.println(CYAN_BOLD + "Barista " + ANSI_RESET + ANSI_GREEN + baristaId + " has completed order: " + order.getOrderId() + ANSI_RESET);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(CYAN_BOLD + "Barista " + ANSI_RESET + ANSI_RED + baristaId + " interrupted." + ANSI_RESET);
        }
    }
}
