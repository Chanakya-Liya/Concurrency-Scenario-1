import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome");
        int MAX_ORDERS = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.print("Enter the maximum number of orders: ");
                MAX_ORDERS = scanner.nextInt();
                if (MAX_ORDERS < 0) {
                    System.out.println("Number of orders must be non-negative. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        } while (MAX_ORDERS <= 0);

        BlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>(MAX_ORDERS);

        for (int i = 1; i <= 3; i++) {
            Thread customerThread = new Thread(new Customer(i, orderQueue));
            customerThread.start();
        }

        for (int i = 1; i <= 2; i++) {
            Thread baristaThread = new Thread(new Barista(i, orderQueue));
            baristaThread.start();
        }
    }
}