package com.example.mycode;
import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private Map<Stock, Integer> holdings = new HashMap<>();

    public void buyStock(Stock stock, int quantity) {
        holdings.put(stock, holdings.getOrDefault(stock, 0) + quantity);
    }

    public boolean sellStock(Stock stock, int quantity) {
        if (!holdings.containsKey(stock) || holdings.get(stock) < quantity) {
            return false;
        }
        holdings.put(stock, holdings.get(stock) - quantity);
        if (holdings.get(stock) == 0) holdings.remove(stock);
        return true;
    }

    public void viewPortfolio() {
        System.out.println("Your Portfolio:");
        if (holdings.isEmpty()) {
            System.out.println(" - No stocks owned.");
        } else {
            for (Map.Entry<Stock, Integer> entry : holdings.entrySet()) {
                Stock stock = entry.getKey();
                int qty = entry.getValue();
                System.out.printf(" - %s (%s): %d shares ($%.2f each)\n",
                        stock.getName(), stock.getSymbol(), qty, stock.getPrice());
            }
        }
    }

    public double totalValue() {
        double total = 0;
        for (Map.Entry<Stock, Integer> entry : holdings.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
}
