package com.example.mycode;
import java.util.*;

public class Main {
    static List<Stock> stocks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static User user;

    public static void main(String[] args) {
        user = new User("Alice");

        // Initialize stock list
        stocks.add(new Stock("AAPL", "Apple Inc.", 150));
        stocks.add(new Stock("GOOG", "Google LLC", 2800));
        stocks.add(new Stock("TSLA", "Tesla Motors", 700));

        while (true) {
            System.out.println("\n--- Stock Trading Platform ---");
            System.out.println("1. View Stocks");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Update Stock Prices");
            System.out.println("0. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> viewStocks();
                case 2 -> buyStock();
                case 3 -> sellStock();
                case 4 -> viewPortfolio();
                case 5 -> updatePrices();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void viewStocks() {
        System.out.println("\nAvailable Stocks:");
        for (int i = 0; i < stocks.size(); i++) {
            System.out.println((i + 1) + ". " + stocks.get(i));
        }
    }

    private static void buyStock() {
        viewStocks();
        System.out.print("Enter stock number to buy: ");
        int index = scanner.nextInt() - 1;
        if (index < 0 || index >= stocks.size()) {
            System.out.println("Invalid stock.");
            return;
        }
        System.out.print("Enter quantity: ");
        int qty = scanner.nextInt();
        user.getPortfolio().buyStock(stocks.get(index), qty);
        System.out.println("Stock purchased.");
    }

    private static void sellStock() {
        viewStocks();
        System.out.print("Enter stock number to sell: ");
        int index = scanner.nextInt() - 1;
        if (index < 0 || index >= stocks.size()) {
            System.out.println("Invalid stock.");
            return;
        }
        System.out.print("Enter quantity: ");
        int qty = scanner.nextInt();
        boolean success = user.getPortfolio().sellStock(stocks.get(index), qty);
        if (success) {
            System.out.println("Stock sold.");
        } else {
            System.out.println("You don't have enough shares.");
        }
    }

    private static void viewPortfolio() {
        user.getPortfolio().viewPortfolio();
        System.out.printf("Total Portfolio Value: $%.2f\n", user.getPortfolio().totalValue());
    }

    private static void updatePrices() {
        for (Stock stock : stocks) {
            stock.updatePrice();
        }
        System.out.println("Stock prices updated.");
    }
}